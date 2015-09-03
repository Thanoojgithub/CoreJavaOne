package com.corejava.thread;

public class ThreadSyncApp {
	public static void main(String[] args) {

		Thread t1 = new Thread(new AccThread(), "Ram");
		Thread t2 = new Thread(new AccThread(), "Seeta");

		t1.start();
		t2.start();
		System.out.println("done.");
	}
}

class AccThread implements Runnable {

	private Account account;
	private int withdrawAmt = 40;

	public AccThread() {
		account = new Account(100);
	}

	public void run() {
		int bal = account.getBal();
		for (int i = 0; i < Integer.valueOf(bal / withdrawAmt) + 1; i++) {
			account.makeWithdrawal(withdrawAmt);
			account.showBal();
		}
	}
}

class Account {

	private int bal;

	public void withdraw(int amt) {
		if (amt > bal) {
			System.out.println(Thread.currentThread().getName() + " is not having sufficient balance to withdraw.");
		} else {
			setBal(getBal() - amt);
		}
	}

	public Account(int bal) {
		this.bal = bal;
	}

	public int getBal() {
		return bal;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}

	public void makeWithdrawal(int amt) {
		System.out.println(Thread.currentThread().getName() + " is going to withdraw.");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		withdraw(amt);
		System.out.println(Thread.currentThread().getName() + " withdraw completed.");
	}

	public void showBal() {
		/*
		 * try { Thread.sleep(1000); } catch (Exception e) { }
		 */
		System.out.println(Thread.currentThread().getName() + " having " + getBal() + "/- Rs");
	}

}

//OUTPUT ::
/*
 * 
 * 1. Thread.currentThread().wait(1000);
done.
Seeta is going to withdraw.
Ram is going to withdraw.
Seeta withdraw completed.
Ram withdraw completed.
Seeta having 60/- Rs
Ram having 60/- Rs
Ram is going to withdraw.
Seeta is going to withdraw.
Ram withdraw completed.
Seeta withdraw completed.
Ram having 20/- Rs
Seeta having 20/- Rs
Ram is going to withdraw.
Seeta is going to withdraw.
Ram is not having sufficient balance to withdraw.
Seeta is not having sufficient balance to withdraw.
Ram withdraw completed.
Seeta withdraw completed.
Ram having 20/- Rs
Seeta having 20/- Rs




2. when NO Thread.currentThread().wait(1000); and Thread.wait(1000);
done.
Ram is going to withdraw.
Ram withdraw completed.
Ram having 60/- Rs
Ram is going to withdraw.
Ram withdraw completed.
Ram having 20/- Rs
Ram is going to withdraw.
Ram is not having sufficient balance to withdraw.
Ram withdraw completed.
Ram having 20/- Rs
Seeta is going to withdraw.
Seeta withdraw completed.
Seeta having 60/- Rs
Seeta is going to withdraw.
Seeta withdraw completed.
Seeta having 20/- Rs
Seeta is going to withdraw.
Seeta is not having sufficient balance to withdraw.
Seeta withdraw completed.
Seeta having 20/- Rs


3. using, Thread.wait(1000), current thread will lock the object for given milli seconds.

 */
