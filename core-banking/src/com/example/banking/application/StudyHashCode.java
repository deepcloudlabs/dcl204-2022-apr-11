package com.example.banking.application;

import com.example.banking.domain.Account;

/**
*
*  @author Binnur Kurt <binnur.kurt@gmail.com>
*/
public class StudyHashCode {

	public static void main(String[] args) {
		Account acc1 = new Account("TR1", 100_000);
		Account acc2 = new Account("Tr1", 100_000);
		System.out.println(acc1.hashCode());
		System.out.println(acc2.hashCode());

	}

}
