package genericsAndCollections;

import java.util.Arrays;
import java.util.Comparator;

public class SearchObjArray {
	public static void main(String[] args) {
		String[] sa = new String[] { "one", "two", "three", "four" };
		Arrays.sort(sa);
		System.out.println(Arrays.binarySearch(sa, "one"));

		Arrays.sort(sa, new ReSortCoparator());
		System.out.println(Arrays.binarySearch(sa, "two"));
	}
}

class ReSortCoparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}
}