package com.corejava.collections.map.concurent;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
			 */
			//maps.remove(iterator.next());
		}
		
		Map<String, String> concMaps = new ConcurrentHashMap<String, String>();
		concMaps.put("a", "a"); 
		concMaps.put("1", "1"); 
		concMaps.put("b", "b");
		concMaps.put("c", "c");
		for (Map.Entry<String, String> entry : concMaps.entrySet()) {
			System.out.println(entry.getKey() + " | "+entry.getValue());
		}
		for (Iterator<String> iterator2 = keySet.iterator(); iterator2.hasNext();) {
			String string = (String) iterator2.next();
			concMaps.remove(string); // here, NO Exception
			concMaps.put(string, string);
		} 
		
		for (Map.Entry<String, String> entry : concMaps.entrySet()) {
			System.out.println(entry.getKey() + " | "+entry.getValue());
		}
	
		 

	}


}
