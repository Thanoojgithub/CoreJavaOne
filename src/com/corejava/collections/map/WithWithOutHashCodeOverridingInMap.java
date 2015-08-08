package com.corejava.collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class WithWithOutHashCodeOverridingInMap {

	public static void main(String[] args) {

		System.out.println("---------------------getEmpWithOutHashCodeAndEquals---------------");
		getEmpWithOutHashCodeAndEquals();
		System.out.println("---------------------getEmpWithHashCodeAndEquals---------------");
		getEmpWithHashCodeAndEquals();
	}

	private static void getEmpWithOutHashCodeAndEquals() {
		Map<Emp, String> map = new LinkedHashMap<Emp, String>();

		Emp emp1 = new Emp(1, "ram");
		Emp emp2 = new Emp(2, "seeta");

		/*
		 * emp1.seteId(2); emp1.seteName("seeta");
		 */
		String emp1Prev = map.put(emp1, "ram");
		System.out.println(emp1Prev != null ? emp1Prev.hashCode() : "NULL"); // returns
																				// previous
																				// value
																				// associated
																				// with
																				// key,
																				// or
																				// null
		/*
		 * emp1.seteId(2); emp1.seteName("seeta");
		 */
		emp1.seteId(2);
		emp1.seteName("seeta");
		String emp1Prev2 = map.put(emp1, "ram");
		System.out.println(emp1Prev2 != null ? emp1Prev2.hashCode() : "NULL");
		String emp1Prev3 = map.put(emp1, "ram");
		System.out.println(emp1Prev3 != null ? emp1Prev3.hashCode() : "NULL");
		/*
		 * emp1.seteId(2); emp1.seteName("seeta");
		 */
		String emp2Prev = map.put(emp2, "seeta");
		System.out.println(emp2Prev != null ? emp2Prev.hashCode() : "NULL");

		System.out.println(map.size());
		System.out.println(map.get(emp1) +" | "+ emp1.hashCode());
		System.out.println(map.get(emp2) +" | "+ emp2.hashCode());
		
		for (Map.Entry<Emp, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " | " + entry.getValue() +" | "+entry.getKey().hashCode());
		}

	}

	private static void getEmpWithHashCodeAndEquals() {
		Map<Emp, String> map = new LinkedHashMap<Emp, String>();

		Emp emp1 = new Emp(1, "ram");
		Emp emp2 = new Emp(2, "seeta");

		/*
		 * emp1.seteId(2); emp1.seteName("seeta");
		 */
		String emp1Prev = map.put(emp1, "ram");
		System.out.println(emp1Prev != null ? emp1Prev.hashCode() : "NULL"); // returns
																				// previous
																				// value
																				// associated
																				// with
																				// key,
																				// or
																				// null
		/*
		 * emp1.seteId(2); emp1.seteName("seeta");
		 */
		emp1.seteId(2);
		emp1.seteName("seeta");
		String emp1Prev2 = map.put(emp1, "ram");
		System.out.println(emp1Prev2 != null ? emp1Prev2.hashCode() : "NULL");
		String emp1Prev3 = map.put(emp1, "ram");
		System.out.println(emp1Prev3 != null ? emp1Prev3.hashCode() : "NULL");
		/*
		 * emp1.seteId(2); emp1.seteName("seeta");
		 */
		String emp2Prev = map.put(emp2, "seeta");
		System.out.println(emp2Prev != null ? emp2Prev.hashCode() : "NULL");

		System.out.println(map.size());
		System.out.println(map.get(emp1) +" | "+ emp1.hashCode());
		System.out.println(map.get(emp2) +" | "+ emp2.hashCode());
		
		for (Map.Entry<Emp, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " | " + entry.getValue() +" | "+entry.getKey().hashCode());
		}

	}

}

class EmpWithHashCodeAndEquals {
	private Integer eId;
	private String eName;

	public EmpWithHashCodeAndEquals(Integer eId, String eName) {
		super();
		this.eId = eId;
		this.eName = eName;
	}

	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eId == null) ? 0 : eId.hashCode());
		result = prime * result + ((eName == null) ? 0 : eName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpWithHashCodeAndEquals other = (EmpWithHashCodeAndEquals) obj;
		if (eId == null) {
			if (other.eId != null)
				return false;
		} else if (!eId.equals(other.eId))
			return false;
		if (eName == null) {
			if (other.eName != null)
				return false;
		} else if (!eName.equals(other.eName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Emp [eId=" + eId + ", eName=" + eName + "]";
	}

}

class Emp {
	private Integer eId;
	private String eName;

	public Emp(Integer eId, String eName) {
		super();
		this.eId = eId;
		this.eName = eName;
	}

	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	@Override
	public String toString() {
		return "Emp [eId=" + eId + ", eName=" + eName + "]";
	}

}

//OUT PUT ::
	

/*

---------------------getEmpWithOutHashCodeAndEquals---------------
NULL
112670
112670
NULL
2
ram | 2117796172
seeta | 1406297426
Emp [eId=2, eName=seeta] | ram | 2117796172
Emp [eId=2, eName=seeta] | seeta | 1406297426
---------------------getEmpWithHashCodeAndEquals---------------
NULL
112670
112670
NULL
2
ram | 1480882610
seeta | 2006041187
Emp [eId=2, eName=seeta] | ram | 1480882610
Emp [eId=2, eName=seeta] | seeta | 2006041187


*/