package com.corejava;

public class BubbleSort {

	public static void main(String[] args) {
		sortWithTwoLoops();
		sortWithOneLoop();
	}

	private static void sortWithTwoLoops() {
		System.out.println("sortWithTwoLoops starts");
		int[] arrayInts = new int[10];
		for (int i = 0; i < arrayInts.length; i++) {
			arrayInts[i] = (int) (Math.random() * 100);
		}
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

	private static void sortWithOneLoop() {
		System.out.println("sortWithOneLoop starts");
		int[] arrayInts = new int[10];
		for (int i = 0; i < arrayInts.length - 1; i++) {
			arrayInts[i] = (int) (Math.random() * 100);
		}
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
