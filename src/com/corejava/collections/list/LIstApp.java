package com.corejava.collections.list;

import java.util.ArrayList;
import java.util.List;

public class LIstApp {

	public static void main(String[] args) {
		List<String> listOne = new ArrayList<String>();
		listOne.add("one");
		for (String string : listOne) {
			System.out.println(string);
		}
		/**
		 * Type mismatch: cannot convert from ArrayList<String> to List<Object>
		 * 
		 * List<Object> listTwo = new ArrayList<String>(); listTwo.add("Two");
		 * for (String string : listTwo) { System.out.println(string); }
		 */

		/*
		 * Type mismatch: cannot convert from ArrayList<Object> to List<String>
		 * 
		 * List<String> listThree = new ArrayList<Object>();
		 * listThree.add("one"); for (String string : listThree) {
		 * System.out.println(string); }
		 */

	}

}
