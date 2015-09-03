package com.corejava.oop;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;

public class OverridingApp {

	public static void main(String[] args) {

		/* Type mismatch: cannot convert from OverridingParent to OverridingChild
		 * OverridingChild child = new OverridingParent();
		 */
		OverridingParent overridingParent = new OverridingChild();
		System.out.println(overridingParent.add(1, 2));
		
	}

}

class OverridingParent {
	
	protected Number add (Integer i1, Integer i2) throws ArithmeticException{
		System.out.println("OverridingParent.add(Integer i1, Integer i2) - parent");
		return BigInteger.valueOf(i1 + i2);
	}
	
	protected String add (String s1, String s2) throws IOException{
		System.out.println("OverridingParent.add(String i1, String i2) - parent");
		return s1 +" "+ s2;
	}
}

class OverridingChild extends OverridingParent{
	
	/*Runtime exceptions NO conditions
	 */
	@Override
	public BigInteger add (Integer i1, Integer i2) throws RuntimeException {
		System.out.println("OverridingParent.add(Integer i1, Integer i2) - child");
		return BigInteger.valueOf(i1 + i2);
	}
	
	/* sub class can have a method override without Checked or un-checked-exception
	 * when, superclass is NOT having checked-exception, but subclass trying to throws any type of Checked-Exception, then, it will throw ::
	 * when, superclass is having a checked-exception, but subclass trying to throws of SUPER type Checked-Exception, then, it will throw ::
	 * Exception is not compatible with throws clause in OverridingParent.add(String, String)
	 * return type in sub class Override method can have sub-class type of method return type of super class i.e., Integer extends Number ; here, override method can have Integer as return type of super class method which return Number. 
	 * 
	 * we can not narrow the access specifiers in sub class.
	 */
	@Override
	public String add (String s1, String s2)  throws FileNotFoundException{
		System.out.println("OverridingParent.add(String i1, String i2) - child");
		return s1 +" "+ s2;
	}
	
	
}