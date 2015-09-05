package com.corejava.thread;

import java.util.Calendar;

public class ThreadSyncMethodAndSyncBlock {

	public static void main(String[] args) {
		//syncMethodAndBlockWithDiffObjects();
		syncMethodAndBlockWithSharedObject();
	}

	private static void syncMethodAndBlockWithDiffObjects() {
		SyncMethodAndSyncBlock syncMethodAndSyncBlock1 = new SyncMethodAndSyncBlock();
		Thread t1 = new Thread(syncMethodAndSyncBlock1);
		t1.setName("tOne");
		SyncMethodAndSyncBlock syncMethodAndSyncBlock2 = new SyncMethodAndSyncBlock();
		Thread t2 = new Thread(syncMethodAndSyncBlock2);
		t2.setName("tTwo");
		
		t1.start();
		t2.start();
	}
	
	private static void syncMethodAndBlockWithSharedObject() {
		SyncMethodAndSyncBlock syncMethodAndSyncBlock = new SyncMethodAndSyncBlock();
		Thread t1 = new Thread(syncMethodAndSyncBlock);
		t1.setName("tOne");
		Thread t2 = new Thread(syncMethodAndSyncBlock);
		t2.setName("tTwo");
		
		t1.start();
		t2.start();
	}

}

class SyncMethodAndSyncBlock implements Runnable {

	private Integer bId;
	private String bName;

	public Integer getbId() {
		return bId;
	}

	public void setbId(Integer bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	@Override
	public void run() {
		//syncStaticMethod();
		syncStaticBlockMethod();
		//syncMethod();
		//syncBlock();
		//syncStaticMethod();
	}
	
	public static synchronized void syncStaticMethod() {
		System.out.println(Calendar.getInstance().getTime() + " SyncMethodAndSyncBlock.syncStaticMethod() - start :: " + Thread.currentThread().getName() + " | "
				+ Thread.activeCount());
		try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Calendar.getInstance().getTime()+ " SyncMethodAndSyncBlock.syncStaticMethod() - end :: " + Thread.currentThread().getName() + " | "
				+ Thread.activeCount());
	}
	
