package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDao {

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass()+ ": Doing my DB work");
	}
}
