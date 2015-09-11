package com.corejava.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerInMultiThreadEnvApp {

	public static void main(String[] args) {
		AtomicIntegerInMultiThreadEnv atomicIntegerInMultiThreadEnv = new AtomicIntegerInMultiThreadEnv();
		Thread tOne = new Thread(atomicIntegerInMultiThreadEnv);
		tOne.setName("tOne");
		Thread tTwo = new Thread(atomicIntegerInMultiThreadEnv);
		tTwo.setName("tTwo");
		tOne.start();
		tTwo.start();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (Thread.currentThread().getName().equals("main")) {
			System.out.println(Thread.currentThread().getName() + " Thread, finally i value is :: "
					+ atomicIntegerInMultiThreadEnv.getI());
		}

	}

}

class AtomicIntegerInMultiThreadEnv implements Runnable {

	private AtomicInteger i;

	public Integer getI() {
		return i.get();
	}

	public AtomicIntegerInMultiThreadEnv() {
		this.i = new AtomicInteger();
	}

	public void incI() {
		System.out.println("incI :: " + i.get() + " - " + Thread.currentThread().getName());
		i.getAndAdd(10);
		System.out.println("incI :: " + i.get() + " - " + Thread.currentThread().getName());
		i.getAndAdd(1);
		System.out.println("incI :: " + i.get() + " - " + Thread.currentThread().getName());
		i.getAndAdd(3);
	}

	@Override
	public void run() {
		incI();
		System.out.println(Thread.currentThread().getName() + " :: " + i.get());

	}
}