package com.example.banking.domain;

// Entity Class -> identity -> iban
public class Account extends Object {
	// field/attribute/state/data
	// instance+reference variable 
	private final String iban;
	// instance+value-typed variable 
	private double balance;

	// constructor
	// Alt + Shift + S
	public Account(String iban, double balance) {
		this.iban = iban;
		this.balance = balance;
	}

	public String getIban() {
		return iban;
	}

	public double getBalance() {
		return balance;
	}
	
	// business method!
	public boolean deposit(double amount) {
		// validation
		if (amount<=0) return false;
		// business logic
		this.balance = this.balance + amount;
		return true;
	}
	
	public boolean withdraw(double amount) {
		// validation
		if (amount<=0) return false;
		// business rule
		if (amount > balance) return false;
		// business logic
		this.balance = this.balance - amount;
		return true;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}

}