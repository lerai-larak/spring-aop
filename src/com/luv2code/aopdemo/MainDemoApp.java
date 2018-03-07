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
		accountDao.addAccount(new Account(), true);
		accountDao.doSomeWork();
		
		//call the getters and setters in dao
		accountDao.setName("foobar");
		accountDao.setServiceCode("Primeier");
		accountDao.getName();
		accountDao.getServiceCode();
		
		//just to test if the pointcut will evaluate to true for this method
		membershipDao.addSillyMember();
		membershipDao.addAccount();
		
		//close the context
		context.close();
	}

}
