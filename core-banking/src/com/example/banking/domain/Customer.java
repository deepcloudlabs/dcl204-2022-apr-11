package com.example.banking.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Customer {
	private final String identity;
	private String fullname;
	private List<Account> accounts = new ArrayList<>();

	public Customer(String identity, String fullname) {
		this.identity = identity;
		this.fullname = fullname;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getIdentity() {
		return identity;
	}

	public List<Account> getAccounts() {
		return Collections.unmodifiableList(accounts);
	}
	
	// business methods: 
	public boolean addAccount(Account account) {
		// validation
		for (Account acc : accounts) {
			if (acc.getIban().equals(account.getIban()))
				return false;
		}
		// business logic -> delegation
		accounts.add(account);
		return true;
	} 
	
	public Optional<Account> getAccount(int index) {
		if (index < 0 || index >= accounts.size())
			return Optional.empty();
		return Optional.of(accounts.get(index));
	}
	
	public Optional<Account> getAccount(String iban) {
		for (Account account : accounts) {
			if (account.getIban().equals(iban))
				return Optional.of(account);
		}
		return Optional.empty();
	}
	
	public Optional<Account> removeAccount(String iban) {
		var existingAccount = getAccount(iban);
		if (existingAccount.isEmpty())
			return Optional.empty();
		accounts.remove(existingAccount.get());
		return existingAccount;
	}
	
	public double getTotalBalance() {
		var totalBalance = 0.0;
		for (var account : accounts) {
			totalBalance += account.getBalance();
		}
		return totalBalance;
	}
}