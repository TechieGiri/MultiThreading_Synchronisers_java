package com.certifiedgeek.multithreading.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/*
 * Idea is to create a operation in which concurrency gets failed and can be
 * managed by synchronizers e.g. Locks Latches FutureTask Semaphore Barriers
 * 
 * Reentrant Lock: is similar to synchronized keyword with few more flexibility
 * Difference synchronized vs Reentrant Lock
 * =========================================
 * 1. Java Lock API provides more visibility and options for locking, 
 * unlike synchronized where a thread might end up waiting indefinitely for the lock, 
 * we can use tryLock() to make sure thread waits for specific time only. 
 *
 * 2. Synchronization code is much cleaner and easy to maintain whereas 
 * with Lock we are forced to have try-finally block to make sure Lock is released 
 * even if some exception is thrown between lock() and unlock() method calls.
 * 
 * 3. Synchronization blocks or methods can cover only one method whereas we 
 * can acquire the lock in one method and release it in another method with Lock API.
 * 
 * 4. Synchronized keyword doesn’t provide fairness whereas we can set fairness 
 * to true while creating ReentrantLock object so that longest waiting thread gets the lock first.
 * 
 */
public class BankTransactionReentrantDemo {

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		WithDrawReentrantThread tt1 = new WithDrawReentrantThread(50, lock);
		WithDrawReentrantThread tt2 = new WithDrawReentrantThread(80, lock);

		Thread t1 = new Thread(tt1, "Santosh");
		Thread t2 = new Thread(tt2, "Giri");

		t1.start();
		t2.start();
	}
}
