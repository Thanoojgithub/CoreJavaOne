package com.corejava.inheritance;


public abstract class Person implements Human {
	
	enum CITY {
		BANGALORE("BANGALORE"), CHENNAI("CHENNAI");

		String value;

		private CITY(String value) {
			this.value = value;
		}
	}
	
	abstract String getLocation();
	
}
