package br.com.non.blocking.core.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
	
	
	@Bean
    public ExecutorService executorService() {
        return new ThreadPoolExecutor(20,
                40,
                100,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(40));
    }

}
