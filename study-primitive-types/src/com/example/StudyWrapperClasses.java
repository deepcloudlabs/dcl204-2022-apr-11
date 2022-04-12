package com.example;

import java.util.List;

public class StudyWrapperClasses {

	public static void main(String[] args) {
		// byte -> Byte, short -> Short, long -> Long
		// int -> Integer
		// char -> Character
		// float -> Float, double -> Double
		// boolean -> Boolean
		// -XX:AutoBoxCacheMax=4096
		int x = 42; // 4-byte -> 42 (value)
		Integer y = 42 ; // 12-Byte (Object Header) + 4-byte (value) = 16B
		List<Integer> numbers = List.of(4,8,15,16,23,42);
		Integer u = Integer.valueOf(108); // Cache Java SE 5: Auto-boxing 
		Integer v = 108; // Cache
		Integer m = 549; // Heap 
		Integer n = new Integer(549); // Heap
		System.out.println("u==v? "+(u==v)); // true
		System.out.println("m==n? "+(m==n)); // false -> true
		System.out.println("m.equals(n)? "+(m.equals(n))); // true
		Integer p = 42;
		Integer q = 108;
		Integer r = Integer.valueOf(p.intValue() + q.intValue()); // p + q
	}

}
