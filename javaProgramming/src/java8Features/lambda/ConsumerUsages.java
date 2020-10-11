package java8Features.lambda;

import java.util.function.Consumer;

public class ConsumerUsages {
	public static void main(String[] args) {
		Consumer<String> c1 = System.out::println;
		Consumer<String> c2 = x -> System.out.println(x);

		c1.accept("Annie");
		c2.accept("Annie");
	}
}
