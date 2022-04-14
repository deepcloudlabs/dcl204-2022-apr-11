package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
		assertAll(
		   () -> assertThrows(IllegalArgumentException.class, () -> account.deposit(-1.0)),
		   () -> assertEquals(10_000, account.getBalance())
		);
	}

	@DisplayName("deposit with zero amount should fail")
	@Test
	void depositWithZeroAmountShouldFail() throws Exception {
		var account = new Account("TR1", 10_000);
		assertAll(
			() -> assertThrows(IllegalArgumentException.class, () -> account.deposit(0.0)),
			() -> assertEquals(10_000, account.getBalance())
		);
	}
	
	@DisplayName("deposit with positive amount should succeed")
	@Test
	void depositWithPositiveAmountShouldSucceed()  {
		var account = new Account("TR1", 10_000);
		assertEquals(10_001, account.deposit(1.0));
	}
	
	@DisplayName("Withdrawing zero or negative amount should fail")
	@ParameterizedTest
	@CsvFileSource(resources = "withdraw-fail.csv")
	void withdrawShouldFail(String iban, double balance,double amount) {
		var account = new Account(iban, balance);
		assertAll(
		 () -> assertThrows(Exception.class, () -> account.withdraw(amount)),
		 () -> assertEquals(balance, account.getBalance())
		);
	}

	@DisplayName("Withdrawing all balance should succeed")
	@Test
	void withdrawAllBalanceShouldSucceed() throws Throwable {
		// 1. fixture/test setup
		var account = new Account("TR1", 10_000);
		// 2. call exercise method
		assertEquals(0.0, account.withdraw(10_000));
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
	
	@Test
	void testName() throws Exception {
		var x = (0.1 + 0.2) + 0.3;
		assertEquals(0.6, x, 0.001);
	}
}
