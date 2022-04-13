package com.example.exercises;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

/**
*
*  @author Binnur Kurt <binnur.kurt@gmail.com>
*/
@SuppressWarnings("unused")
public class Exercise2 {

	public static void main(String[] args) {
		int x = 42; // value
		String name = "jack"; // reference -> object
		x++;
		var numbers = List.of(4,8,15,16,23,42);
		// Odd -> Cube -> Sum: 15 -> 15 * 15 *15, 23 -> 23*23*23
		// Functional Programming: i) higher-order function -> filter/map/reduce 
		//                        ii) Pure functions -> ifOdd, toCube, accumulate
		// Functional Interface -> SAM (single abstract method) -> pure function -> lambda expression
		//                                                         Method reference 
		// Built-in Functional Interface
		Predicate<Integer> ifOdd = u -> u%2 == 1;// reference to "pure function"
		Function<Integer,Integer> toCube = v -> v*v*v;
		BinaryOperator<Integer> accumulate = (acc, u) -> acc + u;
		var total =
		numbers.stream()          // 4 8 15 16 23 42 
		       .filter(ifOdd)     //     15    23
		       .map(toCube)       //     3375  12167 
		       .reduce(0, Integer::sum);// 15542
		// Lazy Evaluation
		System.out.println(total);

	}

}
