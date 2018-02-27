package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {

	public String addAccount() {
		System.out.println("Doing some work for membershipp account");
		return "some-string";
	}
	
	public void addSillyMember() {
		System.out.println("Just a method to tests poincut expression add*()");
	}
}
