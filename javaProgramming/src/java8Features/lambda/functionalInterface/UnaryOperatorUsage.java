package java8Features.lambda.functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class UnaryOperatorUsage {
	public static void main(String[] args) {
		UnaryOperator<String> u1 = String::toUpperCase;
		UnaryOperator<String> u2 = String::toLowerCase;
		System.out.println(u1.apply("Kappa"));
		System.out.println(u2.apply("Kappa"));

		UnaryOperator<Integer> u3 = x -> x + 1;
		System.out.println(u3.apply(3));

		BinaryOperator<String> b1 = String::concat;
		System.out.println(b1.apply("kappa", "haggot"));

		Supplier<String> s1 = () -> "rajan";
		System.out.println(s1.get());

		List<String> list1 = new ArrayList<>();
		Consumer<String> c1 = list1::add;
		c1.accept("rajan");
		c1.accept("Chauhan");
		System.out.println(list1);
		optionalUsage();
	}

	public static void optionalUsage() {
		Optional<Integer> optional = Optional.of(95);
		System.out.println(optional.isPresent());
		System.out.println(optional.orElse(89));
		Optional<Double> optional2 = average();
		if (optional2.isPresent())
			System.out.println(optional2.get());
		else
			System.out.println(optional2.orElse(100.0));
	}

	public static Optional<Double> average(int... scores) {
		if (scores.length == 0)
			return Optional.empty();
		int sum = 0;
		for (int score : scores)
			sum += score;
		return Optional.of(sum * 1.0 / scores.length);
	}
}
