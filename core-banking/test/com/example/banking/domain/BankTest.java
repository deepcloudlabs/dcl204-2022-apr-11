package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
*
*  @author Binnur Kurt <binnur.kurt@gmail.com>
*/
class BankTest {

	@Test
	void createBankSuccessfully() {
		var bank = new Bank(1, "is bank");
		assertAll(
			() -> assertEquals(1,bank.getId()),
			() -> assertEquals("is bank",bank.getName())
		);
	}

	@Test
	void addTwoCustomersSuccessfully() {
		var bank = new Bank(1, "is bank");
		var jack = new Customer("1", "jack bauer");
		jack.addAccount(new Account("tr1", 10_000));
		jack.addAccount(new CheckingAccount("tr2", 20_000, 5_000));
		bank.addCustomer(jack);
		var kate = new Customer("2", "kate austen");
		kate.addAccount(new Account("tr3", 30_000));
		kate.addAccount(new CheckingAccount("tr4", 40_000, 4_000));
		bank.addCustomer(kate);
		assertAll(
				() -> assertThrows(IllegalArgumentException.class,() -> bank.addCustomer(kate)),
				() -> assertThrows(IllegalArgumentException.class,() -> bank.addCustomer(kate)),
				() -> assertEquals(2,bank.getCustomers().size()),
				() -> assertTrue(bank.getAccount("tr1").isPresent()),
				() -> assertTrue(bank.getAccount("tr2").isPresent()),
				() -> assertTrue(bank.getAccount("tr3").isPresent()),
				() -> assertTrue(bank.getAccount("tr4").isPresent()),
				() -> assertTrue(bank.getAccount("tr5").isEmpty()),
				() -> assertEquals(jack,bank.getCustomerByIdentity(jack.getIdentity()).get()),
				() -> assertEquals(kate,bank.getCustomerByIdentity(kate.getIdentity()).get())
		);
	}

	@Test
	void getTotalBalanceTest() {
		var bank = new Bank(1, "is bank");
		var jack = new Customer("1", "jack bauer");
		jack.addAccount(new Account("tr1", 10_000));
		jack.addAccount(new CheckingAccount("tr2", 20_000, 5_000));
		bank.addCustomer(jack);
		var kate = new Customer("2", "kate austen");
		kate.addAccount(new Account("tr3", 30_000));
		kate.addAccount(new CheckingAccount("tr4", 40_000, 4_000));
		bank.addCustomer(kate);
		assertAll(
			() -> assertEquals(100_000,bank.getTotalBalance()),
			() -> assertEquals(40_000,bank.getTotalBalance(Account.class)),
			() -> assertEquals(60_000,bank.getTotalBalance(CheckingAccount.class))
		);
	}

}
