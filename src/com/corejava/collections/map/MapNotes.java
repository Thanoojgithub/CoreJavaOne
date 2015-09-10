package com.corejava.collections.map;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapNotes {

	public static void main(String[] args) {

		EmpTwo emp1 = new EmpTwo(1, "ram", new Date());
		EmpTwo emp2 = new EmpTwo(2, "ram", new Date());
		EmpTwo emp3 = new EmpTwo(3, "ram", new Date());
		Dept dept1 = new Dept(10, "ayodya");
		Dept dept2 = new Dept(20, "ayodya");
		Dept dept3 = new Dept(30, "ayodya");
		HashMap<EmpTwo, Dept> hashMap = new HashMap<>();
		hashMap.put(emp1, dept1);
		hashMap.put(emp2, dept2);
		hashMap.put(emp3, dept3);
		for (Map.Entry<EmpTwo, Dept> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey().hashCode() + " | " + entry.getKey() + " " + entry.getValue());
		}

		/*
		 * To maintain Map in insertion order, use LinkedHashMap
		 */
		Map<String, String> linkedmaps = new LinkedHashMap<String, String>();
		linkedmaps.put("a", "a");
		linkedmaps.put("b", "b");
		linkedmaps.put("1", "1");
		linkedmaps.put("c", "c");
		for (Map.Entry<String, String> entry : linkedmaps.entrySet()) {
			System.out.println(entry.getKey().hashCode() + " | " + entry.getKey() + " " + entry.getValue());
		}

		System.out.println("***********************CASE************************");
		System.out.println(emp1.hashCode() + " | " + emp1);
		System.out.println(hashMap.get(emp1));
		emp1.seteId(200);
		System.out.println(emp1.hashCode() + " | " + emp1);
		System.out.println(hashMap.get(emp1));

		List<EmpTwo> listObj = new ArrayList<>();
		listObj.add(emp1);
		listObj.add(emp2);
		// listObj.add(dept1); // we can add any type of Object, when it has
		// List<Object>

		List<Dept> listObjDept = new ArrayList<>();
		listObjDept.add(dept1);
		listObjDept.add(dept2);

		listOfWC(listObj);
		listOfWC(listObjDept);

		List<String> listStr = new ArrayList<String>();
		listStr.add("ram");
		listStr.add("seeta");
		listOfStrWC(listStr);

	}

	/**
	 * List<?> will be used only for iteration, cannot edit/modified.
	 * 
	 * @param listWC
	 */
	private static void listOfWC(List<?> listWC) {
		for (Object object : listWC) {
			System.out.println(object);
		}
	}

	private static void listOfStrWC(List<?> listWC) {
		for (Object object : listWC) {
			System.out.println(object);
		}
	}

}

class EmpTwo {
	private Integer eId;
	private String eName;
	private Date doj;

	public EmpTwo() {
	}

	public EmpTwo(Integer eId, String eName, Date doj) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.doj = doj;
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

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	/*
	 * @Override public int hashCode() { System.out.println(
	 * "calling hashCode() when we access hashMap.get() of " +this.eId); final
	 * int prime = 31; int result = 1; result = prime * result + ((doj == null)
	 * ? 0 : doj.hashCode()); result = prime * result + ((eId == null) ? 0 :
	 * eId.hashCode()); result = prime * result + ((eName == null) ? 0 :
	 * eName.hashCode()); return result; }
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpTwo other = (EmpTwo) obj;
		if (doj == null) {
			if (other.doj != null)
				return false;
		} else if (!doj.equals(other.doj))
			return false;
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
		return "Emp [eId=" + eId + ", eName=" + eName + ", doj=" + doj + "]";
	}

}

class Dept {
	private Integer dId;
	private String location;

	public Dept() {
	}

	public Dept(Integer dId, String location) {
		super();
		this.dId = dId;
		this.location = location;
	}

	public Integer getdId() {
		return dId;
	}

	public void setdId(Integer dId) {
		this.dId = dId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dId == null) ? 0 : dId.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
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
		Dept other = (Dept) obj;
		if (dId == null) {
			if (other.dId != null)
				return false;
		} else if (!dId.equals(other.dId))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dept [dId=" + dId + ", location=" + location + "]";
	}

}
