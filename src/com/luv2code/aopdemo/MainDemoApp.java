package com.luv2code.aopdemo;

import java.util.List;

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
		
		List<Account> accounts = accountDao.findAccounts();
		
		//display the accounts
		System.out.println("\nMain App printing");
		System.out.println("--------------------------------------------------------------");
		System.out.println(accounts);
		System.out.println("--------------------------------------------------------------");
		//close the context
		context.close();
	}

}
