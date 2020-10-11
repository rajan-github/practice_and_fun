package java8Features.streams;

import java.util.stream.Stream;

public class FindInStream {
	public static void main(String[] args) {
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		Stream<String> infinite = Stream.generate(() -> "chimp");
		s.findAny().ifPresent(System.out::println);
		infinite.findAny().ifPresent(System.out::println);
	}
}
