package br.com.non.blocking.core.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;

import br.com.non.blocking.core.app.ApplicationService;
import br.com.non.blocking.core.app.Result;
import br.com.non.blocking.core.app.TimeUtil;

@Controller
public class ApplicationController {
	
	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private ExecutorService executor;
	
	@RequestMapping("/non-blocking")
	public String index() {
		
		System.out.println("Start - " + TimeUtil.getTime());
		
		applicationService.execAssync();
		
		System.out.println("End - " + TimeUtil.getTime());
		
		return "index";
	}
	
	@RequestMapping("/normal")
	public String normal() {
		
		System.out.println("Start - " + TimeUtil.getTime());
		
		applicationService.execNormal();
		
		System.out.println("End - " + TimeUtil.getTime());
		
		return "index";
		
	}
	
	@RequestMapping(value = "/get",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public DeferredResult<ResponseEntity<Result>> get() {
		
		 DeferredResult<ResponseEntity<Result>> deferredResult = new DeferredResult<>();
		
		CompletableFuture.supplyAsync(() -> applicationService.get(), executor)
				.whenCompleteAsync((response, e) -> {
					response.exceptionally(ex -> {
						deferredResult.setErrorResult(null);
						return null;
					});
					response.thenAccept(result -> {
						deferredResult.setResult(new ResponseEntity<>(result, HttpStatus.OK));
					});
				});
		
		
		return deferredResult;
	}
	
}
