package genericsAndCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToList {

	public static void toArray() {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 4; i++)
			list.add(i);
		Object[] object = list.toArray();
		System.out.print(object);
		Object[] object2 = new Object[list.size()];
		list.toArray(object2);
		for (Object item : object2)
			System.out.print(item + ", ");
	}

	public static void main(String[] args) {
		String[] sa = new String[] { "one", "two", "three", "four" };
		List<String> list = Arrays.asList(sa);
		System.out.println("List size: " + list.size());
		System.out.println("Array size: " + sa.length);
		list.set(3, "Kapa");// update the array too
		for (String item : sa)
			System.out.print(item + ", ");

		toArray();
	}
}
