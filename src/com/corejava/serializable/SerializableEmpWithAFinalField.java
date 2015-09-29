package com.corejava.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableEmpWithAFinalField implements Serializable {

	private static final long serialVersionUID = 6783423170203504095L;
	private static String eId;
	private final String eName;
	private String loc;
	
	/* 1. Serializable && Deserializable is not expecting default constructor, if it use default/parameterized constructor, trying to tamper the original data
	 * 2. The blank final field eName may not have been initialized
	 */
	/*public SerializableEmpWithAFinalField() {
		System.out.println("inside SerializableEmpWithAFinalField()");
	}*/

	public SerializableEmpWithAFinalField(String eId, String eName, String loc) {
		this.eId = eId;
		this.eName = eName;
		this.loc = loc;
		System.out
				.println("EMP - inside SerializableEmpWithAFinalField(String eId, String eName, String loc)");
	}

	public static String geteId() {
		return eId;
	}

	public static void seteId(String eId) {
		SerializableEmpWithAFinalField.eId = eId;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String geteName() {
		return eName;
	}
	
	@Override
	public String toString() {
		return "SerializableEmpWithAFinalField [eName=" + eName + ", loc="
				+ loc + "]";
	}

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		getSerialized();
		getDeSerialized();
	}

	private static void getDeSerialized() throws IOException,
			ClassNotFoundException {
		FileInputStream fais = new FileInputStream(new File("D:/Emp.ser"));
		ObjectInputStream objectInputStream = new ObjectInputStream(fais);
		SerializableEmpWithAFinalField emp2 = (SerializableEmpWithAFinalField) objectInputStream.readObject();
		System.out.println(emp2);
		fais.close();
	}

	private static void getSerialized() throws IOException {
		SerializableEmpWithAFinalField emp = new SerializableEmpWithAFinalField("1", "sriram", "ayodya");
		System.out.println(emp);
		FileOutputStream faos = new FileOutputStream("D:/Emp.ser");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(faos);
		objectOutputStream.writeObject(emp);
		faos.close();
		objectOutputStream.close();
	}

}