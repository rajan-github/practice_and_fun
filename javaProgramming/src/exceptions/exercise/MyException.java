package exceptions.exercise;

public class MyException {
	public static void main(String[] args) throws BadFoodException {
		new MyException().checkFood(args[0]);
	}

	public void checkFood(String food) throws BadFoodException {
		if (food.equals("Burger"))
			throw new BadFoodException("Burger is bad food for health!");
		else if (food.equals("Rice")) {
			System.out.println("Its a decent food!");
		}
	}
}
