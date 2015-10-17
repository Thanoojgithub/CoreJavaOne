package com.corejava.collections.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapInternals {

	public static void main(String[] args) {

		/**
		 * hashMap contains a table of indexed Entry(static inner class) - each Entry contains hash, key, value, next(pointer to next Entry)
		 * HashMap, calculate hash and it will also calculate index (like :: hash & (table.length - 1)), while put() and get() operations.
		 * Depends on the index, it will store/retrieve the specific entry<K,V>, if generated indexed array's position is not empty(!= null), then it will add a new Entry<K,V> at 'head'(LIFO) of that single LinkedList 
		 * Here, hash-code will be used to get specific index to where Entry<K,V> should be added.
		 * HashMap will not retain the insert order, but, internally they will retain iteration/retrieval order of its table index 
		 * 
		 */
		Map<String,String> map = new HashMap<>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		map.put("key4", "value4");
		map.put("key5", "value5");
		map.put("key6", "value6");
		map.put("key7", "value7");
		map.put("key8", "value8");
		map.put("key9", "value9");
		map.put("key10", "value10");
		map.put("key11", "value11");
		map.put("key12", "value12");
		//map.put("key15", "valueThree");
		map.put("AaBB", "AaBB");
		map.put("BBAa", "BBAa");
		map.put("BbAA", "BbAA");
		map.put("AABb", "AABb");
		System.out.println("OUT PUT ::");
		for (Map.Entry<String, String> enter : map.entrySet()) {
			// enter.setValue("temp"); - is valid
			System.out.println(enter.getKey() + " | " + enter.getValue());
		}

		Set<String> keySet = map.keySet();
		for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			/*
			 * iterator.remove(); - valid - prerequisite, before calling iterator.remove(), we need to call iterator.next()
			 * otherwise, it will throw java.lang.IllegalStateException
			 */
			System.out.println(key+" | "+map.get(key));
			/*
			 * map.remove(key), will throw java.util.ConcurrentModificationException
			 */
		}
	}

}
