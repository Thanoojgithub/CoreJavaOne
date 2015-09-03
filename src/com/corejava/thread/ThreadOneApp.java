package com.corejava.thread;

public class ThreadOneApp {

	public static void main(String[] args) {
		final Emp emp = new Emp();
		Thread thread1 = new Thread() {
			public void run() {
				emp.method1();
			}
		};
		Thread thread2 = new Thread() {
			public void run() {
				emp.method2();

			}
		};
		/**
		 * OUTPUT:
		 * Emp.method1()- start
			getEname() :: null
			Emp.method1()- setEname - sop before call
			Emp.method2()
			Emp.method1()- setEname - sop after call
			Emp.method1()xyz
			Emp.method1()- end
		 * 
		 */
		thread1.start();
		thread2.start();

		/*
		 * OUTPUT : 
		 * Emp.method1()- start 
		 * Emp.method1()xyz 
		 * Emp.method1()- end xyz 
		 * Emp.method2()
		 * 
		 * 
		 * emp.method1(); 
		 * emp.method2();
		 */
	}
}

class Emp {

	private volatile String ename;

	public Emp() {
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public void method1() {
		System.out.println("Emp.method1()- start");
		try {
			System.out.println("Emp.method1()- setEname - sop before call");
			setEname("xyz");
			System.out.println("Emp.method1()- setEname - sop after call");
			synchronized (this) {
				Thread.sleep(10000l);
				System.out.println("Emp.method1()" + ename);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Emp.method1()- end");
	}

	public void method2() {
		System.out.println("getEname() :: "+getEname());
		System.out.println("Emp.method2()");
	}
}
