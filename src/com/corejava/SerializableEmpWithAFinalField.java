package com.corejava;

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


	public SerializableEmpWithAFinalField(String eId, String eName) {
		this.eId = eId;
		this.eName = eName;
		System.out.println("EMP cust");
	}

	public String geteName() {
		return eName;
	}

	/*public void seteName(String eName) {
		this.eName = eName;
	}*/

	public String geteId() {
		return eId;
	}

	@Override
	public String toString() {
		return "Emp [eId=" + eId + ", eName=" + eName + "]";
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
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
		SerializableEmpWithAFinalField emp = new SerializableEmpWithAFinalField("1", "ram");
		System.out.println(emp);
		FileOutputStream faos = new FileOutputStream("D:/Emp.ser");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(faos);
		objectOutputStream.writeObject(emp);
		faos.close();
		objectOutputStream.close();
	}

}