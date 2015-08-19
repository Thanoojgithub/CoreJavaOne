package com.corejava.string;

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
	}

}
