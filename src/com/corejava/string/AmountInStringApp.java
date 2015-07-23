package com.corejava.string;

import java.util.Scanner;

/**
 * converting amount to String e.g., "one thousand two hundred and thirty four"
 * @author Thanooj Kalathuru
 *
 */
public class AmountInStringApp {

	private static final String[] zero_nineteen = { "zero", "one", "two",
			"three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
			"seventeen", "eighteen", "nineteen" };

	private static final String[] tens = { "twenty", "thirty", "forty",
			"fifty", "sixty", "seventy", "eighty", "ninety" };

	private static final String[] ands = { "thousand", "million", "billion" };

	public static void main(String[] args) {
		Long amount = 0l;
		try (Scanner in = new Scanner(System.in)) {
			System.out.print("Enter Amount :: ");
			String amountStr = in.nextLine();
			amount = (amountStr != null && amountStr.length() > 0 ? Long.valueOf(amountStr) : 0l);
				if (amount < 0) {
					System.out.println(amount + ", amount canot be in negitive");
			}
		}
	}

	/*private static String convertAmountToString(int n) {

	}*/
}