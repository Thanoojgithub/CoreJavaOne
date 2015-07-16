package com.corejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class SortHashMapWithValues {

	public static void main(String[] args) {

		hashMapSortWithValuesUsingListAndComparator();
		hashMapSortWithValuesUsingSetAndComparable();
	}

	private static void hashMapSortWithValuesUsingListAndComparator() {
		Map<String, EmployeeOne> map = new LinkedHashMap<String, EmployeeOne>();
		map.put("1", new EmployeeOne(1, "ram"));
		map.put("2", new EmployeeOne(2, "seetha"));
		map.put("3", new EmployeeOne(3, "lakshman"));
		map.put("4", new EmployeeOne(4, "hanuma"));
		map.put("5", new EmployeeOne(5, "bharatha"));

		for (Map.Entry<String, EmployeeOne> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " | " + entry.getValue());
		}

		Set<Entry<String, EmployeeOne>> set = map.entrySet();
		List<Entry<String, EmployeeOne>> list = new ArrayList<Entry<String, EmployeeOne>>(
				set);
		Collections.sort(list,
				new Comparator<Map.Entry<String, EmployeeOne>>() {
					public int compare(Map.Entry<String, EmployeeOne> o1,
							Map.Entry<String, EmployeeOne> o2) {
						return o1.getValue().geteId() - o2.getValue().geteId();
					}
				});
		for (Map.Entry<String, EmployeeOne> entry : list) {
			System.out.println(entry.getKey() + " ==== " + entry.getValue());
		}

		Collections.sort(list,
				new Comparator<Map.Entry<String, EmployeeOne>>() {
					public int compare(Map.Entry<String, EmployeeOne> o1,
							Map.Entry<String, EmployeeOne> o2) {
						return o1.getValue().getName()
								.compareTo(o2.getValue().getName());
					}
				});
		for (Map.Entry<String, EmployeeOne> entry : list) {
			System.out.println(entry.getKey() + " ==== " + entry.getValue());
		}
	}

	private static void hashMapSortWithValuesUsingSetAndComparable() {
		Map<String, EmployeeOne> map = new LinkedHashMap<String, EmployeeOne>();
		map.put("1", new EmployeeOne(1, "ram"));
		map.put("2", new EmployeeOne(2, "seetha"));
		map.put("3", new EmployeeOne(3, "lakshman"));
		map.put("4", new EmployeeOne(4, "hanuma"));
		map.put("5", new EmployeeOne(5, "bharatha"));

		for (Map.Entry<String, EmployeeOne> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " | " + entry.getValue());
		}

		Set<Map.Entry<String, EmployeeOne>> treeSet = new TreeSet<Map.Entry<String, EmployeeOne>>();
		for (Map.Entry<String, EmployeeOne> entry : map.entrySet()) {
			treeSet.add(entry);
		}
		for (Map.Entry<String, EmployeeOne> entry : treeSet) {
			System.out.println(entry.getKey() + " ==== " + entry.getValue());
		}
	}
}

class EmployeeOne implements Comparable<EmployeeOne> {

	private final Integer eId;
	private final String name;

	public EmployeeOne(Integer eId, String name) {
		this.eId = eId;
		this.name = name;
	}

	public Integer geteId() {
		return eId;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(EmployeeOne o) {
		return this.getName().compareTo(o.getName());
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((eId == null) ? 0 : eId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		System.out.println("hashCode :: " + eId + " | " + result);
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
		EmployeeOne other = (EmployeeOne) obj;
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

	@Override
	public String toString() {
		return "EmployeeOne [eId=" + eId + ", name=" + name + "]";
	}

}
