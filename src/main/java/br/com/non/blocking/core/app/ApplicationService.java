package br.com.non.blocking.core.app;

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
		
		this.otherProcess();
		
		CompletableFuture<Result> myReturn = CompletableFuture.supplyAsync(() -> new Result(this.appClientsResult, this.dataSourceResult));
		
		return myReturn;
	}

	private void otherProcess() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}	
