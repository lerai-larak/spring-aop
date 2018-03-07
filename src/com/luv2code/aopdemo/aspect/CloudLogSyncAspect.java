package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLogSyncAspect {

	@Before("com.luv2code.aopdemo.aspect.SharedExpressions.forDaoPackage()")
	public void logToCloudAsync() {
			System.out.println("Applying cloud logging aspect");
	}
}
