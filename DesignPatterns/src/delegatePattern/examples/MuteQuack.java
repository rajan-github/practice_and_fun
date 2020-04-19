package delegatePattern.examples;

public class MuteQuack implements QuackingBehaviour {

	@Override
	public void quack() {
		System.out.println("<<Silence!>>");
	}
}
