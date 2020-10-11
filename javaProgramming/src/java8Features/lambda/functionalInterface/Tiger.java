package java8Features.lambda.functionalInterface;

public interface Tiger extends Run {
	public default void haveFun() {
		System.out.println("can swim");
	}
}
