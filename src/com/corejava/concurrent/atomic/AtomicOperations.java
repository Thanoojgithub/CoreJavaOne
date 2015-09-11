package com.corejava.concurrent.atomic;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ConcurrentHashMap
 * 	The ConcurrentHashMap is very similar to the java.util.HashTable class, except that ConcurrentHashMap offers better concurrency than HashTable does. ConcurrentHashMap does not lock the Map while you are reading from it. Additionally, ConcurrentHashMap does not lock the entire Map when writing to it. It only locks the part of the Map that is being written to, internally.
 *	Another difference is that ConcurrentHashMap does not throw ConcurrentModificationException if the ConcurrentHashMap is changed while being iterated. The Iterator is not designed to be used by more than one thread though.
 *	The ConcurrentMap has a few extra atomic methods in addition to the methods it inherits from its super interface, java.util.Map.
 *
 *	CopyOnWriteArrayList
 *	Making a fresh copy of an array is too expensive an operation, in terms of both time and memory overhead, to consider for ordinary use; developers often resort to using a synchronized ArrayList instead. That's also a costly option, however, because every time you iterate across the contents of the collection, you have to synchronize all operations, including read and write, to ensure consistency.
 *	This puts the cost structure backward for scenarios where numerous readers are reading the ArrayList but few are modifying it.
 *	CopyOnWriteArrayList is the amazing little jewel that solves this problem. Its Javadoc defines CopyOnWriteArrayList as a "thread-safe variant of ArrayList in which all mutative operations (add, set, and so on) are implemented by making a fresh copy of the array."
 *	The collection internally copies its contents over to a new array upon any modification, so readers accessing the contents of the array incur no synchronization costs (because they're never operating on mutable data).
 *	Essentially, CopyOnWriteArrayList is ideal for the exact scenario where ArrayList fails us: read-often, write-rarely collections such as the Listeners for a JavaBean event.
 */
public class AtomicOperations {

	public static void main(String[] args) {
		atomicBoolean();
		atomicInteger();
	}

	private static void atomicInteger() {
		AtomicInteger atomicIntegerInit = new AtomicInteger();
		System.out.println(atomicIntegerInit.get());
		AtomicInteger atomicInteger = new AtomicInteger(123);
		System.out.println(atomicInteger.get());
		System.out.println(atomicInteger.decrementAndGet());
		System.out.println(atomicInteger.incrementAndGet());
		System.out.println(atomicInteger.getAndDecrement());
		System.out.println(atomicInteger.getAndIncrement());
		//Atomically adds the given value to the current value.
		System.out.println(atomicInteger.getAndAdd(1));
		//Atomically sets to the given value and returns the old value.
		System.out.println(atomicInteger.getAndSet(321));
		atomicInteger.set(123);
		//Atomically sets the value to the given updated value if the current value == the expected value. 
		System.out.println(atomicInteger.weakCompareAndSet(123, 321));
		System.out.println(atomicInteger.get());
	}

	private static void atomicBoolean() {
		AtomicBoolean atomicBooleanInit = new AtomicBoolean();
		System.out.println("get, by default, default constructor : "+atomicBooleanInit.get());
		AtomicBoolean atomicBoolean = new AtomicBoolean(true);
		System.out.println("get, setting true explicitly, while creation : "+ atomicBoolean.get());
		atomicBoolean.set(false);
		System.out.println("get, after set false : "+ atomicBoolean.get());
		System.out.println("getAndSet : "+ atomicBoolean.getAndSet(true));
		boolean expectedValue = true;
		boolean newValue = false;
		//Atomically sets the value to the given updated value if the current value == the expected value.
		System.out.println("compareAndSet : "+ atomicBoolean.compareAndSet(expectedValue, newValue));
	}

}
