package com.example.exercises;

import java.util.concurrent.ThreadLocalRandom;

/**
*
*  @author Binnur Kurt <binnur.kurt@gmail.com>
*/
public class Exercise1 {

	public static void main(String[] args) {
		// Lottery Numbers: [1..60], 6 unique sorted
		var lotteryNumbers = 
				ThreadLocalRandom.current()
				                 .ints(1, 60)
				                 .distinct()
				                 .limit(6)
				                 .boxed()
				                 .sorted()
				                 .toList();
		System.out.println(lotteryNumbers);
				                      

	}

}
