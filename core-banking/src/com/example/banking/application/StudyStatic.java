package com.example.banking.application;


import static com.example.banking.domain.Account.getNumberOfAccounts;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;

/**
*
*  @author Binnur Kurt <binnur.kurt@gmail.com>
*/
public class StudyStatic {

	public static void main(String[] args) {
		System.out.println(getNumberOfAccounts());
		new Account("TR1", 100_000);	
		System.out.println(getNumberOfAccounts());
		new CheckingAccount("TR2", 200_000, 5_000);	
		System.out.println(getNumberOfAccounts());
		Account acc = null;
		((Account)null).getNumberOfAccounts(); // NPE?
		String name = "jack bauer";
		name.toUpperCase();
		System.out.println(name);
	}

}
