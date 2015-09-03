package com.corejava.thread;

public class ThreadApp {

	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadStartThrowRTExcepion());
		Thread t2 = new Thread(new ThreadStartThrowRTExcepion());
		t1.start();
		t2.start();
	}

}

class ThreadStartThrowRTExcepion implements Runnable {

	public void run() {
		waitForSignal();
		throw new RuntimeException("Problem!!");
	}

	public void waitForSignal() {
		Object obj = new Object();
		synchronized (obj) {
			try {
				System.out.println("before wait "
						+ Thread.currentThread().getName() + " | "
						+ Thread.currentThread().getState().toString());
				obj.wait(10);
				System.out.println("after wait "
						+ Thread.currentThread().getName() + " | "
						+ Thread.currentThread().getState().toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("before notify " + Thread.currentThread().getName()
				+ " | " + Thread.currentThread().getState().toString());
		obj.notify();
		System.out.println("after notify " + Thread.currentThread().getName()
				+ " | " + Thread.currentThread().getState().toString());
	}

}