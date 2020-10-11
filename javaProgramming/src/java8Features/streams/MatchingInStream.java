package java8Features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MatchingInStream {
	public static void main(String[] args) {
		List<String> stream = Arrays.asList("monkey", "2", "chimp");
		Stream<String> infinite = Stream.generate(() -> "chimp");
		Predicate<String> prod = x -> Character.isLetter(x.charAt(0));
		System.out.println(stream.stream().anyMatch(prod)); // true
		System.out.println(infinite.anyMatch(prod)); // true
		System.out.println(stream.stream().allMatch(prod)); // false

		stream.forEach(System.out::println);
	}
}
