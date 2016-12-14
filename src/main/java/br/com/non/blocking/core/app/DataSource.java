package br.com.non.blocking.core.app;

public class DataSource {
	
	
	public String gravarNoBanco() {
		
		try {
			Thread.sleep(2000);
			System.out.println("Execute DataSource - " + TimeUtil.getTime());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Gravado no banco";
	}
}
