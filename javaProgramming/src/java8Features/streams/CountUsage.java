package java8Features.streams;

import java.util.stream.Stream;

public class CountUsage {
	public static void main(String[] args) {
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		System.out.println(s.count());
	}
}
