package search;

/**
 * Find smallest and second smallest elements.
 * 
 * @author rajan-c
 *
 */
public class FindSmallest {
	public static int[] findSmallest(int[] array) {
		int[] smallest = new int[] { -1, -1 };
		if (array.length > 1) {
			int smallestIndex = array[0] <= array[1] ? 0 : 1, secondSmallest = 1 - smallestIndex;
			smallest[0] = array[smallestIndex];
			smallest[1] = array[1 - smallestIndex];
			for (int i = 2; i < array.length; i++) {
				if (array[i] < array[smallestIndex]) {
					secondSmallest = smallestIndex;
					smallestIndex = i;
				} else if (array[i] < array[secondSmallest])
					secondSmallest = i;
			}
			smallest[0] = smallestIndex;
			smallest[1] = secondSmallest;
		}
		return smallest;
	}

	public static void display(int[] array) {
		System.out.println(array[0] + ", " + array[1]);
	}

	public static void main(String[] args) {
		int[] smallest = findSmallest(new int[] { 1, 5, 3, 2, 6, 9, 10, 11, 100, -9 });
		display(smallest);

		smallest = findSmallest(new int[] { -1, -5, -3, -2, -6, -9, -10, -11, -100, -9 });
		display(smallest);
	}
}
