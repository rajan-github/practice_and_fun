package practice;

public class Cow extends Animal {
	String name = "cow";

	@Override
	public void printName() {
		System.out.println(name);
	}

	public static void main(String[] args) {
		Animal animal = new Cow();
		animal.printName();
	}
}
