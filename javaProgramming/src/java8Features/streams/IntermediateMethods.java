package java8Features.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateMethods {
	public static void main(String[] args) {
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		s.filter(x -> x.startsWith("m")).forEach(System.out::println); // monkey

		s = Stream.of("duck", "duck", "goose");
		s.distinct().forEach(System.out::println);

		Stream<Integer> stream = Stream.iterate(1, x -> x + 1);
		stream.skip(5).limit(2).forEach(System.out::println);

		Stream<String> stream1 = Stream.of("kappa", "haggot", "marriot", "bashist");
		stream1.map(x -> x.length()).forEach(System.out::println);

		List<String> zero = Arrays.asList();
		List<String> one = Arrays.asList("bamboo");
		List<String> two = Arrays.asList("Mama gorilla", "baby gorilla");
		Stream<List<String>> animals = Stream.of(zero, one, two);
		animals.flatMap(l -> l.stream()).forEach(System.out::println);

		s = Stream.of("brown-", "bear-");
		s.sorted().forEach(System.out::println);

		s = Stream.of("brown bear-", "grizzly-");
		s.sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}
}
