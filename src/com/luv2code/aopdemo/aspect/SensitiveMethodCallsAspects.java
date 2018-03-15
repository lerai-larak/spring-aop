package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Aspect
@Component
@Order(3)
public class SensitiveMethodCallsAspects {

	@Before("com.luv2code.aopdemo.aspect.SharedExpressions.forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println(this.getClass() + ": Applying sensitive method aspect");
		
	}
}
