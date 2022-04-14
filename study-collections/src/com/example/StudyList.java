package com.example;

import java.util.LinkedList;
import java.util.List;

/**
*
*  @author Binnur Kurt <binnur.kurt@gmail.com>
*/
public class StudyList {

	public static void main(String[] args) {
		// List i) Allows duplicates ii) Ordered -> Sortable
		List<Integer> numbers = new LinkedList<>();// new ArrayList<>();
		numbers.add(4);
		numbers.add(8);
		numbers.add(4);
		numbers.add(42);
		numbers.add(23);
		numbers.add(0,4);
		numbers.add(15);
		numbers.add(4);
		numbers.add(16);
		System.out.println(numbers);
		System.out.println(numbers.get(0));
		System.out.println(numbers.get(numbers.size()-1));
		numbers.sort(Integer::compareTo);
		System.out.println(numbers.contains(108));
	}

}
