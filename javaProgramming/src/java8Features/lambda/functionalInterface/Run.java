package java8Features.lambda.functionalInterface;

public interface Run {
	public default void haveFun() {
		System.out.println("Having fun");
	}
}
