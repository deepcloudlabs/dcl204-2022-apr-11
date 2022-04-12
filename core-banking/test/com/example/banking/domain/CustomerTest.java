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

}
