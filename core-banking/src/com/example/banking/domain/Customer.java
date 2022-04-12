package com.example.banking.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	// addAccount(Account) 
	// getAccount(int)
	// getAccount(iban)
	// removeAccount(iban)
	// getTotalBalance() -> double
}
