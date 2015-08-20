package com.corejava.collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class WithAndWithOutHashCodeOverridingInMap {

	public static void main(String[] args) {

		System.out.println("-------------EmpWithOutHashCodeAndEquals-----getEmpWithOutHashCodeAndEquals------------");
		getEmpWithOutHashCodeAndEquals();
		System.out.println("-------------EmpWithHashCodeAndEquals--------getEmpWithHashCodeAndEquals---------------");
		getEmpWithHashCodeAndEquals();
	}

	private static void getEmpWithOutHashCodeAndEquals() {
		Map<EmpWithOutHashCodeAndEquals, String> map = new LinkedHashMap<EmpWithOutHashCodeAndEquals, String>();

		EmpWithOutHashCodeAndEquals emp1 = new EmpWithOutHashCodeAndEquals(1, "ram");
		EmpWithOutHashCodeAndEquals emp2 = new EmpWithOutHashCodeAndEquals(2, "seeta");

		/*
		 * emp1.seteId(2); emp1.seteName("seeta");
		 */
		String emp1Prev = map.put(emp1, "ram");
		// returns previous value associated with key, or null
		System.out.println(emp1Prev != null ? emp1Prev.hashCode() : "NULL");
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
		System.out.println("emp1 :: " + map.get(emp1) + " | " + emp1.hashCode());
		System.out.println("emp2 :: " + map.get(emp2) + " | " + emp2.hashCode());

		for (Map.Entry<EmpWithOutHashCodeAndEquals, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " | " + entry.getValue() + " | " + entry.getKey().hashCode());
		}

	}

	private static void getEmpWithHashCodeAndEquals() {
		Map<EmpWithHashCodeAndEquals, String> map = new LinkedHashMap<EmpWithHashCodeAndEquals, String>();

		EmpWithHashCodeAndEquals emp1 = new EmpWithHashCodeAndEquals(1, "ram");
		EmpWithHashCodeAndEquals emp2 = new EmpWithHashCodeAndEquals(2, "seeta");

		/*
		 * emp1.seteId(2); emp1.seteName("seeta");
		 */
		String emp1Prev = map.put(emp1, "ram");
		// returns previous value associated with key, or null
		System.out.println(emp1Prev != null ? emp1Prev.hashCode() : "NULL");
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
		System.out.println("emp1 :: " + map.get(emp1) + " | " + emp1.hashCode());
		System.out.println("emp2 :: " + map.get(emp2) + " | " + emp2.hashCode());

		for (Map.Entry<EmpWithHashCodeAndEquals, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " | " + entry.getValue() + " | " + entry.getKey().hashCode());
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
		return "EmpWithHashCodeAndEquals [eId=" + eId + ", eName=" + eName + "]";
	}

}

class EmpWithOutHashCodeAndEquals {
	private Integer eId;
	private String eName;

	public EmpWithOutHashCodeAndEquals(Integer eId, String eName) {
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
		return "EmpWithOutHashCodeAndEquals [eId=" + eId + ", eName=" + eName + "]";
	}

}

// OUT PUT ::

/* put() and get() methods call will calculate the hashCode while adding and retrieving an element from Map, 
 * where as forEach(Map<K,V>) iterates all the elements
 */


/*
 * -------------EmpWithOutHashCodeAndEquals-----getEmpWithOutHashCodeAndEquals------------
NULL
112670
112670
NULL
2
emp1 :: ram | 2006041187
emp2 :: seeta | 40972009
EmpWithOutHashCodeAndEquals [eId=2, eName=seeta] | ram | 2006041187
EmpWithOutHashCodeAndEquals [eId=2, eName=seeta] | seeta | 40972009
-------------EmpWithHashCodeAndEquals--------getEmpWithHashCodeAndEquals---------------
NULL
NULL
112670
112670
2
emp1 :: seeta | 109315583
emp2 :: seeta | 109315583
EmpWithHashCodeAndEquals [eId=2, eName=seeta] | ram | 109315583
EmpWithHashCodeAndEquals [eId=2, eName=seeta] | seeta | 109315583
 */
 

