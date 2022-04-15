package com.example;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyRaceConditions {

	public static void main(String[] args) throws InterruptedException {
		var task = new AnotherTask();
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		Thread t3 = new Thread(task);
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		System.out.println(task.getCounter()); // 300_000 ?
	}

}

class A{}
// Thread-Safe:  i) Lock 
//              ii) Atomic Variable 
//             iii) Immutability 
//              iv) Do not share your state between threads
class AnotherTask implements Runnable {
	private int counter = 0; // Heap
//	private AtomicInteger counter = new AtomicInteger();

	@Override
	public void run() {
		for (Integer i = 0; i < 100_000; ++i)
			synchronized (A.class) { // monitor -> mutual exlusion
//				counter.incrementAndGet();			
				counter++;
			}
	}

	public int getCounter() {
//		return counter.get();
		return counter;
	}

}
