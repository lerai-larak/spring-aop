package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Aspect
@Component
@Order(2)
public class ApiAnalyticsAspect {

	@Before("com.luv2code.aopdemo.aspect.SharedExpressions.forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("Applying api analytics aspect");
	}
}
