package com.corejava.ds;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arrayInts = new int[10];
		for (int i = 0; i < arrayInts.length; i++) {
			arrayInts[i] = (int) (Math.random() * 100);
		}
		sortWithTwoLoops(arrayInts);
		sortWithOneLoop(arrayInts);
	}

	private static void sortWithTwoLoops(int[] arrayInts) {
		System.out.println("sortWithTwoLoops starts");
		for (int j = 0; j <= arrayInts.length - 1; j++) {
			for (int i = 0; i <= arrayInts.length - 2; i++) {
				if (arrayInts[i] > arrayInts[i + 1]) {
					int temp = arrayInts[i];
					arrayInts[i] = arrayInts[i + 1];
					arrayInts[i + 1] = temp;
				}
			}
		}
		for (int i : arrayInts) {
			System.out.println(i);
		}
		System.out.println("sortWithTwoLoops ends");
	}

	private static void sortWithOneLoop(int[] arrayInts) {
		System.out.println("sortWithOneLoop starts");
		for (int i = 0; i < arrayInts.length - 1; i++) {
			if (arrayInts[i] > arrayInts[i + 1]) {
				int temp = arrayInts[i];
				arrayInts[i] = arrayInts[i + 1];
				arrayInts[i + 1] = temp;
				i = -1; // to make i =0; and let loop starts with arrayInts[0]
			}
		}
		for (int i : arrayInts) {
			System.out.println(i);
		}
		System.out.println("sortWithOneLoop ends");
	}

}
