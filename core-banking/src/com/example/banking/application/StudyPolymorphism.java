package com.example.banking.application;

import java.util.concurrent.ThreadLocalRandom;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;
import com.example.banking.domain.InsufficientBalanceException;

public class StudyPolymorphism {

	public static void main(String[] args) throws InsufficientBalanceException {
		Account acc;
		if (ThreadLocalRandom.current().nextBoolean())
			acc=new Account("tr1", 100_000);
		else
			acc=new CheckingAccount("tr2", 200_000, 1_000);
		System.out.println(acc.getClass().getName());
		acc.withdraw(500);
		H h = new I();
		System.out.println(h.getX());
	}

}

abstract class H {
	public abstract int getX(); 
}
class I extends H {
	public int x;
	public int getX() {return x;}
}
class J extends H {
	public int x;
	public int getX() {return x;}
}
class K extends J {}
class M {}
class N extends I {}
