package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 
 * @author kelly
 * Aspect: a module or block of code for cross-cutting concerns e.g logging, security etc.
 * Advice: What advice is taken and when should it be applied
 */

//@Aspect
//@Component
//@Order(1)
public class MyDemoLoggingAspect {

//	
//	//create a pointcut declaration
//	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
//	public void forDaoPackage() {}
//	
//	//match any method in any class inside package dao with any return type, with 0 or more params
//	@Before("forDaoPackage()") //refer to the pointcut declared above
//	public void beforeAddAccountAdvice() {
//		System.out.println(this.getClass() + ": Perfomming some task before account is created");
//		
//	}
//	

	
	
}