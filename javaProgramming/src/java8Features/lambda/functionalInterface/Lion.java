package java8Features.lambda.functionalInterface;

public interface Lion {
	public default void canClimb() {
		System.out.println("Cannot climb.");
	}
}
