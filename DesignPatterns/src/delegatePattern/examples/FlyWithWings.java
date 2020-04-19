package delegatePattern.examples;

public class FlyWithWings implements FlyingBehaviour {

	@Override
	public void fly() {
		System.out.println("I am flying!");
	}

}
