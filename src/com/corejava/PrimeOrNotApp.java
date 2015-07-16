package com.corejava;

public class PrimeOrNotApp {

	public static void main(String[] args) {
		primeNumbersInaRange(1, 100);
		primeOrNot(131);
	}

	private static void primeNumbersInaRange(int min, int max) {
		for (int j = min; j <= max; j++) {
			boolean flag = true;
			for (int i = 2; i <= j / 2; i++) {
				if (j % i == 0) {
					flag = false;
					break;
				}
			}
			if (flag)
				System.out.println(j);
		}
	}

	private static void primeOrNot(int num) {
		boolean flag = true;
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				flag = false;
				break;
			}
		}
		if (flag){
			System.out.println(num+" is a prime number.");
		}else{
			System.out.println(num+" is NOT a prime number.");
		}
	}
}
