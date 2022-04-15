package com.example;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class ThreadPoolExercise {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Thread [%s] is running the main function.".formatted(Thread.currentThread().getName()));
		var threadPool = Executors.newFixedThreadPool(8);
		
		var task1 = new MyTask();
		var futureTask1 = new FutureTask<>(task1);
		threadPool.submit(futureTask1);
		
		var task2 = new MyTask();
		var futureTask2 = new FutureTask<>(task2);
		threadPool.submit(futureTask2);

		
		System.out.println(futureTask1.get());
		System.out.println(futureTask2.get());
		
		threadPool.shutdown();
	}

}

class MyTask implements Callable<List<Integer>> {

	@Override
	public List<Integer> call() {
		System.out.println("Thread [%s] is running LotteryTask.".formatted(Thread.currentThread().getName()));		
		return ThreadLocalRandom.current().ints(1, 60).distinct().limit(6).sorted().boxed().toList();
	}

}