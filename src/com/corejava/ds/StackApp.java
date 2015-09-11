package com.corejava.ds;

import java.util.Stack;

public class StackApp {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(2);
		stack.push(5);
		stack.push(1);
		stack.push(4);

		System.out.println(stack);
		for (Integer integer : stack) {
			System.out.println(integer);
		}
		System.out.println("MAX :: " + getMax(stack));
	}

	public static Integer getMax(Stack<Integer> stack) {
		Integer pop = stack.pop();
		Stack<Integer> backupStack =new Stack<Integer>();
		backupStack.push(pop);
		while (!stack.isEmpty()) {
			Integer popTemp = stack.pop();
			backupStack.push(popTemp);
			pop = Math.max(pop, popTemp);
		}
		
		while (!backupStack.isEmpty()) {
			stack.push(backupStack.pop());
		}
		return pop;
	}

}
