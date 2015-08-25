package com.corejava.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringLiteral {

	public static void main(String[] args) {

		String str1 = "hello6";
		String str6 = "6";
		String str2 = "hello" + str6;
		String str3 = "hello" + 6;
		String str4 = "hello" + "" + 6;
		String str5 = "hello" + str1.length();
		String str7 = str1;
		String str8 = "hello" + "6";

		System.out.println(str1 == str2);// false
		System.out.println(str1 == str3);// true
		System.out.println(str1 == str4);// true
		System.out.println(str1 == str5);// false
		System.out.println(str1 == str6);// false
		System.out.println(str1 == str7);// true
		System.out.println(str1 == str8);// true
		
		
		

		String str = "aaaabbbbbbccccccccpqrstv";
		// OUTPUT : a4b6c8pqrstv
		System.out.println(charWithCountAsAString(str));
	}

	private static String charWithCountAsAString(String str) {
		char[] ch = str.toCharArray();
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (char c : ch) {
			map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
		}
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Character, Integer> d : map.entrySet()) {
			if (d.getValue() > 1) {
				sb.append(d.getKey()).append(d.getValue());
			} else {
				sb.append(d.getKey());
			}
		}
		return sb.toString();
	}
}
