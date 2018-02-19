package com.certifiedgeek.multithreading.futuretask;

import java.util.concurrent.Callable;

public class FutureTaskCallable implements Callable<String> {

	private long delay;

	public FutureTaskCallable(long delay) {
		this.delay = delay;
	}

	@Override
	public String call() throws Exception {
		System.out.println("Calculating complex logic "+Thread.currentThread().getName());
		Thread.sleep(delay);
		System.out.println("Calculated complex logic "+Thread.currentThread().getName());
		return Thread.currentThread().getName();
	}

}
