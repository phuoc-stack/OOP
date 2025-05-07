package oop;

public class Student {
	String name;
	String gmail;
	String phone;
	
	// field
	Student() {
	}

	Student(String name, String gmail, String phone) {
		this.name = name;
		this.gmail = gmail;
		this.phone = phone;
	}

	public void showInfo() {
		System.out.printf("Student Name: %s\n", this.name);
		System.out.printf("Student Gmail: %s\n", this.gmail);
		System.out.printf("Student Phone: %s\n", this.phone);
		System.out.println();
	}
}
