package delegatePattern.examples;

public class FlyNoWay implements FlyingBehaviour {

	@Override
	public void fly() {
		System.out.println("I don't fly!");
	}

}
