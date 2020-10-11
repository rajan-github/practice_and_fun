package java8Features.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PipelineUsage {
	public static void withoutPipeline() {
		List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
		List<String> filtered = new ArrayList<>();
		for (String item : list)
			if (item.length() == 4)
				filtered.add(item);

		Collections.sort(filtered);
		Iterator<String> iterator = list.iterator();
		if (iterator.hasNext())
			System.out.println(iterator.next());

		if (iterator.hasNext())
			System.out.println(iterator.next());

	}

	public static void withPipeline() {
		List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
		list.stream().filter(x -> x.length() == 4).sorted().limit(2).forEach(System.out::println);
	}

	public static void main(String[] args) {
		withoutPipeline();
		withPipeline();
	}
}
