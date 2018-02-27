package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDao;
import com.luv2code.aopdemo.dao.MembershipDao;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read spring configuration
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		//get the bean from spring container
		
		AccountDao accountDao = context.getBean("accountDao",AccountDao.class);
		MembershipDao membershipDao = context.getBean("membershipDao",MembershipDao.class);
		
		//call the business method
		accountDao.addAccount();
		membershipDao.addAccount(); //just to test if the pointcut will evaluate to true for this method
		
		//close the context
		context.close();
	}

}
