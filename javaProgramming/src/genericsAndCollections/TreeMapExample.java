package genericsAndCollections;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeMapExample {
	public static void main(String[] args) {
		Set<Integer> treeset = new TreeSet<>();
		treeset.add(5);
		treeset.add(4);
		treeset.add(3);
		treeset.add(2);
		treeset.add(1);

		Iterator<Integer> iterator = treeset.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());

		Set<Integer> linkedset = new LinkedHashSet<>();
		linkedset.add(5);
		linkedset.add(4);
		linkedset.add(3);
		linkedset.add(2);
		linkedset.add(1);

		iterator = linkedset.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());
	}
}
