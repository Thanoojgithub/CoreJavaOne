package com.corejava.collections.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashTableApp {

	public static void main(String[] args) {
		doHashTable();
		doHashMap();
		doHashSet();
	}

	private static void doHashTable() {
		Map<EmpHashTableMap, String> hashtable = new Hashtable<>();
		EmpHashTableMap empHashTableMap = new EmpHashTableMap(1, "ram");
		/*
		 * java.lang.NullPointerException - Make sure the value is not null
		 * hashtable.put(null, null); java.lang.NullPointerException - while
		 * hashing the key hashtable.put(null, "sriram");
		 */
		hashtable.put(empHashTableMap, "ram");
		hashtable.put(empHashTableMap, "sriram");
		for (Map.Entry<EmpHashTableMap, String> entry : hashtable.entrySet()) {
			System.out.println(entry.getKey() + " | " + entry.getValue());
		}
	}

	private static void doHashMap() {
		Map<EmpHashTableMap, String> hashMap = new HashMap<>();
		EmpHashTableMap empHashTableMap = new EmpHashTableMap(1, "ram");
		hashMap.put(empHashTableMap, "ram");
		hashMap.put(empHashTableMap, "sriram");
		/*
		 * allow us to adding NULL key at any position, but, it will place NULL
		 * key at 0th position.
		 */
		hashMap.put(null, null);
		hashMap.put(null, "sriram");
		System.out.println("hashMap NULL key, value :: " + hashMap.get(null));
		for (Map.Entry<EmpHashTableMap, String> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey() + " | " + entry.getValue());
		}
	}

	private static void doHashSet() {
		Set<EmpHashTableMap> hashSet = new HashSet<>();
		EmpHashTableMap empHashTableMap = new EmpHashTableMap(1, "ram");
		hashSet.add(empHashTableMap);
		/*
		 * when we try to modify the key instance, No effect, in terms of key
		 * duplication, as hashing done at the time of put() call.
		 * 
		 * * empHashTableMap.seteName("sriram"); 
		 * 
		 * OUTPUT :: 
		 * EmpHashTableMap [eId=1, eName=sriram] 
		 * EmpHashTableMap [eId=1, eName=sriram]
		 */
		empHashTableMap.seteName("sriram"); 
		hashSet.add(empHashTableMap);
		/*
		 * allow us to adding NULL key at any position, but, it will place NULL
		 * key at 0th position.
		 */
		hashSet.add(null);
		/*
		 * Even though, Set is in contract with Collection (as in Collection
		 * Interface, no get() operation is declared), while retrieving, we need
		 * to use Iterate() only. where as in List(ArrayList, LinkedList), it
		 * has get(ofIndex).
		 */
		System.out.println("hashMap NULL key, value :: " + hashSet.contains(null));
		Iterator<EmpHashTableMap> iterator = hashSet.iterator();
		while (iterator.hasNext()) {
			EmpHashTableMap empHashTableMap2 = iterator.next();
			System.out.println(empHashTableMap2 +" || hashing : " + (empHashTableMap2 != null ?  empHashTableMap2.hashCode() : "NULL"));
		}
	}
}

class EmpHashTableMap {

	private Integer eId;
	private String eName;

	public EmpHashTableMap(Integer eId, String eName) {
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
		return "EmpHashTableMap [eId=" + eId + ", eName=" + eName + "]";
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
		EmpHashTableMap other = (EmpHashTableMap) obj;
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

}
