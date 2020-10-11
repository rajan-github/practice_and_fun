package java8Features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUsage {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		Stream<Integer> streamOfInteger = list.stream();

//		Stream<Double> randomStream = Stream.generate(Math::random);
//		Stream<Integer> oddNumbers = Stream.iterate(0, i -> i + 1);

		Stream<String> animalStream = Stream.of("monkey", "ape", "kangaroo");
		System.out.println(animalStream.count());

		animalStream = Stream.of("monkey", "ape", "kangaroo");
		System.out.println(animalStream.min((String s1, String s2) -> s1.compareTo(s2)));

		Runtime currentRuntime = Runtime.getRuntime();
		System.out.println(currentRuntime.availableProcessors());
		System.out.println(currentRuntime.freeMemory());
		System.out.println(currentRuntime.totalMemory());
		currentRuntime.gc();
		animalStream = Stream.of("monkey", "ape", "kangaroo");
		System.out.println(animalStream.findAny());

		animalStream = Stream.of("monkey", "ape", "kangaroo");
		System.out.println(animalStream.findFirst());

		streamOfInteger = Stream.of(1, 2, 3, 4, 5, 6, 7);

		System.out.println(streamOfInteger.allMatch(t -> t > 0));
		streamOfInteger = Stream.of(1, 2, 3, 4, 5, 6, 7);
		System.out.println(streamOfInteger.anyMatch(t -> (t & 1) == 0));

		streamOfInteger = Stream.of(1, 2, 3, 4, 5, 6, 7);
		System.out.println(streamOfInteger.anyMatch(t -> t < 0));

		animalStream = Stream.of("Monkey", "cow", "dog", "zebra");

		animalStream.forEach(System.out::println);

		Stream<String> charStream = Stream.of("a", "b", "c", "d");
		System.out.println(charStream.reduce("", String::concat));

		Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7);

		System.out.println(integerStream.reduce(0, (x, y) -> x + y));

		Stream<String> wordStream = Stream.of("one", "two", "three", "four");

		TreeSet<String> set = wordStream.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);

		System.out.println(set);

		wordStream = Stream.of("one", "two", "three", "four");

		System.out.println(wordStream.filter(x -> x.startsWith("t")).collect(Collectors.toSet()));

		wordStream = Stream.of("duck", "duck", "goose");
		wordStream.distinct().forEach(System.out::print);

		wordStream = Stream.of("duck", "duck", "goose");
		System.out.println(wordStream.map(String::length).reduce(0, (x, y) -> x + y));

	}
}
