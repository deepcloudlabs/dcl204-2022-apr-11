package com.example;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyResources {
	public static void fun() {
		if (ThreadLocalRandom.current().nextBoolean())
			throw new IllegalArgumentException("Ooopps");
	}

	public static void main(String[] args) {
		PreciousResource res1 = new PreciousResource(1);
		PreciousResource res2 = new PreciousResource(2);
		PreciousResource res3 = new PreciousResource(3);
		try {
			fun();
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				res1.close();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			} finally {
				try {
					res2.close();
				} catch (IOException e) {
					System.err.println(e.getMessage());
				} finally {
					try {
						res3.close();
					} catch (IOException e) {
						System.err.println(e.getMessage());
					}
				}
			}
		}
	}

}

class PreciousResource implements Closeable {
	private final int id;

	public PreciousResource(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public void close() throws IOException {
		System.err.println("Closing the resource %d...".formatted(id));
		throw new RuntimeException("Cannot close the resource");
	}

}