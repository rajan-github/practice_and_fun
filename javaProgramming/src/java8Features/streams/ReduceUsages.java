package java8Features.streams;

import java.util.Set;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReduceUsages {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("w", "o", "l", "f");
		String word = stream.reduce("", (a, b) -> a + b);
		System.out.println(word); // wolf

//		word = stream.reduce("", String::concat);
//		System.out.println(word);

		Stream<Integer> integerStream = Stream.of(3, 4, 5, 6, 7);
		int multiplication = integerStream.reduce(1, (a, b) -> a * b);
		System.out.println(multiplication); // 2520

		BinaryOperator<Integer> op = (a, b) -> a * b;
		Stream<Integer> empty = Stream.empty();
		Stream<Integer> oneElement = Stream.of(1);
		Stream<Integer> threeElements = Stream.of(1, 2, 3);

		empty.reduce(op).ifPresent(System.out::println);
		oneElement.reduce(op).ifPresent(System.out::println);
		threeElements.reduce(op).ifPresent(System.out::println);

//		BinaryOperator<Integer> op = (a, b) -> a * b;
//		stream = Stream.of(3, 5, 6);
//		System.out.println(stream.reduce(1, op, op));  //90

		stream = Stream.of("w", "o", "l", "f");
		StringBuilder word1 = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		System.out.println(word1); // wolf

		Stream<String> stream1 = Stream.of("w", "o", "l", "f");
		TreeSet<String> set = stream1.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
		System.out.println(set);

		Stream<String> stream3 = Stream.of("w", "o", "l", "f");
		TreeSet<String> treeSet = stream3.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(treeSet);

		stream3 = Stream.of("w", "o", "l", "f");
		Set<String> simpleSet = stream3.collect(Collectors.toSet());
		System.out.println(simpleSet);

	}
}
