package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortunesService;

public class AroundDemoAppWithLogger {

	private static Logger logger = 
			Logger.getLogger(AroundDemoAppWithLogger.class.getSimpleName());
	
	public static void main(String[] args) {
		
		
		//read spring configuration
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		TrafficFortunesService myFortuneService = 
				context.getBean("trafficFortunesService",TrafficFortunesService.class);
		
		logger.info("Inside Main");
		logger.info("Calling getFortuneService ...");
		
		logger.info("Results from method call: " + myFortuneService.getFortune());
		logger.info("Finished ");
		//close the context
		context.close();
	}
}
