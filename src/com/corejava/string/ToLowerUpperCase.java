package com.corejava.string;

public class ToLowerUpperCase {

	public static void main(String[] args) {
		toLowerCase6590("AZ");
		lowerCaseWithAZ("AZ");
		toUpperCase("az");
		upperCaseWithAZ("az");

	}

	public static void toLowerCase6590(String a) {
		for (int i = 0; i < a.length(); i++) {
			char aChar = a.charAt(i);
			if (65 <= aChar && aChar <= 90) {
				aChar = (char) ((aChar + 32));
			}
			System.out.print(aChar);
		}
	}

	public static void toUpperCase(String a) {
		for (int i = 0; i < a.length(); i++) {
			char aChar = a.charAt(i);
			if (97 <= aChar && aChar <= 122) {
				aChar = (char) ((aChar - 32));
			}
			System.out.print(aChar);
		}
	}

	public static void lowerCaseWithAZ(String a) {
		for (char ch : a.toCharArray()) {
			if (ch >= 'A' && ch <= 'Z')
				ch += 'a' - 'A';
			System.out.print(ch);
		}
	}

	public static void upperCaseWithAZ(String a) {
		for (char ch : a.toCharArray()) {
			if (ch >= 'a' && ch <= 'z')
				ch += 'A' - 'a';
			System.out.print(ch);
		}
	}
}
