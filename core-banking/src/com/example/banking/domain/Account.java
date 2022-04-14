package com.example.banking.domain;
// OOP: 
//   i) Class/Object -> Encapsulation( hide the state + behaviour ) + Information Hiding 
//  ii) Inheritance  -> Re-usability
// iii) Polymorphism -> Agility
// Entity Class -> identity -> iban
public class Account extends Object {
	// field/attribute/state/data
	// instance+reference variable 
	private final String iban;
	// instance+value-typed variable 
	protected double balance; // zero + positive
	private AccountStatus status; // 0: ACTIVE, 1: CLOSED, 2: BLOCKED
	private static int numberOfAccounts = 0;
	// constructor
	// Alt + Shift + S
	public Account(String iban, double balance) {
		this.iban = iban;
		this.balance = balance;
		numberOfAccounts++;
	}

	public static int getNumberOfAccounts() {
		return numberOfAccounts;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public String getIban() {
		return iban;
	}

	public double getBalance() {
		return balance;
	}
	
	// Exception:
	// 1) Unchecked - Runtime Exception  - RuntimeException -> Bug?
	// 2) Checked   - Business Exception - Exception
	// 3) Error     - Fatal Error        - Error 
	// business method!
	public double deposit(double amount)  {
		// validation
		if (amount<=0) throw new IllegalArgumentException("deposit amount must be positive.");
		// business logic
		this.balance = this.balance + amount;
		return this.balance;
	}
	
	public double withdraw(double amount) throws InsufficientBalanceException {
		System.out.println("Account::withdraw");
		// validation
		if (amount<=0) throw new IllegalArgumentException("withdraw amount must be positive.");
		// business rule
		if (amount > balance) throw new InsufficientBalanceException(
				"Your balance does not cover your expenses", amount-balance); 
		// business logic
		this.balance = this.balance - amount;
		return balance;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}

}