package com.corejava.thread;

/**
 * Threads ::
 * 
 * Why wait() and notify() nofityAll() is there in Object not in thread class,
 * and other hand, why thread has sleep(), join() and yield()?
 * 
 * In general in multi-threading concept, thread is a separate execution
 * process, which are independent with each other. as they are independent,
 * there should be some communication mediator, which is Object.
 * 
 * sleep() call, will keep the lock on object for a given milli-second to that
 * specific thread, where as wait() call do release the lock from that thread on
 * object, and let other thread will hold the lock, until notify() or
 * notifyAll() been called.
 * 
 * @author Thanooj Kalathuru
 *
 */
public class ThreadNotes {

	LooMe looMeRam = null;
	LooMe looMeSeeta = null;
	Thread threadSeeta = null;
	Thread threadRam = null;

	public void before() {
		System.out.println("----before---------");
		looMeRam = new LooMe("ram");
		looMeSeeta = new LooMe("seeta");
		threadSeeta = new Thread(new SimpleThread("seeta", looMeSeeta));
		threadSeeta.setName("threadSeeta");
		threadRam = new Thread(new SimpleThread("ram", looMeRam));
		threadRam.setName("threadRam");
	}

	public void after() {
		System.out.println("----after---------");
		looMeRam = null;
		looMeSeeta = null;
		threadSeeta = null;
		threadRam = null;
	}

	public void testThreadSeetaJoin() {
		/*
		 * Join() Join is a non static method. It lets one thread “join onto the
		 * end” of another thread. If you join Thread B to Thread A,now Thread B
		 * will not start until Thread A completes its run method execution. try
		 * { threadSeeta.join(); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */

		threadSeeta.start();
		try {
			threadSeeta.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		threadRam.start();
	}

	public void testThreadYield() {
		threadRam.setPriority(10); // Thread.NORM_PRIORITY = 5; default priority, in 10 - 1.
		threadSeeta.setPriority(1);
		threadSeeta.start();
		threadRam.start();
	}

	public static void main(String[] args) {
		ThreadNotes threadNotes = new ThreadNotes();

		threadNotes.before();
		threadNotes.testThreadSeetaJoin();
		threadNotes.after();
		System.out.println("---------------******************----------------");
		threadNotes.before();
		threadNotes.testThreadYield();
		threadNotes.after();
	}
}

class SimpleThread implements Runnable {

	private LooMe looMe;
	private String str;

	public LooMe getLooMe() {
		return looMe;
	}

	public void setLooMe(LooMe looMe) {
		this.looMe = looMe;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public SimpleThread(String str, LooMe looMe) {
		this.str = str;
		this.looMe = looMe;
	}

	@Override
	public void run() {
		looMe.loopMeforNTimes();
	}

}

class LooMe {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LooMe(String name) {
		this.name = name;
	}

	public void loopMeforNTimes() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " " + getName() + " | "
					+ Thread.currentThread().getName());
			try {
				Thread.sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("DONE! " + getName() + " | "
				+ Thread.currentThread().getName());
	}
}