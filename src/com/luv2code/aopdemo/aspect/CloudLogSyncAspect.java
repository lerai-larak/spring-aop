package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

/** 
 * JionPoints provide metadata about the method executing and can be used to get method signatures and 
 * 
 * @author kelly
 *
 */

@Aspect
@Component
@Order(1)
public class CloudLogSyncAspect {

	//add a new advice for @afterReturning on the findAccounts method
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDao.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account>result) {
		String method = theJoinPoint.getSignature().toShortString();
		
		System.out.println("\nCloudLogging printing");
		System.out.println(method);
		System.out.println("--------------------------------------------------------------");
		System.out.println(result);
	}
	
	
	
	
	
	@Before("com.luv2code.aopdemo.aspect.SharedExpressions.businessMethods()")
	public void logToCloudAsync(JoinPoint theJoinPoint) {
			System.out.println("Applying cloud logging aspect");
	
	//display method signature
	
	MethodSignature methodSig = (MethodSignature)theJoinPoint.getSignature();
	System.out.println("Method: " + methodSig);
	
	//display method arguments
	
	//get the args
	Object[] arguments =  theJoinPoint.getArgs();
 	//loop through the args 
	for(Object tempArg : arguments) {
		System.out.println(tempArg);
		
		if(tempArg instanceof Account) {
			//downcast and get specific stuff about the account
			Account account = (Account) tempArg;
			System.out.println("Account Name: " + account.getName());
			System.out.println("Account Level: " + account.getLevel());
		}
	}
	}	
}
