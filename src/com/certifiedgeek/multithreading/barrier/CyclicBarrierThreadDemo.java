package com.certifiedgeek.multithreading.barrier;

import java.util.concurrent.CyclicBarrier;

/*
 *1.It is a barrier that all threads must wait at, 
 *	until all threads reach it, before any of the threads can continue.
 *2.The threads wait for each other by calling the await() method on the CyclicBarrier. 
 *	Once N threads are waiting at the CyclicBarrier, all threads are released and can continue running.
 *Advantage over CountDownLatch:
 *------------------------------
 *1. It is reusable thru reset() unlike countdown latch    
 */


public class CyclicBarrierThreadDemo {

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3,new Runnable() {
			@Override
			public void run(){
			System.out.println("Lets start playing !");	
			}
		});
		
		//CyclicBarrier barrier = new CyclicBarrier(3); 
		CyclicBarrierThread rt1 = new CyclicBarrierThread("santosh",barrier);
		CyclicBarrierThread rt2 = new CyclicBarrierThread("giri",barrier);
		CyclicBarrierThread rt3 = new CyclicBarrierThread("ramnaresh",barrier);
		
		Thread t1 = new Thread(rt1);
		Thread t2 = new Thread(rt2);
		Thread t3 = new Thread(rt3);
		
		t1.start();
		t2.start();
		t3.start();

	}

}
