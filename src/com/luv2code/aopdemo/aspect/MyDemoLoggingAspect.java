package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//this class contains a set of advices
	
	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDao.addAccount())") //only metch for add account in class AccountDao
//	@Before("execution(public void updateAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====> Executing @Before advice on method addAccount()");
	}
}
