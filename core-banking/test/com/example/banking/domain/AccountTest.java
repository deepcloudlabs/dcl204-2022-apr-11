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
		assertAll(
			() -> assertEquals(iban, account.getIban()),
			() -> assertEquals(balance, account.getBalance())
		);
		// 4. Destroy fixture
	}
	
	@DisplayName("deposit with negative amount should fail")
	@Test
	void depositWithNegativeAmountShouldFail() throws Exception {
		var account = new Account("TR1", 10_000);
		var result = account.deposit(-1.0);
		assertAll(
		   () -> assertFalse(result),
		   () -> assertEquals(10_000, account.getBalance())
		);
	}

	@DisplayName("deposit with zero amount should fail")
	@Test
	void depositWithZeroAmountShouldFail() throws Exception {
		var account = new Account("TR1", 10_000);
		var result = account.deposit(0.0);
		assertAll(
			() -> assertFalse(result),
			() -> assertEquals(10_000, account.getBalance())
		);
	}
	
	@DisplayName("deposit with positive amount should succeed")
	@Test
	void depositWithPositiveAmountShouldSucceed()  {
		var account = new Account("TR1", 10_000);
		var result = account.deposit(1.0);
		assertAll(
			 () -> assertTrue(result),
			 () -> assertEquals(10_001, account.getBalance())
		);
	}
	
	@DisplayName("Withdrawing zero or negative amount should fail")
	@ParameterizedTest
	@CsvFileSource(resources = "withdraw-fail.csv")
	void withdrawShouldFail(String iban, double balance,double amount) {
		var account = new Account(iban, balance);
		assertAll(
		 () -> assertFalse(account.withdraw(amount)),
		 () -> assertEquals(balance, account.getBalance())
		);
	}

	@DisplayName("Withdrawing all balance should succeed")
	@Test
	void withdrawAllBalanceShouldSucceed() {
		// 1. fixture/test setup
		var account = new Account("TR1", 10_000);
		// 2. call exercise method
		assertAll(
			() -> assertTrue(account.withdraw(10_000)),
			() -> assertEquals(0.0, account.getBalance())
		);
	}
	
	@DisplayName("toString should contain iban and balance")
	@Test
	void toStringShouldSucceed() throws Exception {
		var account = new Account("TR1", 10_000);
		assertAll(
			() -> assertTrue(account.toString().startsWith("Account")),
			() -> assertTrue(account.toString().contains("iban=")),
			() -> assertTrue(account.toString().contains("balance="))
		);
		
	}
}
