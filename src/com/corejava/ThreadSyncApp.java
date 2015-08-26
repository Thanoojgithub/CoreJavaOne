package com.corejava;

public class ThreadSyncApp {
	public static void main(String[] args) {
		Thread t1 = new Thread(new AccThread(), "sriram");
		Thread t2 = new Thread(new AccThread(), "seeta");

		t1.start();
		t2.start();
	}
}

class AccThread implements Runnable {

	private Account account;
	private int withdrawAmt = 500;

	public AccThread() {
		account = new Account(5001);
	}

	public void run() {
		int locbal = account.getbal();
		for (int i = 0; i < locbal / withdrawAmt; i++) {
			account.showBal();
			account.makeWithdrawal(withdrawAmt);
			account.showBal();
		}
	}
}

class Account {

	int bal = 6600;

	public void withdraw(int amt) {
		if (amt > bal) {
			System.out.println(Thread.currentThread().getName() + " is not having sufficient balance to withdraw.");
		} else {
			bal -= amt;
		}
	}

	public int getbal() {
		return bal;
	}

	public Account(int bal) {
		this.bal = bal;
	}

	public synchronized void makeWithdrawal(int amt) {
		System.out.println(Thread.currentThread().getName() + " is going to withdraw.");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		withdraw(amt);
		System.out.println(Thread.currentThread().getName() + " is completed..." + getbal());
	}

	public void showBal() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		System.out.println(Thread.currentThread().getName() + " having " + getbal() + "/- Rs");
	}

}
