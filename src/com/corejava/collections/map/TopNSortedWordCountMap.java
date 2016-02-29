package com.corejava.collections.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class TopNSortedWordCountMap {

	public static void main(String[] args) {

		Map<String, Integer> strCountMap = new HashMap<>();
		insertStr(strCountMap, "lakshman");
		insertStr(strCountMap, "seeta");
		insertStr(strCountMap, "seeta");
		insertStr(strCountMap, "ram");
		insertStr(strCountMap, "sram");
		insertStr(strCountMap, "raghu");
		insertStr(strCountMap, "ram");
		insertStr(strCountMap, "raghu");
		insertStr(strCountMap, "raghu");
		insertStr(strCountMap, "sram");
		insertStr(strCountMap, "sram");
		insertStr(strCountMap, "sram");
		insertStr(strCountMap, "raghu");
		insertStr(strCountMap, "raghu");
		insertStr(strCountMap, "hanuma");
		/*SSystem.out.println("enter n value : ");
		canner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();*/
		int n = strCountMap.size();
		for(int i = 0 ; i<n; i++){
		SortedMap<Integer, Set<String>> topThreeEntries = (SortedMap<Integer, Set<String>>) getTopThreeEntries(
				strCountMap, i);
		if (topThreeEntries != null)
			System.out.println("top " + i + " values :: " + topThreeEntries);
		else {
			System.out.println("please provide valid n value");
		}
		}

	}

	public static void insertStr(Map<String, Integer> strCountMap, String str) {
		strCountMap.put(str, strCountMap.containsKey(str) ? strCountMap.get(str) + 1 : 1);
	}

	public static SortedMap<Integer, Set<String>> getTopThreeEntries(
			Map<String, Integer> strCountMap, int n) {
		SortedMap<Integer, Set<String>> strCountMap1 = new TreeMap<>(
				Collections.reverseOrder());
		for (Entry<String, Integer> entry : strCountMap.entrySet()) {
			if (strCountMap1.containsKey(entry.getValue())) {
				Set<String> set2 = strCountMap1.get(entry.getValue());
				set2.add(entry.getKey());
				strCountMap1.put(entry.getValue(), set2);
			} else {
				Set<String> setStr = new HashSet<String>(1);
				setStr.add(entry.getKey());
				strCountMap1.put(entry.getValue(), setStr);
			}
		}
		Integer toKey = null;
		int i = 0;
		if (n > 0 && n <= strCountMap1.size()) {
			for (Integer key : strCountMap1.keySet()) {
				if (n <= strCountMap1.size() && (i == n || n == 1)) {
					if (n == 1 && i == 0) {
						i++;
						continue;
					}
					toKey = key;
					break;
				} else {
					i++;
				}
			}
			if (n == strCountMap1.size())
				return strCountMap1;
			else {
				if (toKey != null)
					return strCountMap1.headMap(toKey);
				else
					return null;
			}
		} else {
			return null;
		}
	}

}



/**
OUTPUT:
-------
please provide valid n value
top 1 values :: {5=[raghu]}
top 2 values :: {5=[raghu], 4=[sram]}
top 3 values :: {5=[raghu], 4=[sram], 2=[seeta, ram]}
top 4 values :: {5=[raghu], 4=[sram], 2=[seeta, ram], 1=[lakshman, hanuma]}
please provide valid n value

*/
