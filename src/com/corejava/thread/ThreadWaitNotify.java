package com.corejava.thread;

import java.util.Calendar;

public class ThreadWaitNotify {

	public static void main(String[] args) {
		final ROne rOne = new ROne();
		Thread tOne = new Thread("tOne") {
			@Override
			public void run() {
				rOne.doCountTick(0);
			}
		};
		Thread tTwo = new Thread("tTwo"){
			
			
		};

		tOne.start();
		tTwo.start();
	}

}

class ROne {

	public synchronized void doCountTick(Integer total) {
		System.out.println("ROne.doCountTick() - start");
		for (int i = 1 ; i <= 10000; i++) {
			total += 1;
			if (total == 100) {
				try {
					System.out.println(Calendar.getInstance().getTime() + " ROne.doCountTick() - before wait - " + total);
					wait();
					System.out.println(Calendar.getInstance().getTime() + " ROne.doCountTick() - after wait - " + total);
					// wait(1000L)
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("ROne.doCountTick() - end");
	}
	
	public synchronized void doCalcTickNotify(Integer total){
		System.out.println("ROne.doCalcTickNotify() - start");
		for (int i = 1 ; i <= 10000; i++) {
			total += 1;
			if (total == 1000) {
				System.out.println(Calendar.getInstance().getTime() + " ROne.doCalcTickNotify() - before notify - " + total);
				notify();
				System.out.println(Calendar.getInstance().getTime() + " ROne.doCalcTickNotify() - after notify - " + total);
			}
		}
		System.out.println("ROne.doCalcTickNotify() - end");
	}
	
}