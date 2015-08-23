package com.corejava.string;

public class StringLiteral {

	public static void main(String[] args) {

		String str1 = "hello6";
		String str2 = "hello" + 6;
		String str3 = "hello" + "" + 6;
		String str4 = "hello" + str1.length();
		String str5 = str1;
		String str6 = "6";
		String str7 = "hello" + str6;
		String str8 = "hello" + "6";

		System.out.println(str1 == str2);// true
		System.out.println(str1 == str3);// true
		System.out.println(str1 == str4);// false
		System.out.println(str1 == str5);// true
		System.out.println(str1 == str6);// false
		System.out.println(str1 == str7);// false
		System.out.println(str1 == str8);// true
		
		System.out.println("---str.subSequence(1, 5)-------------str.substring(1, 5)--------str.substring(1)---------");
		String str = "sriram";
		CharSequence subSequence = str.subSequence(1, 5);
		System.out.println(subSequence);
		String substring = str.substring(1, 5);
		System.out.println(substring);
		substring = str.substring(1);
		System.out.println(substring);
	}

}
