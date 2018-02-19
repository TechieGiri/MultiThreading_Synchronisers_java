package com.certifiedgeek.multithreading.latch;

import java.util.concurrent.CountDownLatch;

/*
 *1.CountDownLatch in Java is a kind of synchronizer which allows one Thread  to wait for one or more 
 *	Threads before starts processing.
 *2.CountDownLatch also allows flexibility on number of thread for which main thread should wait, 
 *	It can wait for one thread or n number of thread, there is not much change on code.
 *3.CountDownLatch works in latch principle,  main thread will wait until Gate is open. 
 *	One thread waits for n number of threads specified while creating CountDownLatch in Java.
 *4.Any thread, usually main thread of application, which calls CountDownLatch.await() will 
 *	wait until count reaches zero or its interrupted by another Thread. 
 *	All other thread are required to do count down by calling CountDownLatch.countDown() 
 *	once they are completed or ready to the job. as soon as count reaches zero, Thread awaiting starts running.
 *Disadvantage:
 *--------------
 *1.One of the disadvantage of CountDownLatch is that its not reusable once count 
 *	reaches to zero you can not use CountDownLatch any more, concurrency API has another concurrent utility 
 *	called CyclicBarrier for such requirements.
 */


public class CountDownLatchDemo {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);

		StartServicesCountDownLatch t1 = new StartServicesCountDownLatch(latch, "ValidatorService");
		StartServicesCountDownLatch t2 = new StartServicesCountDownLatch(latch, "DataService");
		StartServicesCountDownLatch t3 = new StartServicesCountDownLatch(latch, "CacheService");

		Thread valSerT = new Thread(t1);
		Thread datSerT = new Thread(t2);
		Thread cacSerT = new Thread(t3);

		valSerT.start();
		datSerT.start();
		cacSerT.start();

		try {
			//main thread is awaiting here.
			latch.await();
			System.out.println(Thread.currentThread().getName() + " : All the service are Up!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
