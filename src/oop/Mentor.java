package oop;

public class Mentor {
	String name;
	int yearOfExperience;

	Mentor() {}

	Mentor(String name, int yearOfExperience) {
		this.name = name;
		this.yearOfExperience = yearOfExperience;
	}

	public void showInfo() {
		System.out.printf("Mentor Name: %s\n", this.name);
		System.out.printf("Mentor's Year Of Experience: %d\n", this.yearOfExperience);
		System.out.println();
	}
}
