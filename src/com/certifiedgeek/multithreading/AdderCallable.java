package com.certifiedgeek.multithreading;

import java.util.concurrent.Callable;

public class AdderCallable implements Callable<Integer> {

	private Integer operand1, operand2;
	private static Integer result;

	public AdderCallable(Integer operand1, Integer operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("Currently " + Thread.currentThread().getName() + " is executing!");
		//this.setOperand1((int) (Math.random() * 5));
		//this.setOperand2((int) (Math.random() * 10));
		result = add(operand1, operand2);
		System.out.println("Returning from call()" + result);
		return result;
	}

	public Integer add(Integer operand1, Integer operand2) {
		System.out.println("operand1: " + operand1 + ": operand2: " + operand2);
		return operand1 * operand2;
	}

	public Integer getOperand1() {
		return operand1;
	}

	public void setOperand1(Integer operand1) {
		this.operand1 = operand1;
	}

	public Integer getOperand2() {
		return operand2;
	}

	public void setOperand2(Integer operand2) {
		this.operand2 = operand2;
	}
}
