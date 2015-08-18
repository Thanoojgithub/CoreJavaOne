package com.corejava.oop;

import java.math.BigInteger;

public class OverLoadingApp {

	public static void main(String[] args) {

		System.out.println(OverLoading.add("s1", "s2"));
		// first it will look for OverLoading.add(Float f1, Float f2), if not there it will look for alternative immediate supper class type,OverLoading.add(Object i1, Object i2);
		System.out.println(OverLoading.add(Float.valueOf(1.0f), Float.valueOf(2.0f)));
	}
}

class OverLoading {

	public static BigInteger add(Integer i1, Integer i2) {
		System.out.println("OverLoading.add(Integer i1, Integer i2)");
		return BigInteger.valueOf(i1 + i2);
	}

	public static String add(String i1, String i2) {
		System.out.println("OverLoading.add(String i1, String i2)");
		return i1 + " " + i2;
	}
	
	public static String add(String s1) {
		System.out.println("OverLoading.add(String s1)");
		
		return "hey! "+s1;
	}

	public static Integer add(Integer i1) {
		System.out.println("OverLoading.add(Integer i1)");
		return i1;
	}
	
	public static BigInteger add(BigInteger bi1) {
		System.out.println("OverLoading.add(BigInteger bi1)");
		return bi1;
	}
	
	public static Number add(Number n1) {
		System.out.println("OverLoading.add(Number n1)");
		return n1;
	}
	
	public static BigInteger add(Number n1, Number n2) {
		System.out.println("OverLoading.add(Number n1, Number n2)");
		return BigInteger.valueOf(n1.intValue() + n2.intValue() );
	}
	
	public static Object add(Object i1, Object i2) {
		System.out.println("OverLoading.add(Object i1, Object i2)");
		return i1 + " " + i2;
	}
	
	
	/*changing only return type, throw compilation exception :: 
	 * Duplicate method add(String, String) in type OverLoading
	 * 
	 * public static Number add(Number n1, Number n2) {
		System.out.println("OverLoading.add(Number n1, Number n2)");
		return n1;
	}*/
	
	/* changing only access specifier (scope) of the method, throw compilation exception :: 
	 * Duplicate method add(String, String) in type OverLoading
	 * 
	 * private Integer add(Integer i1) {
		return i1;
	}*/
	
	
	/* changing only return type, throw compilation exception :: 
	 * Duplicate method add(String, String) in type OverLoading
	 * 
	 * public static void add (String i1, String i2){ return i1+" "+i2; }
	 */
	
	/* changing only parameter variable names, throw compilation exception :: 
	 * Duplicate method add(String, String) in type OverLoading
	 * 
	 * public static String add(String s1, String s2) {
		return s1 + " " + s2;
	}*/
	
	
	/*
	 * Thrown when an exceptional arithmetic condition has occurred. For example, an integer "divide by zero"
	 */
	public static Integer divide(Integer i1, Integer i2) throws ArithmeticException{
		System.out.println("OverLoading.divide(Integer i1, Integer i2)");
		return i1/i2;
	}
	
	/* changing only at throws any Runtime Exception type, will also throw compilation exception :: 
	 * Duplicate method add(String, String) in type OverLoading
	 * 
	 * public static Integer divide(Integer i1, Integer i2) throws RuntimeException{
		return i1/i2;
	}*/
	
	
	/* changing only at throws, by removing throws, will also throw compilation exception :: 
	 * Duplicate method add(String, String) in type OverLoading
	 * 
	 * public static Integer divide(Integer i1, Integer i2) {
		return i1/i2;
	}*/
	
	
	
	
	
	
}
