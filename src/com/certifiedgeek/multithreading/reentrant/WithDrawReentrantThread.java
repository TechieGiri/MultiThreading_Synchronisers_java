package com.certifiedgeek.multithreading.reentrant;

import java.util.concurrent.locks.Lock;

public class WithDrawReentrantThread implements Runnable {

	private int amount;
	private static Integer accountBalance = 100;
	private Lock lock;

	public WithDrawReentrantThread(int amount, Lock lock) {
		this.amount = amount;
		this.lock = lock;
	}

	@Override
	public void run() {
		System.out.println("Inside run method " + Thread.currentThread().getName());

		doOperation();
	}

	public void doOperation() {

		try {

			System.out.println(Thread.currentThread().getName() + " withdrawning amt " + amount);
			lock.lock();

			if (accountBalance >= amount) {
				System.out.println(Thread.currentThread().getName() + " successfully withdrawn");
				accountBalance = accountBalance - amount;
				lock.unlock();
			} else {
				System.out.println(Thread.currentThread().getName() + " Insufficient balance");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
