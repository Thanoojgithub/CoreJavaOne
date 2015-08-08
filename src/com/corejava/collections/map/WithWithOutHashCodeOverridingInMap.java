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
		Map<Emp, Emp> map = new LinkedHashMap<Emp, Emp>();

		Emp emp1 = new Emp(1, "ram");
		Emp emp2 = new Emp(2, "seeta");

		/*
		 * emp1.seteId(2); emp1.seteName("seeta");
		 */
		Emp emp1Prev = map.put(emp1, emp1);
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
		Emp emp1Prev2 = map.put(emp1, emp1);
		System.out.println(emp1Prev2 != null ? emp1Prev2.hashCode() : "NULL");
		Emp emp1Prev3 = map.put(emp1, emp1);
		System.out.println(emp1Prev3 != null ? emp1Prev3.hashCode() : "NULL");
		/*
		 * emp1.seteId(2); emp1.seteName("seeta");
		 */
		Emp emp2Prev = map.put(emp2, emp2);
		System.out.println(emp2Prev != null ? emp2Prev.hashCode() : "NULL");

		System.out.println(map.size());
		System.out.println(map.get(emp1).hashCode());
		for (Map.Entry<Emp, Emp> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " | " + entry.getValue() +" | "+entry.getKey().hashCode());
		}

	}

	private static void getEmpWithHashCodeAndEquals() {
		Map<EmpWithHashCodeAndEquals, EmpWithHashCodeAndEquals> map = new LinkedHashMap<>();

		EmpWithHashCodeAndEquals emp1 = new EmpWithHashCodeAndEquals(1, "ram");
		EmpWithHashCodeAndEquals emp2 = new EmpWithHashCodeAndEquals(2, "seeta");

		/*emp1.seteId(2);
		emp1.seteName("seeta");*/
		EmpWithHashCodeAndEquals emp1Prev = map.put(emp1, emp1);
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
		EmpWithHashCodeAndEquals emp1Prev2 = map.put(emp1, emp1);
		System.out.println(emp1Prev2 != null ? emp1Prev2.hashCode() : "NULL");
		EmpWithHashCodeAndEquals emp1Prev3 = map.put(emp1, emp1);
		System.out.println(emp1Prev3 != null ? emp1Prev3.hashCode() : "NULL");
		/*
		 * emp1.seteId(2); emp1.seteName("seeta");
		 */
		EmpWithHashCodeAndEquals emp2Prev = map.put(emp2, emp2);
		System.out.println(emp2Prev != null ? emp2Prev.hashCode() : "NULL");

		System.out.println(map.size());
		System.out.println(map.get(emp1));
		System.out.println(map.get(emp1).hashCode());

		for (Map.Entry<EmpWithHashCodeAndEquals, EmpWithHashCodeAndEquals> entry : map
				.entrySet()) {
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
1905823030
1905823030
NULL
2
1905823030
Emp [eId=2, eName=seeta] | Emp [eId=2, eName=seeta] | 1905823030
Emp [eId=2, eName=seeta] | Emp [eId=2, eName=seeta] | 1449070205
---------------------getEmpWithHashCodeAndEquals---------------
NULL
NULL
109315583
109315583
2
Emp [eId=2, eName=seeta]
109315583
Emp [eId=2, eName=seeta] | Emp [eId=2, eName=seeta] | 109315583
Emp [eId=2, eName=seeta] | Emp [eId=2, eName=seeta] | 109315583

*/