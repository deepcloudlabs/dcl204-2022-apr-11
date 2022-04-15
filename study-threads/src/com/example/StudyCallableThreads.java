package com.example;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyCallableThreads {
    // -Xss64m : stack size
	// Local Variable: primitive (long,double -> 8Byte), reference (8B -> 4B) (-XX:+UsCompressedOops)
	// Function Parameter
	// Return Value
	// Return Address
	// Call Stack 
	// Recursive Function
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Thread [%s] is running the main function.".formatted(Thread.currentThread().getName()));
		var task1 = new LotteryCallableTask();
		var futureTask1 = new FutureTask<>(task1);
		var thread1 = new Thread(futureTask1,"elma");

		var task2 = new LotteryCallableTask();
		var futureTask2 = new FutureTask<>(task2);
		var thread2 = new Thread(futureTask2,"armut");

		thread1.start();
		thread2.start();
		
		System.out.println(futureTask1.get());
		System.out.println(futureTask2.get());
		
	}

}

class LotteryCallableTask implements Callable<List<Integer>> {

	@Override
	public List<Integer> call() {
		System.out.println("Thread [%s] is running LotteryTask.".formatted(Thread.currentThread().getName()));		
		return ThreadLocalRandom.current().ints(1, 60).distinct().limit(6).sorted().boxed().toList();
	}

}