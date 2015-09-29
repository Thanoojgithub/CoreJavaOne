package com.corejava.serializable;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ExternalizableEmp implements Externalizable {

	private static final long serialVersionUID = 6783423170203504095L;
	private String eId;
	private String eName;

	public ExternalizableEmp() {
		System.out.println("EMP default");
	}

	public ExternalizableEmp(String eId, String eName) {
		super();
		System.out.println("EMP cust");
		this.eId = eId;
		this.eName = eName;
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("readExternal");
		eId = (String) in.readObject();
		eName = (String) in.readObject();
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("writeExternal");
		out.writeObject(eId);
		out.writeObject(eName);
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

	public static void main(String[] args) {
		getSerialized();
		getDeSerialized();
	}

	private static void getDeSerialized() {
		try (FileInputStream fais = new FileInputStream("D:/Emp.ser");
				ObjectInputStream objectInputStream = new ObjectInputStream(fais)) {
			ExternalizableEmp emp2 = (ExternalizableEmp) objectInputStream.readObject();
			System.out.println(emp2);
		} catch(FileNotFoundException  e) {
			e.printStackTrace();
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void getSerialized() {
		ExternalizableEmp emp = new ExternalizableEmp("1", "ram");
		System.out.println(emp);
		try (FileOutputStream faos = new FileOutputStream("D:/Emp.ser");
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(faos)) {
			objectOutputStream.writeObject(emp);
		} catch(FileNotFoundException  e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