	public static void syncStaticBlockMethod() {
		System.out.println(Calendar.getInstance().getTime() + " SyncMethodAndSyncBlock.syncStaticBlockMethod() - start :: " + Thread.currentThread().getName() + " | "
				+ Thread.activeCount());
		synchronized(SyncMethodAndSyncBlock.class){
		try {
			System.out.println(Calendar.getInstance().getTime() + " SyncMethodAndSyncBlock.syncStaticBlockMethod() :: " + Thread.currentThread().getName() + " | "
					+ Thread.activeCount());
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
		System.out.println(Calendar.getInstance().getTime()+ " SyncMethodAndSyncBlock.syncStaticBlockMethod() - end :: " + Thread.currentThread().getName() + " | "
				+ Thread.activeCount());
	}

	public synchronized void syncMethod() {
		System.out.println(Calendar.getInstance().getTime() + " SyncMethodAndSyncBlock.syncMethod() - start :: " + Thread.currentThread().getName() + " | "
				+ Thread.activeCount());
		try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Calendar.getInstance().getTime() + " SyncMethodAndSyncBlock.syncMethod() - end :: " + Thread.currentThread().getName() + " | "
				+ Thread.activeCount());
	}

	public void syncBlock() {
		System.out.println(Calendar.getInstance().getTime() + " SyncMethodAndSyncBlock.syncBlock() - start :: " + Thread.currentThread().getName());
		synchronized (this) {
			System.out.println(Calendar.getInstance().getTime() + " SyncMethodAndSyncBlock.syncBlock() :: " + Thread.currentThread().getName() + " | "
					+ Thread.activeCount());
			try {
				Thread.sleep(10000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Calendar.getInstance().getTime() + " SyncMethodAndSyncBlock.syncBlock() - end :: " + Thread.currentThread().getName());
	}

}

/*
OUT PUT - syncMethodAndBlockWithDiffObjects() 

OUT PUT - different Object - syncBlock()
Sat Sep 05 23:06:48 IST 2015 SyncMethodAndSyncBlock.syncBlock() - start :: tTwo
Sat Sep 05 23:06:48 IST 2015 SyncMethodAndSyncBlock.syncBlock() - start :: tOne
Sat Sep 05 23:06:48 IST 2015 SyncMethodAndSyncBlock.syncBlock() :: tTwo | 3
Sat Sep 05 23:06:48 IST 2015 SyncMethodAndSyncBlock.syncBlock() :: tOne | 3
Sat Sep 05 23:06:58 IST 2015 SyncMethodAndSyncBlock.syncBlock() - end :: tOne
Sat Sep 05 23:06:58 IST 2015 SyncMethodAndSyncBlock.syncBlock() - end :: tTwo

OUT PUT - different Object - syncMethod()
Sat Sep 05 22:45:11 IST 2015 SyncMethodAndSyncBlock.syncMethod() - start :: tTwo | 3
Sat Sep 05 22:45:11 IST 2015 SyncMethodAndSyncBlock.syncMethod() - start :: tOne | 3
Sat Sep 05 22:45:21 IST 2015 SyncMethodAndSyncBlock.syncMethod() - end :: tOne | 3
Sat Sep 05 22:45:21 IST 2015 SyncMethodAndSyncBlock.syncMethod() - end :: tTwo | 3

OUT PUT - different Object - syncStaticMethod()

Sat Sep 05 23:10:58 IST 2015 SyncMethodAndSyncBlock.syncStaticMethod() - start :: tOne | 3
Sat Sep 05 23:11:08 IST 2015 SyncMethodAndSyncBlock.syncStaticMethod() - end :: tOne | 3
Sat Sep 05 23:11:08 IST 2015 SyncMethodAndSyncBlock.syncStaticMethod() - start :: tTwo | 2
Sat Sep 05 23:11:18 IST 2015 SyncMethodAndSyncBlock.syncStaticMethod() - end :: tTwo | 2

OUT PUT - different Object - syncStaticBlockMethod()

Sat Sep 05 23:16:59 IST 2015 SyncMethodAndSyncBlock.syncStaticBlockMethod() - start :: tTwo | 3
Sat Sep 05 23:16:59 IST 2015 SyncMethodAndSyncBlock.syncStaticBlockMethod() - start :: tOne | 3
Sat Sep 05 23:16:59 IST 2015 SyncMethodAndSyncBlock.syncStaticBlockMethod() :: tTwo | 3
Sat Sep 05 23:17:09 IST 2015 SyncMethodAndSyncBlock.syncStaticBlockMethod() :: tOne | 3
Sat Sep 05 23:17:09 IST 2015 SyncMethodAndSyncBlock.syncStaticBlockMethod() - end :: tTwo | 3
Sat Sep 05 23:17:19 IST 2015 SyncMethodAndSyncBlock.syncStaticBlockMethod() - end :: tOne | 2


------------------------------------------------------------------------------------


OUT PUT - syncMethodAndBlockWithSharedObject()

OUT PUT - shared Object - synchMethod()
Sat Sep 05 22:50:04 IST 2015 SyncMethodAndSyncBlock.syncMethod() - start :: tOne | 3
Sat Sep 05 22:50:14 IST 2015 SyncMethodAndSyncBlock.syncMethod() - end :: tOne | 3
Sat Sep 05 22:50:14 IST 2015 SyncMethodAndSyncBlock.syncMethod() - start :: tTwo | 2
Sat Sep 05 22:50:24 IST 2015 SyncMethodAndSyncBlock.syncMethod() - end :: tTwo | 2

OUT PUT - shared Object - syncBlock()
Sat Sep 05 23:04:19 IST 2015 SyncMethodAndSyncBlock.syncBlock() - start :: tTwo
Sat Sep 05 23:04:19 IST 2015 SyncMethodAndSyncBlock.syncBlock() - start :: tOne
Sat Sep 05 23:04:19 IST 2015 SyncMethodAndSyncBlock.syncBlock() :: tTwo | 3
Sat Sep 05 23:04:29 IST 2015 SyncMethodAndSyncBlock.syncBlock() :: tOne | 3
Sat Sep 05 23:04:29 IST 2015 SyncMethodAndSyncBlock.syncBlock() - end :: tTwo
Sat Sep 05 23:04:39 IST 2015 SyncMethodAndSyncBlock.syncBlock() - end :: tOne

OUT PUT - shared Object - syncStaticMethod()

Sat Sep 05 23:20:25 IST 2015 SyncMethodAndSyncBlock.syncStaticMethod() - start :: tOne | 3
Sat Sep 05 23:20:35 IST 2015 SyncMethodAndSyncBlock.syncStaticMethod() - end :: tOne | 3
Sat Sep 05 23:20:35 IST 2015 SyncMethodAndSyncBlock.syncStaticMethod() - start :: tTwo | 2
Sat Sep 05 23:20:45 IST 2015 SyncMethodAndSyncBlock.syncStaticMethod() - end :: tTwo | 2

OUT PUT - shared Object - syncStaticBlockMethod()

Sat Sep 05 23:21:53 IST 2015 SyncMethodAndSyncBlock.syncStaticBlockMethod() - start :: tOne | 3
Sat Sep 05 23:21:53 IST 2015 SyncMethodAndSyncBlock.syncStaticBlockMethod() - start :: tTwo | 3
Sat Sep 05 23:21:53 IST 2015 SyncMethodAndSyncBlock.syncStaticBlockMethod() :: tOne | 3
Sat Sep 05 23:22:03 IST 2015 SyncMethodAndSyncBlock.syncStaticBlockMethod() :: tTwo | 3
Sat Sep 05 23:22:03 IST 2015 SyncMethodAndSyncBlock.syncStaticBlockMethod() - end :: tOne | 3
Sat Sep 05 23:22:13 IST 2015 SyncMethodAndSyncBlock.syncStaticBlockMethod() - end :: tTwo | 2

*/
