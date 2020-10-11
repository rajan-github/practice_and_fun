package java8Features.streams;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PipelineExample {
	public static void pipelineUsages() {
		Stream<String> stream = Stream.of("Toby", "Anna", "Leroy", "Alex");
		Set<String> set = stream.sorted().filter(x -> x.length() == 4).limit(2).collect(Collectors.toSet());
		System.out.println(set);
	}

	public static void main(String[] args) {
		pipelineUsages();
	}
}
