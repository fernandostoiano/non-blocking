package br.com.non.blocking.core.app;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Component;

@Component
public class ApplicationService {
	
	private AppClients appClients;
	
	private DataSource dataSource;
	
	private String appClientsResult;
	
	private String dataSourceResult;
	
	public ApplicationService() {
		this.appClients = new AppClients();
		this.dataSource = new DataSource();
	}
	
	public void execAssync() {
		
		CompletableFuture<String> appClients = 
				CompletableFuture.supplyAsync(() -> this.appClients.informarCLients());
		
		CompletableFuture<String> dataSource = 
				CompletableFuture.supplyAsync(() -> this.dataSource.gravarNoBanco());
		
		
		appClients.thenAccept(result -> {
			System.out.println("-----------AppClients--------------" + result);
		});
		
		dataSource.thenAccept(result -> {
			System.out.println("-----------DataSource--------------" + result);
		});
	}
	
	public void execNormal() {
		
		System.out.println("-----------AppClients--------------" + this.appClients.informarCLients());
		
		System.out.println("-----------DataSource--------------" + this.dataSource.gravarNoBanco());
	}
	
	public CompletableFuture<Result> get() {
		
		CompletableFuture<String> appClients = 
				CompletableFuture.supplyAsync(() -> this.appClients.informarCLients());
		
		CompletableFuture<String> dataSource = 
				CompletableFuture.supplyAsync(() -> this.dataSource.gravarNoBanco());
		
		
		appClients.thenAccept(result -> {
			this.appClientsResult = result;
		});
		
		dataSource.thenAccept(result -> {
			this.dataSourceResult = result;
		});
		
		CompletableFuture<Result> myReturn = appClients
				.thenApply(this::getResultAppClients)
				.thenCompose(this::joinDataSourceResult)
				.thenApply(strings -> new Result(strings));
		
		return myReturn;
	}
	
	private CompletableFuture<String> getResultAppClients(String appClients) {
		
		
		return null;
	}
	
	private CompletableFuture<List<String>> joinDataSourceResult(CompletableFuture<String> appClients) {
		
		
		return null;
	}
}
