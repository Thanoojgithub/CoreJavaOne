package com.corejava.thread.executor;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkerThreadApp {

	public static void main(String[] args) {
		/*
		 * 
		 * Creates a thread pool that reuses a fixed number of threads operating
		 * off a shared unbounded queue. At any point, at most nThreads threads
		 * will be active processing tasks. If additional tasks are submitted
		 * when all threads are active, they will wait in the queue until a
		 * thread is available. If any thread terminates due to a failure during
		 * execution prior to shutdown, a new one will take its place if needed
		 * to execute subsequent tasks. The threads in the pool will exist until
		 * it is explicitly shutdown.
		 * 
		 * 
		 * Parameters: nThreads the number of threads in the pool 
		 * Returns: the newly created thread pool 
		 * Throws: IllegalArgumentException - if nThreads <= 0
		 * 
		 * 
		 * void java.util.concurrent.ExecutorService.shutdown()
		 * 
		 * Initiates an orderly shutdown in which previously submitted tasks are
		 * executed, but no new tasks will be accepted. Invocation has no
		 * additional effect if already shut down.
		 * 
		 * This method does not wait for previously submitted tasks to complete
		 * execution. Use awaitTermination to do that.
		 * 
		 * Throws: SecurityException - if a security manager exists and shutting
		 * down this ExecutorService may manipulate threads that the caller is
		 * not permitted to modify because it does not hold.
		 * 
		 * java.lang.RuntimePermission("modifyThread"), or the security
		 * manager's checkAccess method denies access.
		 * 
		 * 
		 * boolean java.util.concurrent.ExecutorService.awaitTermination(long
		 * timeout, TimeUnit unit) throws InterruptedException
		 * 
		 * Blocks until all tasks have completed execution after a shutdown
		 * request, or the timeout occurs, or the current thread is interrupted,
		 * whichever happens first.
		 * 
		 * Parameters: 
		 * timeout the maximum time to wait unit the time 
		 * unit of the timeout argument 
		 * Returns: 
		 * true if this executor terminated and false if the timeout elapsed before termination 
		 * Throws:
		 * InterruptedException - if interrupted while waiting
		 * 
		 * 
		 */
		ExecutorService executor = Executors.newFixedThreadPool(1);
		//getPoolSize() -  Returns the current number of threads in the pool.
		for (int i = 1; i <= 10; i++) {
			Runnable worker = new WorkerThread("thread" + i);
			/*
			 * Executes the given command at some time in the future. The
			 * command may execute in a new thread, in a pooled thread, or in
			 * the calling thread, at the discretion of the Executor
			 * implementation.
			 * 
			 * Parameters: command the runnable task 
			 * Throws:
			 * RejectedExecutionException - if this task cannot be accepted for
			 * execution. NullPointerException - if command is null
			 */
			executor.execute(worker);
		}
		//shutdown() Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
		executor.shutdown();
	}

}

class WorkerThread implements Runnable {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(Calendar.getInstance().getTime()+" - WorkerThread.run() - start - " + name);
		process();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Calendar.getInstance().getTime()+" - WorkerThread.run() - end - " + name);
	}

	private void process() {
		System.out.println(Calendar.getInstance().getTime()+" - WorkerThread.process() :: " + name);
	}

}
