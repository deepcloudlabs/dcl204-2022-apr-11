package com.example;

import java.io.IOException;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyWithResourcesJava7 {
	public static void fun() {
		//if (ThreadLocalRandom.current().nextBoolean())
		throw new IllegalArgumentException("Ooopps");
	}

	public static void main(String[] args) {
		// try with resources (Java SE 7)
		try (PreciousResource res1 = new PreciousResource(1);
				PreciousResource res2 = new PreciousResource(2);
				PreciousResource res3 = new PreciousResource(3);) {
			fun();
		} catch (IllegalArgumentException | IOException e) { // Java SE 7
			System.err.println(e.getMessage());
			for (var ex : e.getSuppressed())
				System.err.println(ex.getMessage());
		}
	}

}