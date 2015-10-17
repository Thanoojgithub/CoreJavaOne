package com.corejava.file.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

class Employee implements Serializable {

	private static final long serialVersionUID = 2133002684529690863L;

	private Integer eId;
	private String eName;
	private transient Integer age;

	public Employee(Integer i, String eName, Integer age) {
		super();
		this.eId = i;
		this.eName = eName;
		this.age = age;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", age=" + age + ", hashCode()=" + hashCode() + "]";
	}

}

public class FOSFIS {

	public static void main(String[] args) {
		fOS();
		System.out.println("FOSFIS.fIO() : " + fIO());
		fOSNext();
		System.out.println("FOSFIS.fIO() : " + fIO());
	}

	public static void fOS() {
		Vector<Employee> list = new Vector<Employee>();
		list.add(new Employee(1, "sriram", 30));
		list.add(new Employee(2, "seetha", 25));
		try (FileOutputStream fOS = new FileOutputStream(new File("listOfString.txt"));
				ObjectOutputStream oOS = new ObjectOutputStream(fOS)) {
			oOS.writeObject(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void fOSNext() {
		Vector<Employee> list = new Vector<Employee>();
		list.add(new Employee(1, "raghuram", 30));
		list.add(new Employee(2, "seetha", 25));
		try (FileOutputStream fOS = new FileOutputStream("listOfString.txt");
				ObjectOutputStream oOS = new ObjectOutputStream(fOS)) {
			oOS.writeObject(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Note : java.io.StreamCorruptedException: invalid stream header. If we try
	 * to tamper(hard modify) content in file, then try to read, it will throw
	 * an IO Exception.
	 */
	public static Vector<?> fIO() {
		Vector<?> list = null;
		try (FileInputStream fis = new FileInputStream("listOfString.txt");
				ObjectInputStream oIS = new ObjectInputStream(fis)) {
			list = (Vector<?>) oIS.readObject();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
}
