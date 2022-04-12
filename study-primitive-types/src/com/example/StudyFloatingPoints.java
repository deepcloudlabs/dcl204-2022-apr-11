package com.example;

import java.math.BigDecimal;

public class StudyFloatingPoints {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// CPU -> FPU -> IEE-754, Scale
		float x = 3.1415161718192021F; // 4-byte
		double y = 3.1415; // 8-byte = 64bit -> 2^64, [0,1] 0.0000000000000000000000000001 
        y = 2.0;
        y = y - 1.10; 
        System.out.println("%3.16f".formatted(y));
        if ((0.1+0.2)+0.3 == 0.1 + (0.2 + 0.3)) {
        	System.out.println("They are equal!");
        } else {
        	System.out.println("They are NOT equal!");        	
        }
        float money = 1_000_000_000;
        money = money + 50;
        System.out.println("%16.3f".formatted(money)); // 14
        double z = 1/-0.0;
        System.out.println(z);
        z = 0/0.;
        System.out.println(Double.isNaN(z));
        // BigDecimal -> Immutable Class
        var bd = BigDecimal.valueOf(2.0);
        bd = bd.subtract(BigDecimal.valueOf(1.1));
        System.out.println(bd);
	}

}
