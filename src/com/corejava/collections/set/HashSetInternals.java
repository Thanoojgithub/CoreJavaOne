package com.corejava.collections.set;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

public class HashSetInternals {
	public static void main(String[] args) {
		//LikedHashSet, to retain insertion order
		//TreeSet, to retrieve sorting order (expects Cloneable implementation)
		Set<EmpTwo> hashSet = new LinkedHashSet<EmpTwo>();
		Date date = new Date();
		/**
		 * Adds the specified element to this set if it is not already present.
		 * If this set already contains the element, the call leaves the set unchanged and returns false.
		 */
		System.out.println("adding new elements :: " + hashSet.add(EmpTwo.getEmpInstance(1, "ram", date)));
		System.out.println("adding new elements :: " + hashSet.add(EmpTwo.getEmpInstance(2, "ram", date)));
		System.out.println("adding duplicate elements :: " + hashSet.add(EmpTwo.getEmpInstance(2, "ram", date)));
		System.out.println("adding duplicate elements :: " + hashSet.add(EmpTwo.getEmpInstance(1, "ram", date)));
		for (EmpTwo emp : hashSet) {
			System.out.println(emp);
		}
		System.out.println("done.");
	}

}

class EmpTwo {

	private int eId;
	private String name;
	private Date doj;

	public int geteId() {
		return eId;
	}

	public EmpTwo() {
	}

	public static EmpTwo getEmpInstance(int eId, String name, Date doj) {
		return new EmpTwo(eId, name, doj);
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public EmpTwo(int eId, String name, Date doj) {
		super();
		this.eId = eId;
		this.name = name;
		this.doj = doj;
	}

	@Override
	public String toString() {
		return "Emp [eId=" + eId + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doj == null) ? 0 : doj.hashCode());
		result = prime * result + eId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		EmpTwo other = (EmpTwo) obj;
		if (doj == null) {
			if (other.doj != null)
				return false;
		} else if (!doj.equals(other.doj))
			return false;
		if (eId != other.eId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}