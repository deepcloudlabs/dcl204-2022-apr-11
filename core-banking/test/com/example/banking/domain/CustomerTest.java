package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {

	@DisplayName("Creating an empty customer successfully")
	@Test
	void creatingCustomerShouldSuccess() {
		var jack = new Customer("11111111110", "jack bauer");
		assertAll(
			() -> assertEquals("11111111110", jack.getIdentity()),
			() -> assertEquals("jack bauer", jack.getFullname()),
			() -> assertEquals(0, jack.getAccounts().size())			
		);
	}
	
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

	
	@Test
	void testGetAccountWithIndex() throws Exception {
		var jack = new Customer("11111111110", "jack bauer");
		var account1 = new Account("TR1", 100_000);
		var account2 = new CheckingAccount("TR2", 200_000, 5_000);
		jack.addAccount(account1);
		jack.addAccount(account2);
		assertTrue(jack.getAccount(0).isPresent());
		assertEquals("TR1",jack.getAccount(0).get().getIban());
		assertTrue(jack.getAccount(1).isPresent());
		assertEquals("TR2",jack.getAccount(1).get().getIban());
		assertTrue(jack.getAccount(2).isEmpty());
		assertTrue(jack.getAccount(-1).isEmpty());
	}
}
