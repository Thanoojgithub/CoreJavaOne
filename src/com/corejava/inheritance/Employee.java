package com.corejava.inheritance;

public abstract class Employee extends Person {

	enum JOB {
		ENGINEER("ENGINEER"), TEACHER("TEACHER"), FARMER("FARMER");
		String value;

		private JOB(String value) {
			this.value = value;
		}
	}

	abstract String getOccupation();

}
