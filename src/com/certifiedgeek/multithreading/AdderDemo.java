package com.certifiedgeek.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AdderDemo {

	/*
	 * Idea is to just explore the multi-threading concepts
	 * 
	 * Executor service is just a thread pool.
	 * It create fixed pool, cached pool and single thread in pool and execute runnable or callable.
	 * Execution is concurrent.
	 * 
	 */

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Inside main");
		ExecutorService executor = Executors.newFixedThreadPool(5);
		Future<Integer> future = null;
		for (int i = 0; i < 10; i++) {
			AdderCallable addCall = new AdderCallable((int) (Math.random() * 5), (int) (Math.random() * 3));
			future = executor.submit(addCall);
			System.out.println("Result :"+future.get());
		}
		executor.shutdown();

	}

}
