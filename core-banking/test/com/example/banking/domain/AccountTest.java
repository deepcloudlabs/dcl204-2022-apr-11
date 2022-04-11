package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class AccountTest {

	@DisplayName("Creating Account Objects Successfully")
	@ParameterizedTest
	@CsvFileSource(resources = "accounts.csv")
	void createAccountSuccessfully(String iban, double balance) {
		// 1. fixture/test setup
		// 2. call exercise method
		var account = new Account(iban, balance);
		// 3. verification
		assertEquals(iban, account.getIban());
		assertEquals(balance, account.getBalance());
		// 4. Destroy fixture
	}

}
