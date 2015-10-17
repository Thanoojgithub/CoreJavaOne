package com.corejava.collections.legacyJDK1_0;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.BitSet;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Stack;
import java.util.Vector;

public class LegacyCollectionsJKD1_0 {

	public static void main(String[] args) {
		getDirectory();
		getVector();
		getStack();
		getProperties();
		getBitSet();
		getEnumeration();
	}

	private static void getDirectory() {
		/*
		 * Dictionary can be created using HashTable object, as Dictionary is an
		 * abstract class HashTable extends Dictionary and implements Map
		 * Note : Any non-null object can be used as a key and as a value.
		 */
		Dictionary<String, Integer> hashtable = new Hashtable<String, Integer>();
		hashtable.put("ca", 5000);
		hashtable.put("cai", 3000);
		hashtable.put("cgi", 4000);
		Enumeration<String> keys = hashtable.keys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			System.out.println("LegacyCollections.getDirectory() :: " + key + " : " + hashtable.get(key));
		}

	}

	private static void getVector() {
		/*
		 * Vector<E>, since 1.0 extends AbstractList<E> and 
		 * implements List(since 1.2) and RandomAccess (since 1.4)
		 * 
		 * Note : RandomAccess, is a marker interface used by List
		 * implementations to indicate that they support fast (generally
		 * constant time) random access. The primary purpose of this interface
		 * is to allow generic algorithms to alter their behavior to provide
		 * good performance when applied to either random or sequential access
		 * lists.
		 */
		List<String> vector = new Vector<String>();
		vector.add("cgi");
		vector.add("cai");
		vector.add("ca");
		for (String value : vector) {
			System.out.println("LegacyCollections.getVector() :: " + value);
		}

	}
	
	private static void getStack() {
		/*
		 * The Stack class represents a last-in-first-out (LIFO) stack of objects. 
		 * It extends class Vector with five operations that allow a vector to be treated as a stack.
		 * 1. push - adds element stack.
		 * 2. pop - gets TOP element and it will remove from the stack.
		 * 	  Note : both are LIFO
		 * 3. peek - it gets top value from stack.
		 * 4. empty - true if and only if this stack contains no items; false otherwise.
		 * 5. search - returns index(e.g. 3) of search element in stack, the return value -1 indicates that the object is not on the stack.
		 * 
		 */
		Stack<String> stack = new Stack<String>();
		System.out.println("LegacyCollections.getStack() :: " + stack.empty() + " | " + stack.isEmpty());
		stack.push("cai");
		stack.push("cgi");
		stack.push("ca");
		System.out.println("LegacyCollections.getStack() :: stack.search(\"cai\") :: " + stack.search("cai"));
		for (String vlaue : stack) {
			System.out.println("LegacyCollections.getStack() :: " + vlaue);
		}
		System.out.println(stack.peek() + " | " + stack.size() +" | "+ stack.pop()+ " | " + stack.size());
	}
	
	private static void getProperties() {
	    try {
		File file = new File("SampleProperties.properties");
	    file.createNewFile();
	    FileWriter fw = new FileWriter(file);
	    BufferedWriter bw = new BufferedWriter(fw);
	    for(int i = 1; i <= 5; i++){
	    	bw.write(i + "=" + i + "\n");
	    }
	    bw.close();
	    fw.close();
		FileReader reader = new FileReader(file);
		/*
		 * The Properties class represents a persistent set of properties. The Properties can be saved to a stream or loaded from a stream. 
		 * Note : Each key and its corresponding value in the property list is a string. 
		 */
		Properties p = new Properties();
		p.load(reader);
		for (Entry<Object, Object> entry : p.entrySet()) {
			System.out.println("LegacyCollections.getProperties() :: "+entry.getKey() + " | "+entry.getValue());
		} 
		p.setProperty("user","sriram");  
		p.store(new FileWriter("SamplePropertiesDumped.properties"),"*** SamplePropertiesDumped Properties ***");  
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void getBitSet() {
		BitSet bits1 = new BitSet(16);
		BitSet bits2 = new BitSet(16);
		// set some bits
		for (int i = 1; i <= 16; i++) {
			if ((i % 2) == 0)
				bits1.set(i);
			if ((i % 2) != 0)
				bits2.set(i);
		}
		bits1.set(3);
		bits2.set(4);
		System.out.println("bits1 :: " + bits1);
		System.out.println("bits2 :: " + bits2);
		// AND bits
		bits2.and(bits1);
		System.out.println("*** bits2 AND bits1 ***");
		System.out.println(bits2);
		// OR bits
		bits2.or(bits1);
		System.out.println("*** bits2 OR bits1 ***");
		System.out.println(bits2);
		bits1.or(bits2);
		System.out.println("*** bits1 OR bits2 ***");
		System.out.println(bits1);
		// XOR bits
		bits2.xor(bits1);
		System.out.println("*** bits2 XOR bits1 ***");
		System.out.println(bits2);
		bits1.xor(bits2);
		System.out.println("*** bits1 XOR bits2 ***");
		System.out.println(bits1);
	}

	private static void getEnumeration(){
		Vector<String> vector = new Vector<String>();
		vector.add("cgi");
		vector.add("cai");
		vector.add("ca");
		for (Enumeration<String> e = vector.elements(); e.hasMoreElements();)
			System.out.println("LegacyCollections.getEnumeration() :: "+ e.nextElement());
	}
}
