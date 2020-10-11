package java8Features.lambda.functionalInterface;

public class RandomAnimal implements Lion, Tiger {
	@Override
	public void haveFun() {
		System.out.println("This is override of the havefun method.");
	}
}
