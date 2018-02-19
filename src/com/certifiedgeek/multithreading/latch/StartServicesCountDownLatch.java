package com.certifiedgeek.multithreading.latch;

import java.util.concurrent.CountDownLatch;

public class StartServicesCountDownLatch implements Runnable {

	private CountDownLatch latch;
	private String name;

	public StartServicesCountDownLatch(CountDownLatch latch, String name) {
		super();
		this.latch = latch;
		this.name = name;
	}

	@Override
	public void run() {
		startService(name);
	}

	private void startService(String threadName) {
		try {
			System.out.println(threadName + " is starting!");
			Thread.sleep(100);
			System.out.println(threadName + " started!");
			this.latch.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
