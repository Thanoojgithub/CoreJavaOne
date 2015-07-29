package com.corejava.inheritance;

import java.util.HashMap;
import java.util.Map;

public class Ram extends Employee{

	@Override
	public Map<String, String> getPhysicalParameters() {
		Map<String, String> physicalParameters = new HashMap<String, String>();
		physicalParameters.put(PhysicalParameters.HEIGHT.value, "5F.7I");
		physicalParameters.put(PhysicalParameters.COLOR.value, "light brown");
		physicalParameters.put(PhysicalParameters.WEIGHT.value, "65KGs");
		physicalParameters.put(PhysicalParameters.GENDER.value,	GENDER.MALE.value);
		return physicalParameters;
	}

	@Override
	String getOccupation() {
		return JOB.ENGINEER.value;
	}

	@Override
	String getLocation() {
		return CITY.BANGALORE.value;
	}

}
