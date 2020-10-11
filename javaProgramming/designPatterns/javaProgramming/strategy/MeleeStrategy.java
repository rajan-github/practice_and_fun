package javaProgramming.strategy;

public class MeleeStrategy implements DragonSlayingStrategy {

	@Override
	public void execute() {
		System.out.println("With your exalciur you cut the dragon's head!");
	}

}
