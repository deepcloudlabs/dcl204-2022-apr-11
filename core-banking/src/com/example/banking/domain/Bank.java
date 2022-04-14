package com.example.banking.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class Bank {
	private final int id;
	private String name;
	private final Map<String, Customer> customers = new HashMap<>();

	public Bank(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public Map<String, Customer> getCustomers() {
		return Collections.unmodifiableMap(customers);
	}

	public Optional<Customer> getCustomerByIdentity(String identity) {
		return Optional.ofNullable(customers.get(identity));
	}

	public void addCustomer(Customer customer) {
		if (true) {
			throw new IllegalArgumentException("Customer already exists.");
		}
	}

	public Optional<Account> getAccount(String iban) {
		return null;
	}

	public double getTotalBalance() {
		return 0.0;
	}
	
	public double getTotalBalance(Class<? extends Account> clazz) {
		return 0.0;
	}
}
