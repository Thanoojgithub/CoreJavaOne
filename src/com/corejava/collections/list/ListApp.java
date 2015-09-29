package com.corejava.collections.list;

import java.util.ArrayList;
import java.util.List;

public class ListApp {

	public static void main(String[] args) {
		List<String> listOne = new ArrayList<String>();
		listOne.add("one");
		listOne.add("one");
		for (String string : listOne) {
			System.out.println(string);
		}
		
		/**
		 * 
		 * * Type mismatch: cannot convert from ArrayList<String> to List<Object>
		 * 
		 * List<Object> listTwo = new ArrayList<String>();
		 * listTwo.add("Two");
		 * 
		 * 
		 * * Type mismatch: cannot convert from ArrayList<Object> to List<String>
		 *  
		 *  List<String> listThree = new ArrayList<Object>();
		 *  listThree.add("one");
		 *  
		 */

		
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		List<Integer> l2 = new ArrayList<>();
		l2.add(1);
		System.out.println("l1.equals(l2) :: " +l1.equals(l2));
		
		
		List<EmpWithEqual> l3 = new ArrayList<>();
		l3.add(new EmpWithEqual(1,"ram"));
		List<EmpWithEqual> l4 = new ArrayList<>();
		l4.add(new EmpWithEqual(1,"ram"));
		System.out.println("l3.equals(l4) :: "+l3.equals(l4));

	}

}

class EmpWithEqual {
	
	private Integer eId;
	private String name;
	
	public EmpWithEqual(Integer eId, String name) {
		super();
		this.eId = eId;
		this.name = name;
	}

	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpWithEqual other = (EmpWithEqual) obj;
		if (eId == null) {
			if (other.eId != null)
				return false;
		} else if (!eId.equals(other.eId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
