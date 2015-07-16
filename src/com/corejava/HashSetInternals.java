package com.hibernateonemanybidirectional.app;

import java.util.Date;
import java.util.HashSet;

public class HashSetInternals {
	public static void main(String[] args) {
		HashSet<Emp> hashSet = new HashSet<Emp>();
		Date date = new Date();
		hashSet.add(Emp.getEmpInstance(1,"ram",date));
		hashSet.add(Emp.getEmpInstance(2,"ram",date));
		hashSet.add(Emp.getEmpInstance(3,"ram",date));
		for (Emp emp : hashSet) {
			System.out.println(emp);
		}
		System.out.println("end");
	}

}

class Emp {

	private int eId;
	private String name;
	private Date doj;

	public int geteId() {
		return eId;
	}

	public Emp() {
	}

	public static Emp getEmpInstance(int eId, String name, Date doj) {
		return new Emp(eId, name, doj);
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

	public Emp(int eId, String name, Date doj) {
		super();
		this.eId = eId;
		this.name = name;
		this.doj = doj;
	}

	@Override
	public int hashCode() {
		/*final int prime = 31;
		int result = 1;
		result = prime * result + ((doj == null) ? 0 : doj.hashCode());
		result = prime * result + eId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;*/
		return 1;
	}

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
		if (eId != other.eId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Emp [eId=" + eId + ", name=" + name + "]";
	}

}