package com.corejava.string;

public class ToLowerUpperCase {

	public static void main(String[] args) {
		get659097122();
		upperCasetoLowerCase6590("AZ");
		lowerCasetoUpperCase97122("az");
		upperCaseToLowerCaseWithAZ("AZ");
		lowerCaseToUpperCaseWithAZ("az");
		stringEqualsIgnoreCaseAnotherString("sriram", "SRIRAM");
	}

	/**
	 * ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz
	 */
	public static void get659097122() {
		for (int i = 65; i <= 122; i++) {
			if (i <= 90 || (i >= 97 && i <= 122))
				System.out.print((char) (i));
		}
	}

	public static void upperCasetoLowerCase6590(String a) {
		for (int i = 0; i < a.length(); i++) {
			char aChar = a.charAt(i);
			if (65 <= aChar && aChar <= 90) {
				aChar = (char) ((aChar + 32));
			}
			System.out.println(aChar);
		}
	}

	public static void lowerCasetoUpperCase97122(String a) {
		for (int i = 0; i < a.length(); i++) {
			char aChar = a.charAt(i);
			if (97 <= aChar && aChar <= 122) {
				aChar = (char) ((aChar - 32));
			}
			System.out.println(aChar);
		}
	}

	public static void upperCaseToLowerCaseWithAZ(String a) {
		for (char ch : a.toCharArray()) {
			if (ch >= 'A' && ch <= 'Z')
				ch += 'a' - 'A';
			System.out.println(ch);
		}
	}

	public static void lowerCaseToUpperCaseWithAZ(String a) {
		for (char ch : a.toCharArray()) {
			if (ch >= 'a' && ch <= 'z')
				ch += 'A' - 'a';
			System.out.println(ch);
		}
	}

	public static void stringEqualsIgnoreCaseAnotherString(String lStr, String uStr) {
		boolean flag = false;
		if (lStr.length() == uStr.length()) {
			for (int i = 0; i < lStr.length(); i++) {
				if ((Integer.valueOf(lStr.charAt(i) - 32)) == Integer.valueOf(uStr.charAt(i))) {
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
		}
		if (flag) {
			System.out.println("equal");
		} else {
			System.out.println("NOT equal");
		}
	}
}
