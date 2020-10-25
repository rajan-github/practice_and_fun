package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Food {
}

class Water {
}

public class Fox {
	public void eatAndDrink(Food food, Water water) {
		synchronized (food) {
			System.out.println("got food");
			move();
			synchronized (water) {
				System.out.println("got water");
			}
		}
	}

	public void drinkAndEat(Food food, Water water) {
		synchronized (water) {
			System.out.println("got water");
			move();
			synchronized (food) {
				System.out.println("got food");
			}
		}
	}

	private void move() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Fox foxy = new Fox();
		Fox tails = new Fox();
		ExecutorService service = null;
		service = Executors.newFixedThreadPool(10);
		Food food = new Food();
		Water water = new Water();
		try {
			service.submit(() -> foxy.eatAndDrink(food, water));
			service.submit(() -> tails.drinkAndEat(food, water));
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}
