package com.corejava.file.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class FOSFIS {

	public static void main(String[] args) {
		fOS();
		System.out.println("FOSFIS.main() : " + fIO());
	}

	public static void fOS() {
		Vector<String> list = new Vector<String>();
		list.add("ram");
		list.add("sriram");
		list.add("raghuram");
		try (FileOutputStream fOS = new FileOutputStream(new File("listOfString.txt"));
				ObjectOutputStream oOS = new ObjectOutputStream(fOS)) {
			oOS.writeObject(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
