package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//this class contains a set of advices
	
	//match any method in any class inside package dao with any return type, with 0 or more params
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))") 
	public void beforeAddAccountAdvice() {
		System.out.println("\n___________________________________________________________>"
				+ "\n Executing @Before advice on methods in package dao"
				+ "\n__________________________________________________________> ");
	}
}
