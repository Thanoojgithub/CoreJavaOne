package com.corejava.exception;

public class ExceptionCatchAndFinally {

	public static void main(String[] args) {
		System.out.println(getArithmatic());
		justReturnFromVoidMethod();
	}

	public static Integer getArithmatic(){
		Integer i = 0;
		try {
			System.out.println("getArithmatic - try");
			i = 1/0;
			Class.forName("SampleClassName");
		} /* Unreachable catch block for ArithmeticException. It is already handled by the catch block for Exception - checked-exception
		catch (Exception e) {
			e.printStackTrace();
		}*/catch (ArithmeticException ae) {
			System.out.println("getArithmatic - catch - ArithmeticException");
			//ae.printStackTrace();
			i = 1;
		}catch (Exception e) {
			System.out.println("getArithmatic - catch - Exception");
			//e.printStackTrace();
			//return i = 2;
			i = 2;
		}finally {
			System.out.println("getArithmatic - finally");
			/*
			 * finally block does not complete normally, we need to use @SuppressWarnings("finally")
			 * return  3;
			 */
			i = 3;
		}
		return i;
	}
	
	public static void justReturnFromVoidMethod(){
		try{
			System.out.println("inside - try");
			return;
			/* Unreachable code
			 * System.out.println("inside - try");
			 */
		}finally{
			System.out.println("inside - finally");
			}
	}
}
