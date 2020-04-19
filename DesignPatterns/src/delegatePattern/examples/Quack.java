package delegatePattern.examples;

public class Quack implements QuackingBehaviour {

	@Override
	public void quack() {
		System.out.println("Quack!");
	}

}
