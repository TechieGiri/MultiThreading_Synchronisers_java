package com.certifiedgeek.multithreading.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierThread implements Runnable {

	private CyclicBarrier barrier;
	private String name;

	public CyclicBarrierThread(String name, CyclicBarrier barrier) {
		this.name = name;
		this.barrier = barrier;
	}

	@Override
	public void run() {

		try {
			System.out.println(name + " is ready & waiting for play!");
			barrier.await();//All threads/parties will come wait a@ this point
			System.out.println(name + " is playing!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
