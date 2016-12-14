package br.com.non.blocking.core.app;

import java.util.List;

public class Result {
	
	private String appCLients;
	
	private String dataSource;
	
	public Result(List<String> strings) {
		appCLients = strings.get(0);
		dataSource = strings.get(1);
	}
	
	public String getAppCLients() {
		return appCLients;
	}

	public String getDataSource() {
		return dataSource;
	}

}