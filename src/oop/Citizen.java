package oop;

public class Citizen {

	// OOP 4 tinh chat - attributes
	// Encapsulation - Đóng Gói - Bundle Similar Items (Attribute + method)
	// protect data -> prevent other class access/change ??

	// Inheritance - Kế Thừa - Extends - Sub Class - Supper Class - Children -
	// Parent
	// multiple inheritance - NO - DIAMOND PROBLEM

	// Polymorphism - Tính Đa Hình - MANY FORMS - OVERRIDE

	// Abstraction

	public Citizen() {
		// TODO Auto-generated constructor stub
	}

	protected String name;
	public String dob;
	private double weight;
	protected String gender;
	String email;

	protected void cry(String noise) {
		// implementation
		System.out.println("citizen " + name + " crying " + noise);
	}

	protected void showName() {
		System.out.println("citizen name = " + name);
	}

}
