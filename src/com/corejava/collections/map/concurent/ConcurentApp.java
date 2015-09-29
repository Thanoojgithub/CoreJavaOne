package com.corejava.collections.map.concurent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurentApp {

	public static void main(String[] args) {

		
		Map<String, String> maps = new HashMap<String, String>();
		maps.put("a", "a"); 
		maps.put("1", "1"); 
		maps.put("b", "b");
		maps.put("c", "c");
		
		
		Set<String> keySet = maps.keySet();
		Iterator<String> iterator = keySet.iterator();
		while(iterator.hasNext()){ 
			iterator.next();// this next() call is mandatory(before), when we try to call iterator.remove();
			iterator.remove(); 
			/*
			 * java.util.ConcurrentModificationException
			 * maps.remove(iterator.next());
			 */
		}
		
		
		
		Map<String, String> concMaps = new ConcurrentHashMap<String, String>();
		concMaps.put("BBBB", "BBBB");
		concMaps.put("AaBB", "AaBB");
		concMaps.put("BBAa", "BBAa");
		concMaps.put("keyOne", "valueOne");
		concMaps.put("keyTwo", "valueTwo");
		concMaps.put("keyThree", "valueThree");
		for (Map.Entry<String, String> entry : concMaps.entrySet()) {
			System.out.println(entry.getKey() + " | "+entry.getValue());
		}
		
		System.out.println("----------remove----and----add same------------");
		for (Iterator<String> iterator2 = concMaps.keySet().iterator(); iterator2.hasNext();) {
			String string = (String) iterator2.next();
			concMaps.remove(string);
			System.out.print("an entry, ");
			System.out.println("removed :: "+string);
			/*
			 *  here, NO Exception has thrown
			 *  concMaps.put(string, string);
			 */
		} 
		
		for (Map.Entry<String, String> entry : concMaps.entrySet()) {
			System.out.println(entry.getKey() + " | "+entry.getValue());
		}
	
		 

	}


}
