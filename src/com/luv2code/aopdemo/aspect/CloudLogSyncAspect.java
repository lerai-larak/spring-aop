package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.AroundHandleExceptionDemoApp;

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
	
	private static Logger logger = 
			Logger.getLogger(CloudLogSyncAspect.class.getSimpleName());
	
	@Around("execution(* com.luv2code.aopdemo.service.TrafficFortunesService.getFortune(..))")
	public Object aroundGetFortuneService(ProceedingJoinPoint joinPoint) throws Throwable {
		
		//print the method we are adving on
		logger.info("------------------------------------------");
		logger.info("Executing @Around advice for: " + joinPoint.getSignature().toShortString());
		//get begining timestamp, execute the method, get end timestamp, compute duration
		long begin = System.currentTimeMillis();
		Object result = null;
		
		try {
			result = joinPoint.proceed();
		} catch (Exception e) {
			//log the exception, then give the user a custom message, then rethrow the exception
			logger.warning(e.getMessage());
			
			result = "You got this message because the "
			+joinPoint.getSignature().toShortString()
			+" exprienced an issue!";
			
			throw e;
		}
		
		long end = System.currentTimeMillis();
		long duration = end - begin;
		logger.info("Method execution took: " + duration/1000.0 + "seconds!");
		logger.info("------------------------------------------");
		return result;
	}

	//add a new advice for @afterReturning on the findAccounts method
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDao.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account>result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		
		logger.info("\nCloudLogging printing");
		logger.info(method);
		logger.info("--------------------------------------------------------------");
		logger.info(result.toString());
		
		convertAccNamesToUpperCase(result);
		logger.info(result.toString());
	}
	
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDao.findAccounts(..))",
			throwing="exception")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Exception exception) {
		
		String method = theJoinPoint.getSignature().toShortString();
		
		logger.info("\nCloudLogging printing");
		logger.info(method);
		logger.info("--------------------------------------------------------------");
		logger.info(exception.toString());
	}
	
	//@After advice runs regardless of if the method completes or throws an exception
	@After("execution(* com.luv2code.aopdemo.dao.AccountDao.findAccounts(..))")
	public void afterFinallyAdvice(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		logger.info("\nCloudLogging printing");
		logger.info("executed @After finally for " + method);
		logger.info("--------------------------------------------------------------");
	}
	
	//post-process the data intercepted
	private void convertAccNamesToUpperCase(List<Account>result) {
		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}
	}
	
	
	
	@Before("com.luv2code.aopdemo.aspect.SharedExpressions.businessMethods()")
	public void logToCloudAsync(JoinPoint theJoinPoint) {
			logger.info("Applying cloud logging aspect");
	
	//display method signature
	
	MethodSignature methodSig = (MethodSignature)theJoinPoint.getSignature();
	logger.info("Method: " + methodSig);
	
	//display method arguments
	
	//get the args
	Object[] arguments =  theJoinPoint.getArgs();
 	//loop through the args 
	for(Object tempArg : arguments) {
		logger.info(tempArg.toString());
		
		if(tempArg instanceof Account) {
			//downcast and get specific stuff about the account
			Account account = (Account) tempArg;
			logger.info("Account Name: " + account.getName());
			logger.info("Account Level: " + account.getLevel());
		}
	}
	}	
}
