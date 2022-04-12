package com.example.banking.application;

import com.example.banking.domain.Account;

// Ctrl + Shift + O -> Organize Import
// Ctrl + Shift + F -> Formats source code
public class BankingApplication {
	public static void main(String[] args) {
		{
		   // Local/Stack/Temporary/Automatic Variable
		   // Reference Variable
		   Account acc;
		   acc = new Account("TR1", 10_000); // Heap Object
		   acc.deposit(5_000);
		   acc.withdraw(2_500);
		   acc.withdraw(1_000_000);
		   System.out.println(acc.toString());
		} // account is destroyed!
	}
}
