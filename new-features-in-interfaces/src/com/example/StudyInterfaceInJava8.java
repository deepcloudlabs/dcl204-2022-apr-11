package com.example;

import java.util.List;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@SuppressWarnings("unused")
public class StudyInterfaceInJava8 {

	public static void main(String[] args) {
		var numbers = List.of(4, 8, 15, 16, 23, 42);
		var total = numbers.stream().filter(B::ciftMi).map(v -> v * v).reduce(0, (s, u) -> s + u);
		    total = numbers.stream().filter(D::isEven).map(v -> v * v).reduce(0, (s, u) -> s + u);
	}

}

class D {
	public static boolean isEven(int sayi) {
		return sayi % 2 == 0;
	}

}

class C implements B {

	@Override
	public int fun() {
		return 108;
	}

}

interface B { // 1.3.5 -> 2.0.0
	public abstract int fun();

	default public int gun() {
		return 42;
	}

	public static boolean ciftMi(int sayi) {
		return sayi % 2 == 0;
	}
}

interface A {
	public abstract int fun();

	// (1) default method (Java SE 8) 
	default public int gun() {
		return 42 + run();
	}

	// (2) static method (Java SE 8)
	public static int sun() {
		return 42 * tun();
	}
	
	// (3) private method (Java SE 9)
	private int run() {
	   return 108;
	}

	// (4) private static method (Java SE 9)
	private static int tun() {
		return 108;
	}
}