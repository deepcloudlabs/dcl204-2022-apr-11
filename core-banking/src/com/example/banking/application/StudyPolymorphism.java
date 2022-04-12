package com.example.banking.application;

import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;

public class StudyPolymorphism {

	public static void main(String[] args) {
		Account acc;
		if (ThreadLocalRandom.current().nextBoolean())
			acc=new Account("tr1", 100_000);
		else
			acc=new CheckingAccount("tr2", 200_000, 1_000);
		System.out.println(acc.getClass().getName());
		acc.withdraw(500); // ?		
	}

}

class H {}
class I extends H {}
class J extends H {}
class K extends J {}
class M {}
class N extends I {}
