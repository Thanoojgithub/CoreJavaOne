package com.corejava.thread;

/**
 * Yield is a Static method and Native too. Yield tells the currently executing
 * thread to give a chance to the threads that have equal priority in the Thread
 * Pool. There is no guarantee that Yield will make the currently executing
 * thread to runnable state immediately. It can only make a thread from Running
 * State to Runnable State, not in wait or blocked state.
 * 
 * @author thanooj
 *
 */
public class YieldApp {

	public static void main(String[] args) {
		Thread even = new Even();
		even.setName("even");
		Thread odd = new Odd();
		odd.setName("odd");

		even.setPriority(Thread.MAX_PRIORITY);
		odd.setPriority(Thread.MAX_PRIORITY);

		even.start();
		odd.start();

	}

}

class Even extends Thread {
	public void run() {
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				System.out.println(Thread.currentThread().getName() + " :: " + i);
				Thread.yield();
			}
		}
	}
}

class Odd extends Thread {
	public void run() {
		for (int i = 1; i <= 10; i++) {
			if (i % 2 != 0) {
				System.out.println(Thread.currentThread().getName() + " :: " + i);
				Thread.yield();
			}
		}
	}
}

// OUT PUT ::

/*
 * 
 * odd :: 1 even :: 2 odd :: 3 even :: 4 odd :: 5 even :: 6 odd :: 7 even :: 8
 * odd :: 9 even :: 10
 * 
 */