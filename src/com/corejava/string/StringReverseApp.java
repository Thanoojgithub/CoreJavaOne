package com.corejava.string;

import java.util.Scanner;
import java.util.logging.Logger;

public class StringReverseApp {

	private static final Logger LOG = Logger.getLogger("StringReverseApp");

	public static void main(String[] args) {

		String original ="";
		try (Scanner in = new Scanner(System.in)) {
			System.out.print("Enter a string to reverse :: ");
			original = in.nextLine();
			int length = original.length();
			if (length > 0) {
				stringReverseUsingEmptyString(original, length);
				LOG.info("stringReverseUsingRecursiveMethod, Reverse of entered string is: " + stringReverseUsingRecursiveMethod(original));
			} else {
				LOG.info("Please provide valid string.");
			}
		}
	}

	private static void stringReverseUsingEmptyString(String original, int length) {
		String reverse = "";
		for (int i = length - 1; i >= 0; i--) {
			reverse = reverse + original.charAt(i);
		}
		LOG.info("Reverse of entered string is: " + reverse);
	}

	private static String stringReverseUsingRecursiveMethod(String original) {
		int length = original.length();
		if (length <= 0)
			return "";
			return original.charAt(original.length() - 1)
				+ stringReverseUsingRecursiveMethod(original.substring(0, original.length() - 1));
	}
}
