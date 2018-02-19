package com.certifiedgeek.multithreading.semaphore;

import java.util.concurrent.Semaphore;
/*
 * A semaphore controls access to a shared resource through the use of a counter. 
 * If the counter is greater than zero, then access is allowed. 
 * If it is zero, then access is denied. What the counter is counting are permits that allow access to the shared resource. 
 * Thus, to access the resource, a thread must be granted a permit from the semaphore.
 */


public class SemaphoreDemo {

	public static void main(String[] args) {
		Semaphore sem =  new Semaphore(1);
		
		SemaphoreThread semT1 = new SemaphoreThread(sem, "santosh");
		SemaphoreThread semT2 = new SemaphoreThread(sem, "giri");

		Thread t1 = new Thread(semT1);
		Thread t2 = new Thread(semT2);
		
		t1.start();
		t2.start();
	}

}
