package br.com.non.blocking.core.app;

public class AppClients {

	public String informarCLients() {
		
		try {
			Thread.sleep(2000);
			System.out.println("Execute AppCLients - " + TimeUtil.getTime());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "Clients informado";
	}
	
}
