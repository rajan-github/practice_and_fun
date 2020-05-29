package genericsAndCollections;

abstract class Animal {
	public abstract void checkup();
}

class Cat extends Animal {
	@Override
	public void checkup() {
		System.out.println("Dog checkup");
	}
}

class Bird extends Animal {
	@Override
	public void checkup() {
		System.out.println("Dog checkup");
	}
}

public class AnimalDoctor {
	public void checkAnimal(Animal a) {
		a.checkup();
	}

	public void checkAnimals(Animal[] animals) {
		for (Animal animal : animals)
			animal.checkup();
	}
}
