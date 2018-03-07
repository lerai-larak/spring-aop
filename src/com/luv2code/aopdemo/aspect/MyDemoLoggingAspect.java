package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	
	//create a pointcut declaration
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	
		//create a pointcut declaration for setter methods
		@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
		public void forSetterMethods() {}
		
		//create a pointcut declaration for getter methods
		@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
		public void forGetterMethods() {}
		
	//match any method in any class inside package dao with any return type, with 0 or more params
	@Before("forDaoPackage()") //refer to the pointcut declared above
	public void beforeAddAccountAdvice() {
		System.out.println("\n___________________________________________________________>"
				+ "\n Executing @Before advice on methods in package dao"
				+ "\n__________________________________________________________> ");
	}
	
	//provide advice for any method executed in dao package apart from getters and setters
	@Before("forDaoPackage() && ! (forSetterMethods() || forGetterMethods())") //reuse the declared pointcut expression for another advice
	public void performApiAnalytics() {
		System.out.println("Some method in dao package was called and not a getter/setter!");
	}
}