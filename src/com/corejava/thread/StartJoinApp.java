package com.corejava.thread;

public class StartJoinApp {

	public static void main(String[] args) {

		Thread tOne = new Thread(new Runnable() {
			public void run() {
				System.out.println("Thread tOne has started");
				System.out.println("Thread tOne, sleeping for 3 seconds");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread tOne has completed");
			}
		}, "tOne");
		Thread tTwo = new Thread(new Runnable() {
			public void run() {
				System.out.println("Thread tTwo has completed");
			}
		}, "tTwo");
		tOne.start();
		try {
			//tOne.join();
			tTwo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tTwo.start();
	}

}
