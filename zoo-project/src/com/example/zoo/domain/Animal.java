package com.example.zoo.domain;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public abstract class Animal {
	protected int legs;

	public Animal(int legs) {
		this.legs = legs;
	}

	public int getLegs() { // concrete method
		return legs;
	}

	public void walk() { // concrete method
		System.out.println("Animal with %d legs is walking now...".formatted(legs));
	}

	public abstract void eat();
}
