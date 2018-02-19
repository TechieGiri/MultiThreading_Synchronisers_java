package com.certifiedgeek.multithreading.futuretask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeoutException;

/*
 * FutureTask is base concrete implementation of Future interface and provides asynchronous processing. 
 * It contains the methods to start and cancel a task and also methods that can return the state of the 
 * FutureTask as whether it’s completed or cancelled. We need a callable object to create a future task 
 * and then we can use Java Thread Pool Executor to process these asynchronously.
 */

public class FutureTaskDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		FutureTaskCallable ftc1 = new FutureTaskCallable(200);
		FutureTaskCallable ftc2 = new FutureTaskCallable(100);

		FutureTask<String> ft1 = new FutureTask<String>(ftc1);
		FutureTask<String> ft2 = new FutureTask<String>(ftc2);

		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(ft1);
		service.execute(ft2);

		while (true) {
			if (!(ft1.isDone() && ft2.isDone())) {
				System.out.println("FutureTask1 output=" + ft1.get());
				System.out.println("FutureTask2 output=" + ft2.get());
			} else {
				System.out.println("Shutting the service..");
				service.shutdown();
				System.out.println("Service shut..");
				return;
			}
		}
	}
}
