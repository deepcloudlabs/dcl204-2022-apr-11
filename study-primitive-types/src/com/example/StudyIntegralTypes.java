package com.example;

import java.math.BigInteger;

public class StudyIntegralTypes {

	public static void main(String[] args) {
		byte b = 42; // 1-Byte, [-128..127]
		b = 127;
		b++;
		System.out.println("b="+b);
		b=-128;
		b = (byte) (b - 2);
		System.out.println("b="+b);
		short s = 42; // 2-byte, [-32768..32767]
		s = Short.MAX_VALUE;
		s++;
		System.out.println("s="+s);
		s = Short.MIN_VALUE;
		s--;
		System.out.println("s="+s);
		int i = Integer.MAX_VALUE; // 4-byte, [-2147483648..2_147_483_647]
		++i;
		System.out.println("i="+i);
		i = Integer.MIN_VALUE;
		--i;
		System.out.println("i="+i);
		long l = Long.MAX_VALUE; // 8-byte, [-9223372036854775808..9223372036854775807]
		l++;
		System.out.println("l="+l);
		l=Long.MIN_VALUE;
		--l;
		System.out.println("l="+l);
		// BigInteger -> Immutable Class -> 
		var veryBigNumber = BigInteger.valueOf(Long.MAX_VALUE);
		System.out.println(veryBigNumber.toString());
		veryBigNumber = veryBigNumber.add(BigInteger.ONE);
		System.out.println(veryBigNumber.toString());
		// Heap: Eden + Survivor (S0,S1) + Tenure
		// Minor GC (1st): Live(Eden   ) -> S0
		// Minor GC (2nd): Live(Eden,S0) -> S1
		// Minor GC (3rd): Live(Eden,S1) -> S0
		// Full  GC   
		long m = Integer.MAX_VALUE + 1L;
		System.out.println("m="+m);
		int one = 0/0; // ALU
		long n = 12345 + 5432L;
		int z1 = 123; // Decimal
		int z2 = 0123; // Octal
		int z3 = 0x20BA; // Hexadecimal
		int z4 = 0b1001_1100; // Binary
	}

}







