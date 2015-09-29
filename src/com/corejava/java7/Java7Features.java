package com.corejava.java7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Java7Features {

	public static void main(String[] args) {
		switchCase();
		typeInference();
		autoClosableImplements();
		

	}

	
	private static void autoClosableImplements() {
		
		/**
		 * BufferedInputStream
		BufferedOutputStream
		BufferedReader
		BufferedWriter
		ByteArrayInputStream
		ByteArrayOutputStream
		FileInputStream
		FileOutputStream
		FileReader
		FileWriter
		InputStreamReader
		Scanner
		StringBufferInputStream
		StringReader
		StringWriter
		 */
		try (FileInputStream fin = new FileInputStream("Notes.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(fin));) {
			if (br.ready()) {
				String line = br.readLine();
				System.out.println(line);
			}
		} catch ( IOException | NullPointerException e) {
	        e.printStackTrace();
	    }

		try (FileReader text = new FileReader("Notes.txt"); Scanner scnr = new Scanner(text)) {
			while (scnr.hasNextLine()) {
				String line = scnr.nextLine();
				System.out.println("line : " + line);
			}
		}catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	private static void typeInference() {
		Map<String, String> employeeRecords = new HashMap<>();
		employeeRecords.put("ram", "ayodhya");
		for (Entry<String, String> entry : employeeRecords.entrySet()) {
			System.out.println(entry.getKey() + " | " + entry.getValue());
		}
		System.out.println(employeeRecords.isEmpty());
		employeeRecords.clear();
		System.out.println(employeeRecords.isEmpty());
	}

	private static void switchCase() {
		
		String state = "CANCELED";
		/**
		 * switch case 'String' is a case-sensitive i.e., "CANCELED" and "canceled" both are different.
		 */
		switch (state) {
		case "NEW":
			System.out.println("Order is in NEW state");
			break;
		case "canceled":
			System.out.println("Order is Cancelled");
			break;
		case "REPLACE":
			System.out.println("Order is replaced successfully");
			break;
		case "FILLED":
			System.out.println("Order is filled");
			break;
		default:
			System.out.println("Invalid case, Please provide valid case, note, case string is a case-sensitive.");
		}
	}

}

/*
 * OUT PUT ::
 * 
 * Invalid case, Please provide valid case, note, case string is a
 * case-sensitive.
 */
