package delegatePattern.examples;

public class MallardDuck extends Duck {

	public MallardDuck() {
		super();
		flyBehaviour = new FlyWithWings();
		quackBehaviour = new Quack();
	}

	@Override
	public void display() {
		System.out.println("I am a real mallard duck!");
	}
}
