package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//this class contains a set of advices
	
	@Before("execution(* add*())") //match any method that starts with 'add' and retun type is void
//	@Before("execution(public void updateAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====> Executing @Before advice on method addAccount()");
	}
}
