package br.com.non.blocking.core;

import java.util.Calendar;
import java.util.concurrent.CompletableFuture;

public class Testes {
	
	
	public static void main(String[] args) throws InterruptedException {
		final CompletableFuture<String> c1 = new CompletableFuture<>();
        /*new Thread(() -> c1.complete(Testes.get())).start();
        c1.thenAccept(str -> System.out.println(str));
        Thread.sleep(1000);*/
		long time = System.currentTimeMillis();
		Calendar start = Calendar.getInstance();
		start.setTimeInMillis(time);
		System.out.println(start.getTime().toString());
        
		try {
			String str = Testes.get();
			System.out.println("Ok = " + str);
		} catch(InterruptedException ex) {
			System.out.println("Erro = " + ex.getMessage());
		}
		Thread.sleep(1000);
		
		
		/*new Thread(() -> {
			try {
				Testes.get();
			} catch(Exception ex) {
				c1.completeExceptionally(ex);
			}
        }).start();
        c1.exceptionally(ex -> {
    		System.out.println("Erro = " + ex.getMessage());
    		return "Erro";
        });
	    c1.thenAccept(str -> System.out.println("Ok = " + str));
	    Thread.sleep(1000);*/
	    
	    time = System.currentTimeMillis();
	    Calendar end = Calendar.getInstance();
		end.setTimeInMillis(time);
		System.out.println(end.getTime().toString());
	}
	
	public static String get() throws InterruptedException {
		
		throw new InterruptedException("Excecao");
	}
	
}
