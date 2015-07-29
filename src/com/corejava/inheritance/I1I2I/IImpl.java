package com.corejava.inheritance.I1I2I;

/**
 * javap ::
 * (NOTE : run javap with out package)
 * 
 * public class IImpl implements I { 
 * public IImpl(); 
 * public java.lang.String m1(); 
 * public static void main(java.lang.String[]); 
 * public java.lang.String mI1();
 * }
 * 
 * interface I extends I1,I2 {
 * public abstract java.lang.String m1();
 * }
 * 
 **/

interface I1 {
	String m1();
	String mI1();
}

interface I2 {
	String m1();
	String mI1();
}

interface I extends I1, I2 {
	String m1();
}

public class IImpl implements I {

	@Override
	public String m1() {
		return "ram";
	}
	
	@Override
	public String mI1() {
		return "mI1";
	}

	/**
	 * OUTPUT ::
	 * ram 
	 * mI1 
	 * class com.corejava.inheritance.I1I2I.IImpl
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		I i = new IImpl();
		System.out.println(i.m1());
		System.out.println(i.mI1());
		System.out.println(i.getClass());
	}
}