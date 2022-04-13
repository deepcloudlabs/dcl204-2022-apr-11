package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {

	@DisplayName("Creating an empty customer successfully")
	@Test
	void creatingCustomerShouldSuccess() {
		var jack = new Customer("11111111110", "jack bauer");
		assertAll(() -> assertEquals("11111111110", jack.getIdentity()),
				() -> assertEquals("jack bauer", jack.getFullname()), () -> assertEquals(0, jack.getAccounts().size()));
	}

	@DisplayName("Changing customer's name successfully")
	@Test
	void changingCustomerNameShouldSuccess() {
		var jack = new Customer("11111111110", "jack bauer");
		assertEquals("jack bauer", jack.getFullname());
		jack.setFullname("jack shephard");
		assertEquals("jack shephard", jack.getFullname());
	}

	@DisplayName("Adding accounts successfully")
	@Test
	void addAccountShouldSuccess() throws Exception {
		var jack = new Customer("11111111110", "jack bauer");
		var account1 = new Account("TR1", 100_000);
		var account2 = new CheckingAccount("TR2", 200_000, 5_000);
		assertTrue(jack.addAccount(account1));
		assertTrue(jack.addAccount(account2));
		assertFalse(jack.addAccount(account1));
		assertFalse(jack.addAccount(account2));
		assertEquals(2, jack.getAccounts().size());
	}

	@DisplayName("Getting account by index")
	@Test
	void getAccountWithIndexTest() throws Exception {
		var jack = new Customer("11111111110", "jack bauer");
		var account1 = new Account("TR1", 100_000);
		var account2 = new CheckingAccount("TR2", 200_000, 5_000);
		jack.addAccount(account1);
		jack.addAccount(account2);
		assertTrue(jack.getAccount(0).isPresent());
		assertEquals("TR1", jack.getAccount(0).get().getIban());
		assertTrue(jack.getAccount(1).isPresent());
		assertEquals("TR2", jack.getAccount(1).get().getIban());
		assertTrue(jack.getAccount(2).isEmpty());
		assertTrue(jack.getAccount(-1).isEmpty());
	}

	@DisplayName("Getting account by iban")
	@Test
	void getAccountWithIbanTest() throws Exception {
		var jack = new Customer("11111111110", "jack bauer");
		var account1 = new Account("TR1", 100_000);
		var account2 = new CheckingAccount("TR2", 200_000, 5_000);
		jack.addAccount(account1);
		jack.addAccount(account2);
		assertTrue(jack.getAccount("TR1").isPresent());
		assertEquals("TR1", jack.getAccount(0).get().getIban());
		assertTrue(jack.getAccount("TR2").isPresent());
		assertEquals("TR2", jack.getAccount(1).get().getIban());
		assertTrue(jack.getAccount("TR3").isEmpty());
	}

	@DisplayName("Removing account by iban")
	@Test
	void removeAccountWithIbanTest() throws Exception {
		var jack = new Customer("11111111110", "jack bauer");
		var account1 = new Account("TR1", 100_000);
		var account2 = new CheckingAccount("TR2", 200_000, 5_000);
		jack.addAccount(account1);
		jack.addAccount(account2);
		assertTrue(jack.removeAccount("TR3").isEmpty());
		assertEquals(2, jack.getAccounts().size());
		assertTrue(jack.removeAccount("TR1").isPresent());
		assertEquals(1, jack.getAccounts().size());
		assertTrue(jack.removeAccount("TR2").isPresent());
		assertEquals(0, jack.getAccounts().size());
		assertTrue(jack.removeAccount("TR4").isEmpty());
	}

	@DisplayName("Getting total balances of customer's in all accounts")
	@Test
	void getTotalBalance() throws Exception {
		var jack = new Customer("11111111110", "jack bauer");
		var account1 = new Account("TR1", 100_000);
		var account2 = new CheckingAccount("TR2", 200_000, 5_000);
		jack.addAccount(account1);
		jack.addAccount(account2);
		assertEquals(2, jack.getAccounts().size());
		assertEquals(300_000.0, jack.getTotalBalance(), 0.000_000_1);
	}
}
