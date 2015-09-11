package com.corejava.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearchApp {

	
	public static void main(String[] args) {
		int[] arr = { 6, 8, 2, 4 };
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Enter a number in between [1, 10]:");
			int num = input.nextInt();
			int elementPosition = binarySearch(arr, num);
			if (elementPosition != -1) {
				System.out.println("element " + num + " is at position: " + elementPosition);
			} else {
				System.out.println("element " + num + " is is not present in the given array");
			}
			System.out.println(Arrays.binarySearch(arr, num));
		}

	}

	public static int binarySearch(int[] inputArr, int key) {
		Arrays.sort(inputArr);// 2 4 6 8
		int start = 0;
		int end = inputArr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (key == inputArr[mid]) {
				return mid;
			}
			if (key < inputArr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

}
