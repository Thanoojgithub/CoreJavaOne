package com.corejava.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;

public class AtomicInMultiThreadEnvApp {

	public static void main(String[] args) {
		AtomicIntegerInMultiThreadEnv atomicIntegerInMultiThreadEnv = new AtomicIntegerInMultiThreadEnv();
		Thread tOne = new Thread(atomicIntegerInMultiThreadEnv);
		tOne.setName("tOne");
		Thread tTwo = new Thread(atomicIntegerInMultiThreadEnv);
		tTwo.setName("tTwo");
		tOne.start();
		tTwo.start();
		
		AtomicLongArrayMultiThreadEnv atomicLongArrayMultiThreadEnv = new AtomicLongArrayMultiThreadEnv();
		Thread tThree = new Thread(atomicLongArrayMultiThreadEnv);
		tOne.setName("tThree");
		Thread tFour = new Thread(atomicLongArrayMultiThreadEnv);
		tTwo.setName("tFour");
		tThree.start();
		tFour.start();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (Thread.currentThread().getName().equals("main")) {
			System.out.println(Thread.currentThread().getName() + " Thread, finally i value is :: "
					+ atomicIntegerInMultiThreadEnv.getI());
			System.out.println(Thread.currentThread().getName() + " Thread, finally i value is :: "
					+ atomicLongArrayMultiThreadEnv.getArr());
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
		System.out.println("1 - incI :: " + i.get() + " - " + Thread.currentThread().getName());
		i.getAndAdd(10);
		System.out.println("2 - incI :: " + i.get() + " - " + Thread.currentThread().getName());
		i.getAndAdd(1);
		System.out.println("3 - incI :: " + i.get() + " - " + Thread.currentThread().getName());
		i.getAndAdd(3);
	}

	@Override
	public void run() {
		incI();
		System.out.println(Thread.currentThread().getName() + " :: " + i.get());

	}
}

class AtomicLongArrayMultiThreadEnv implements Runnable {

	private AtomicLongArray arr;

	public AtomicLongArray getArr() {
		return this.arr;
	}

	public AtomicLongArrayMultiThreadEnv() {
		this.arr = new AtomicLongArray(5);
	}

	public void incArr() {
		System.out.println("1 - incArr :: " + getArr() + " - " + Thread.currentThread().getName());
		getArr().getAndSet(0, 10);
		getArr().getAndAdd(0, 1);
		System.out.println("2 - incArr :: " + getArr() + " - " + Thread.currentThread().getName());
		getArr().getAndAdd(0, 1);
		getArr().getAndSet(0, 15);
		System.out.println("3 - incArr :: " + getArr() + " - " + Thread.currentThread().getName());
		getArr().compareAndSet(0, 15, 100);
	}

	@Override
	public void run() {
		incArr();
		System.out.println(Thread.currentThread().getName() + " :: " + getArr());

	}
}

//OUT PUT ::

/**
 * 
 * 
1 - incI :: 0 - tTwo
1 - incI :: 0 - tOne
2 - incI :: 10 - tTwo
2 - incI :: 20 - tOne
3 - incI :: 21 - tTwo
3 - incI :: 22 - tOne
tTwo :: 25
tOne :: 28
main Thread, finally i value is :: 28



1 - incArr :: [0, 0, 0, 0, 0] - Thread-3
1 - incArr :: [0, 0, 0, 0, 0] - Thread-2
2 - incArr :: [11, 0, 0, 0, 0] - Thread-3
2 - incArr :: [11, 0, 0, 0, 0] - Thread-2
3 - incArr :: [15, 0, 0, 0, 0] - Thread-3
3 - incArr :: [15, 0, 0, 0, 0] - Thread-2
Thread-3 :: [100, 0, 0, 0, 0]
Thread-2 :: [100, 0, 0, 0, 0]
main Thread, finally i value is :: [100, 0, 0, 0, 0]
 * 
 * 
 */
