package com.corejava.thread;

public class ThreadSyncMethodAndSyncBlock {

	public static void main(String[] args) {
		syncMethodAndBlockWithDiffObjects();
		//syncMethodAndBlockWithSharedObject();
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
		syncMethod();
		//syncBlock();
	}

	public synchronized void syncMethod() {
		System.out.println("SyncMethodAndSyncBlock.syncMethod() - start :: " + Thread.currentThread().getName() + " | "
				+ Thread.activeCount());
		try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("SyncMethodAndSyncBlock.syncMethod() - end :: " + Thread.currentThread().getName() + " | "
				+ Thread.activeCount());
	}

	public void syncBlock() {
		System.out.println("SyncMethodAndSyncBlock.syncBlock() - start :: " + Thread.currentThread().getName());
		synchronized (this) {
			System.out.println("SyncMethodAndSyncBlock.syncBlock() :: " + Thread.currentThread().getName() + " | "
					+ Thread.activeCount());
			try {
				Thread.sleep(10000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("SyncMethodAndSyncBlock.syncBlock() - end :: " + Thread.currentThread().getName());
	}

}