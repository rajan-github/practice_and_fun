package genericsAndCollections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Dog {
	public String name;

	public Dog(String name) {
		this.name = name;
	}
}

public class IteratorExample {
	public static void main(String[] args) {
		List<Dog> dogList = new ArrayList<>();
		dogList.add(new Dog("clover"));
		dogList.add(new Dog("magnolia"));
		Iterator<Dog> iterator = dogList.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next().name);
	}
}
