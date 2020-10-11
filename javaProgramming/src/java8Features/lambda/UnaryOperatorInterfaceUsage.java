package java8Features.lambda;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorInterfaceUsage {
	public static void main(String[] args) {
		UnaryOperator<String> u1 = String::toUpperCase;
		UnaryOperator<String> u2 = (String str) -> str.toUpperCase();
		BinaryOperator<String> b1 = String::concat;
		BinaryOperator<String> b2 = (string, toAdd) -> string.concat(toAdd);
		System.out.println(u1.apply("kappa"));
		System.out.println(u2.apply("kappa"));
		System.out.println(b1.apply("kappa", "haggot"));
		System.out.println(b2.apply("kappa", "haggot"));
	}
}
