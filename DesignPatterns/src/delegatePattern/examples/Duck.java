package delegatePattern.examples;

public abstract class Duck {
	protected FlyingBehaviour flyBehaviour;
	protected QuackingBehaviour quackBehaviour;

	public void performQuack() {
		quackBehaviour.quack();
	}

	public void performFly() {
		flyBehaviour.fly();
	}

	public abstract void display();

	public void swim() {
		System.out.println("All ducks float, even decoys!");
	}

}
