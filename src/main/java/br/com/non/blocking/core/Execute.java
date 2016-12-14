package br.com.non.blocking.core;

import br.com.non.blocking.core.app.ApplicationService;
import br.com.non.blocking.core.app.TimeUtil;

public class Execute {

	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Start - " + TimeUtil.getTime());
		
		ApplicationService applicationService = new ApplicationService();
		
		applicationService.execAssync();
		Thread.sleep(2500);
		
//		applicationService.execNormal();
		
		System.out.println("End - " + TimeUtil.getTime());
	}
	
}
