package com.corejava.reflection;

public class Sample {
	
	private String str;
	
	public void messageString(String msg) {
		System.out.println("messageString :: "+msg);
	}
	
	public void messageInteger(Integer i) {
		System.out.println("messageInteger :: "+ i);
	}
	
	public void messageInt(int i) {
		System.out.println("messageInt :: "+ i);
	}
	
	public void messageNoParam() {
		System.out.println("Sample.messageNoParam()");
	}
}
