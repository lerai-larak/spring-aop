package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/*This class of pointcut declarations will be shared/available from other aspects*/

@Aspect
public class SharedExpressions {

	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	// create pointcut for setter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	// create pointcut for methods in dao package with Account as a parameter
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(com.luv2code.aopdemo.Account,..))")
	public void hasAccountAsParam() {}
	
	// assemble pointcut for business method, makes use of other pointcuts
	@Pointcut("forDaoPackage() && !(getter() || setter()) && hasAccountAsParam()")
	public void businessMethods() {}
	
	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
	
}
