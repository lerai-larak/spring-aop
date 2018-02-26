package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDao;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read spring configuration
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		//get the bean from spring container
		
		AccountDao accountDao = context.getBean("accountDao",AccountDao.class);
		//call the business method
		accountDao.addAccount();
		
		//close the context
		context.close();
	}

}
