package javaProgramming.strategy;

public class DragonSlayer {
	private DragonSlayingStrategy strategy;

	public DragonSlayer(DragonSlayingStrategy strategy) {
		this.strategy = strategy;
	}

	public void changeStrategy(DragonSlayingStrategy strategy) {
		this.strategy = strategy;
	}

	public void goToBattle() {
		strategy.execute();
	}

	public static void main(String[] args) {
		DragonSlayer slayer = new DragonSlayer(new MeleeStrategy());
		slayer.goToBattle();
		slayer.changeStrategy(new SpellStrategy());
		slayer.goToBattle();

		slayer.changeStrategy(new ProjectileStrategy());
		slayer.goToBattle();
	}
}
