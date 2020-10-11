package java8Features.lambda;

import java.time.LocalDate;

public class Person {
	public enum Sex {
		MALE, FEMALE;
	}

	String name;
	LocalDate birthday;
	Sex gender;
	String emailAddress;

	public int getAge() {
		// compute age;
		return 0;
	}

	public void printPerson() {
		// print person.
	}
}
