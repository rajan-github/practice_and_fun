package java8Features.lambda;

import java.util.List;

public class OperationsOnPerson {
	public static void printPersonsOlderThan(List<Person> roster, int age) {
		// Print older than a specific age.
		for (Person p : roster) {
			if (p.getAge() >= age) {
				p.printPerson();
			}
		}
	}

	public static void printPersons(List<Person> roster, Checkperson tester) {
		for (Person p : roster)
			if (tester.test(p))
				p.printPerson();
	}
}

interface Checkperson {
	boolean test(Person p);
}
