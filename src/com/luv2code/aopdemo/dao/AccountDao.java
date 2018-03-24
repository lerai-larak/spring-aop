package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDao {

	private String name;
	private String serviceCode;
	
	
	public String getName() {
		System.out.println("Inside: getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println("Inside: setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("Inside: getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("Inside: setServiceCode()");
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(this.getClass()+ ":  Doing my DB work");
	}
	
	public boolean doSomeWork() {
		System.out.println(this.getClass()+ ": Doing some additional work!");
		return true;
	}
	
	public List<Account> findAccounts(Boolean tripper){
		
		if(tripper) {
			throw new RuntimeException("A simulated error was encountered");
		}
		List<Account> accounts = new ArrayList<>();
		Account temp1 = new Account("John","Silver");
		Account temp2 = new Account("Borne","Platinum");
		Account temp3 = new Account("Aisha","Gold");
		
		accounts.add(temp1);
		accounts.add(temp2);
		accounts.add(temp3);
		return accounts;
		
	}
}
