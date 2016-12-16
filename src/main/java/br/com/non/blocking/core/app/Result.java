package br.com.non.blocking.core.app;

public class Result {
	
	private String appCLients;
	
	private String dataSource;
	
	public Result(String appClients, String dataSource) {
		this.appCLients = appClients;
		this.dataSource = dataSource;
	}
	
	public String getAppCLients() {
		return appCLients;
	}

	public String getDataSource() {
		return dataSource;
	}

}