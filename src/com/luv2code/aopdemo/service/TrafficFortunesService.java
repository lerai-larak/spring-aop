package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortunesService {
	
	public String getFortune() {
		
		try {
			//simulate a delay
			TimeUnit.SECONDS.sleep(5);
			
		}catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return "Expect traffic this morning...";
	}

}
