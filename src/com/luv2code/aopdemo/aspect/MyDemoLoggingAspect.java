package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//this class contains a set of advices
	
	//match an add method any return type, and any parameter 
	@Before("execution(* add*(..))") 
	public void beforeAddAccountAdvice() {
		System.out.println("\n___________________________________________________________>"
				+ "\n Executing @Before advice on method addAccount(Account,boolean)"
				+ "\n__________________________________________________________> ");
	}
}
