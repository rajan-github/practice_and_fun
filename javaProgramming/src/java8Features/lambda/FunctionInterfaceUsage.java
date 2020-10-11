package java8Features.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionInterfaceUsage {
	public static void main(String[] args) {
		Function<String, Integer> f1 = String::length;
		Function<String, Integer> f2 = (String str) -> str.length();
		System.out.println(f1.apply("kappa"));
		System.out.println(f2.apply("kappa"));
		BiFunction<String, String, String> b1 = String::concat;
		BiFunction<String, String, String> b2 = (String str, String s) -> str.concat(s);
		System.out.println(b1.apply("kappa", "haggot"));
		System.out.println(b2.apply("perl", "harbor"));
	}
}
