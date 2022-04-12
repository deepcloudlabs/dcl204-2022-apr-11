package com.example.banking.domain;

// CheckingAccount -> sub-class
// Account         -> super-class
public class CheckingAccount extends Account {
	private double overdraftAmount;

	public CheckingAccount(String iban, double balance, double overdraftAmount) {
		super(iban, balance);
		this.overdraftAmount = overdraftAmount;
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	@Override
	public boolean withdraw(double amount) {
		System.out.println("CheckingAccount::withdraw");
		// validation
		if (amount <= 0.) return false;
		// business rule
		if ( amount > (balance+overdraftAmount)) return false;
		balance = balance - amount;
		return true;
	}


	
}
