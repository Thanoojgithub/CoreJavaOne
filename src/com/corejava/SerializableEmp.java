package com.corejava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableEmp implements Serializable {

	private static final long serialVersionUID = 6783423170203504095L;
	private String eId;
	private String eName;

	public SerializableEmp() {
		System.out.println("EMP default");
	}

	public SerializableEmp(String eId, String eName) {
		super();
		System.out.println("EMP cust");
		this.eId = eId;
		this.eName = eName;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

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
		FileInputStream fais = new FileInputStream("E:/Emp.ser");
		ObjectInputStream objectInputStream = new ObjectInputStream(fais);
		SerializableEmp emp2 = (SerializableEmp) objectInputStream
				.readObject();
		System.out.println(emp2);

		fais.close();
	}

	private static void getSerialized() throws IOException {
		SerializableEmp emp = new SerializableEmp("1", "ram");
		System.out.println(emp);
		FileOutputStream faos = new FileOutputStream("E:/Emp.ser");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(faos);
		objectOutputStream.writeObject(emp);
		faos.close();
		objectOutputStream.close();
	}

}