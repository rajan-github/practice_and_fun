package java8Features.streams;

import java.util.Optional;
import java.util.stream.Stream;

public class MinMax {
	public static void main(String[] args) {
		Stream<String> s = Stream.of("monkes", "ape", "bonobo");
		Optional<String> min = s.min((m, n) -> m.compareTo(n));
		System.out.println(min.orElse("Not found!"));
	}
}
