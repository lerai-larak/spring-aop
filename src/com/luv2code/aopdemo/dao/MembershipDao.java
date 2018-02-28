package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {

	public String addAccount() {
		System.out.println("Adding a reglar account!");
		return "some-string";
	}
	
	public void addSillyMember() {
		System.out.println("Adding a silly member!");
	}
}
