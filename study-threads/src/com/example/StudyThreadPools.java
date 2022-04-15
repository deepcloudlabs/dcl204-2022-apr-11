package com.example;

import java.util.concurrent.Executors;

/**
*
*  @author Binnur Kurt <binnur.kurt@gmail.com>
*/
public class StudyThreadPools {

	public static void main(String[] args) {
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		System.out.println(availableProcessors);
		Executors.newFixedThreadPool(availableProcessors); // CPU-Bound/IO-Bound
		Executors.newCachedThreadPool();
		Executors.newScheduledThreadPool(availableProcessors);
		Executors.newSingleThreadExecutor();

	}

}
