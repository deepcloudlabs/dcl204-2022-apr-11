package com.example;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyRunnableThreads {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Thread [%s] is running the main function.".formatted(Thread.currentThread().getName()));
		var task1 = new LotteryTask();
		var thread1 = new Thread(task1,"elma");

		var task2 = new LotteryTask();
		var thread2 = new Thread(task2,"armut");

		thread1.start();
		thread2.start();
		
		// synchronization
		thread1.join();
		System.out.println(task1.getLotteryNumbers());
		thread2.join();
		System.out.println(task2.getLotteryNumbers());
		
	}

}

class LotteryTask implements Runnable {
	private List<Integer> lotteryNumbers;

	@Override
	public void run() {
		System.out.println("Thread [%s] is running LotteryTask.".formatted(Thread.currentThread().getName()));		
		lotteryNumbers = ThreadLocalRandom.current().ints(1, 60).distinct().limit(6).sorted().boxed().toList();
	}

	public List<Integer> getLotteryNumbers() {
		return lotteryNumbers;
	}

}