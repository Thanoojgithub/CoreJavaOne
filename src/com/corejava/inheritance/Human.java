package com.corejava.inheritance;

import java.util.Map;

public interface Human {

	String COUNTRY = "INDIA";

	enum PhysicalParameters {
		HEIGHT("HEIGHT"), WEIGHT("HEIGHT"), COLOR("COLOR"), GENDER("GENDER");

		String value;

		PhysicalParameters(String value) {
			this.value = value;
		}

	}

	enum GENDER {
		MALE("MALE"), FEMALE("FEMALE");

		String value;

		GENDER(String value) {
			this.value = value;
		}
	}

	Map<String, String> getPhysicalParameters();

}
