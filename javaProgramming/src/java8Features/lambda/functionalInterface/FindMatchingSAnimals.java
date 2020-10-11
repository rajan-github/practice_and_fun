package java8Features.lambda.functionalInterface;

import java.util.function.Predicate;

public class FindMatchingSAnimals {
	private static void print(Animal animal, Predicate<Animal> trait) {
		if (trait.test(animal))
			System.out.println(animal);
	}

	public static void main(String[] args) {
		print(new Animal("Fish", false, true), a -> a.canHop());
		print(new Animal("Kangaroo", true, false), a -> a.canHop());
	}
}
