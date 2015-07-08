package com.corejava;

/**
 * Implementation of Selection Sort Algorithm in Java
 * 
 * @author thanooj
 *
 *         1. A sub array of sorted elements which is empty at the beginning and
 *         keep on increasing with each item added to it. 2. An unsorted sub
 *         array of remaining elements. This is equal to the input size in the
 *         beginning and its size reduces to zero as we reach the end of
 *         algorithm. The basic idea is that in each iteration of this algorithm
 *         we pick an element (either largest or smallest, this depends on the
 *         sorting scenario) and appends it to the sorted element list, reducing
 *         the size of unsorted list by one.
 */
public class SelectionSortAlgorithm {

	public static void main(String[] args) {
		int[] arr = { 9, 5, 3, 6, 4, 8, 2, 0, 7, 1 };
		doSelectionSort(arr);
		printArray(arr);
	}

	// This method sorts the input array
	public static void doSelectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int index_min = i;
			// Search for the minimum element in unsorted array
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[index_min]) {
					index_min = j;
				}
			}
			// Swap minimum element with element at index i
			swapNumbers(arr, i, index_min);
		}
	}

	// Swap numbers in the given array
	private static void swapNumbers(int[] arr, int i, int index) {
		int smallerNumber = arr[index];
		arr[index] = arr[i];
		arr[i] = smallerNumber;
	}

	// prints array
	private static void printArray(int[] arr) {
		System.out.print("Sorted Array :: ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
