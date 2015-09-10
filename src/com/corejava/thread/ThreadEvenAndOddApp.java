package com.corejava.thread;

public class ThreadEvenAndOddApp {

	public static void main(String[] args) {
		Integer n = 10;
		ThreadEven threadEven = new ThreadEven(n);
		threadEven.setName("threadEven");
		ThreadOdd threadOdd = new ThreadOdd(n);
		threadOdd.setName("threadOdd");
		threadEven.setPriority(Thread.MIN_PRIORITY);
		threadOdd.setPriority(Thread.MAX_PRIORITY);
		threadEven.start();
		threadOdd.start();

	}

}

class ThreadEven extends Thread {

	Integer n;

	public ThreadEven(Integer n) {
		this.n = n;
	}

	@Override
	public void run() {
		for (int i = 2; i <= n; i++) {
			if (i % 2 == 0) {
				System.out.println(i + "  | " + Thread.currentThread().getName());
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			} else {
				this.notify();
			}
		}
	}
}

class ThreadOdd extends Thread {

	Integer n;

	public ThreadOdd(Integer n) {
		this.n = n;
	}

	@Override
	public void run() {

		for (int i = 2; i <= n; i++) {
			if (i % 2 != 0) {
				System.out.println(i + "  | " + Thread.currentThread().getName());
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			} else {
				this.notify();
			}
		}
	}

}