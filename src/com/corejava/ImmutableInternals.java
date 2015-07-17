package com.corejava;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Why string hashCode has been cached, why not for a custom(user defined) immutable class object ?
 * Here is the sample code of tampering hashCode() logic inside ImmutableInternals.
 * 
 * @author Thanooj Kalathuru
 *
 */
public class ImmutableInternals {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();
		String s1 = "sriram";
		String s2 = "seeta";
		map.put(s1, "ayodhya");
		map.put(s2, "midhila");

		/**
		 * it will NOT do recalculated hashCode for second time, instead it will
		 * get hashCode from 'hash' inside hashCode()
		 */
		System.out.println(map.get(s1));

		Map<CustomerImm, String> mapImm = new HashMap<>();
		CustomerImm Imm1 = CustomerImm.createNewInstance(1, s1, Calendar.getInstance().getTime());
		CustomerImm Imm2 = CustomerImm.createNewInstance(2, s2, Calendar.getInstance().getTime());
		mapImm.put(Imm1, s1);
		mapImm.put(Imm2, s2);

		System.out.println(mapImm.get(Imm1));
	}

}

final class CustomerImm {

	/** Cache the hashCode for the ImmutableClass */
	private int hash; // Default to 0

	private final Integer cId;

	private final String cName;

	private final Date dOB;

	private CustomerImm(Integer cId, String cName, Date dOB, int hash) {
		this.cId = cId;
		this.cName = cName;
		this.dOB = new Date(dOB.getTime());
		this.hash = hash;
	}

	/**
	 * Factory method for creating new instance with prime properties and hash
	 * (for caching)
	 * 
	 * @param fld1
	 * @param fld2
	 * @param date
	 * @return ImmutableClass
	 */
	public static CustomerImm createNewInstance(Integer cId, String cName, Date dOB) {
		return new CustomerImm(cId, cName, dOB, 0);
	}

	public Integer getImmutableField1() {
		return cId;
	}

	public String getImmutableField2() {
		return cName;
	}

	public Date getMutableField() {
		return new Date(dOB.getTime());
	}

	@Override
	public String toString() {
		return cId + " - " + cName + " - " + dOB;
	}

	/**
	 * if only hash == 0, then do calculate hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int h = this.hash;
		if (h == 0) {
			System.out.println("Inside hashCode() method to calculate hashCode");
			int result = 1;
			result = prime* result
					+ ((cId == null) ? 0 : cId.hashCode());
			result = prime * result
					+ ((cName == null) ? 0 : cName.hashCode());
			result = prime * result
					+ ((dOB == null) ? 0 : dOB.hashCode());
			this.hash = result;
			h = this.hash;
		}
		System.out.println("Inside hashCode() :: " + h);
		return h;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerImm other = (CustomerImm) obj;
		if (cId == null) {
			if (other.cId != null)
				return false;
		} else if (!cId.equals(other.cId))
			return false;
		if (cName == null) {
			if (other.cName != null)
				return false;
		} else if (!cName.equals(other.cName))
			return false;
		if (dOB == null) {
			if (other.dOB != null)
				return false;
		} else if (!dOB.equals(other.dOB))
			return false;
		return true;
	}

}