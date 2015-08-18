package com.corejava.oop;

public class EncapsulationInheritanceAndAbstractionApp {

	public static void main(String[] args) {
		/**
		 * Abstraction :: we are hiding method implementation of getInstance() and toString() to outside Employee class.
		 */
		System.out.println(Employee.getInstance("001", "male", 1, "ram").toString());
	}
}

class Person {

	private String ssid;
	private String gender;

	public Person(String ssid, String gender) {
		super();
		this.ssid = ssid;
		this.gender = gender;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}

/**
 * Inheritance, Employee extends Person
 */
class Employee extends Person {

	// data hiding, by providing private access scope specifiers.
	private Integer eId;
	private String eName;

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

	/**
	 * exposing factory method instead of constructor
	 */
	public static Employee getInstance(String ssid, String gender, Integer eId, String eName) {
		return new Employee(ssid, gender, eId, eName);
	}

	private Employee(String ssid, String gender, Integer eId, String eName) {
		super(ssid, gender);
		this.eId = eId;
		this.eName = eName;
	}

	/**
	 * we are hiding method implementation of toString() to outside Employee class.
	 */
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", ssid=" + getSsid() + ", gender=" + getGender() + "]";
	}
}
