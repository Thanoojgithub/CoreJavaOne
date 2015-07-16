package com;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConcurentApp {

	public static void main(String[] args) {

		/*
		 * Map<String, String> maps = new HashMap<String, String>(); //
		 * Map<String, String> maps = new ConcurrentHashMap<String, String>();
		 * 
		 * maps.put("a", "a"); maps.put("1", "d"); maps.put("def", "c");
		 * maps.put("b", "b");
		 * 
		 * 
		 * Set<String> keySet = maps.keySet();
		 * 
		 * Iterator<String> iterator = keySet.iterator();
		 * 
		 * while(iterator.hasNext()){ System.out.println(iterator.next());
		 * iterator.remove(); }
		 * 
		 * 
		 * // Iterator<String> iterator = keySet.iterator();
		 * 
		 * 
		 * for (Iterator iterator2 = keySet.iterator(); iterator2.hasNext();) {
		 * String string = (String) iterator2.next();
		 * System.out.println("string : "+ string); maps.remove(string);
		 * 
		 * } while (iterator.hasNext()) { //maps.remove(iterator.next());
		 * //iterator.remove(); maps.put("234d", "sdfsadq235423"); }
		 * System.out.println("size : "+ maps.size());
		 */

		Emp emp1 = new Emp(1, "ram", new Date());
		Emp emp2 = new Emp(2, "ram", new Date());
		Emp emp3 = new Emp(3, "ram", new Date());
		Dept dept1 = new Dept(10, "ayodya");
		Dept dept2 = new Dept(20, "ayodya");
		Dept dept3 = new Dept(30, "ayodya");
		HashMap<Emp, Dept> hashMap = new HashMap<>();
		hashMap.put(emp1, dept1);
		hashMap.put(emp2, dept2);
		hashMap.put(emp3, dept3);
		for (Map.Entry<Emp, Dept> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey().hashCode() + " | "
					+ entry.getKey() + " " + entry.getValue());
		}
		System.out.println("***********************CASE************************");
		System.out.println(emp1.hashCode() + " | " + emp1);
		System.out.println(hashMap.get(emp1));
		emp1.seteId(200);
		System.out.println(emp1.hashCode() + " | " + emp1);
		System.out.println(hashMap.get(emp1));
        
        List<Emp> listObj = new ArrayList<>();
        listObj.add(emp1);
        listObj.add(emp2);
       // listObj.add(dept1);
        
        List<Dept> listObjDept = new ArrayList<>();
        listObjDept.add(dept1);
        listObjDept.add(dept2);
        
        listOfWC(listObj);
        listOfWC(listObjDept);
        
	}

	private static void listOfWC(List<?> listWC) {
        for (Object object : listWC) {
			System.out.println(object);
		}
	}
	
}

class Emp {
	private Integer eId;
	private String eName;
	private Date doj;

	public Emp() {
	}

	public Emp(Integer eId, String eName, Date doj) {
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

	/*@Override
	public int hashCode() {
		System.out.println("calling hashCode() when we access hashMap.get() of "+this.eId);
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doj == null) ? 0 : doj.hashCode());
		result = prime * result + ((eId == null) ? 0 : eId.hashCode());
		result = prime * result + ((eName == null) ? 0 : eName.hashCode());
		return result;
	}*/

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
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
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
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

