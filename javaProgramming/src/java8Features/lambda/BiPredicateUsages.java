package java8Features.lambda;

import java.util.function.BiPredicate;

public class BiPredicateUsages {
	public static void main(String[] args) {
		BiPredicate<String, String> b1 = String::startsWith;
		BiPredicate<String, String> b2 = (String x, String y) -> x.startsWith(y);

		System.out.println(b1.test("chicken", "chick"));
		System.out.println(b2.test("chicken", "chick"));
	}
}
