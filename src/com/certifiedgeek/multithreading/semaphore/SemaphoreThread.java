package com.certifiedgeek.multithreading.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreThread implements Runnable {

	private Semaphore sem;
	private String name;
	private static int count;

	public SemaphoreThread(Semaphore sem, String name) {
		this.sem = sem;
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " inside run and waiting for permit");
		if (name.equals("santosh")) {
			try {
				sem.acquire();
				System.out.println("Got the permit : "+Thread.currentThread().getName());
				//System.out.println("count is :" + count + " " + Thread.currentThread().getName());
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sem.release();
			System.out.println("Release the permit: "+Thread.currentThread().getName());
		}
		else if (name.equals("giri")) {
			try {
				sem.acquire();
				System.out.println("Got the permit : "+Thread.currentThread().getName());
				//System.out.println("count is :" + count + " " + Thread.currentThread().getName());
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sem.release();
			System.out.println("Release the permit: "+Thread.currentThread().getName());
		}
	}
}
