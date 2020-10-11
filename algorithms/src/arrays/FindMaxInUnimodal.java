package arrays;

public class FindMaxInUnimodal {
	public static int findMax(int[] array) {
		if (array == null || array.length == 0)
			return -1;
		return findMax(array, 0, array.length - 1);
	}

	private static int findMax(int[] array, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			if ((middle == array.length - 1 && array[middle - 1] <= array[middle])
					|| (middle == 0 && array[middle] >= array[middle + 1])
					|| (middle > 0 && array[middle - 1] <= array[middle] && array[middle + 1] <= array[middle]))
				return middle;
			else if (((middle > 0 && array[middle] >= array[middle - 1]) || middle == 0)
					&& array[middle] <= array[middle + 1])
				return findMax(array, middle + 1, end);
			return findMax(array, start, middle - 1);
		}
		return start;
	}

	public static void main(String[] args) {
		System.out.println(findMax(new int[] { 1, 2, 3, 1 }));
		System.out.println(findMax(new int[] { 1, 2, 3, 4 }));
		System.out.println(findMax(new int[] { 5, 4, 3, 2, 1 }));
		System.out.println(findMax(new int[] { 1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1 }));
		System.out.println(findMax(new int[] { 1, 2, 3, 4, 5, 6, 6 }));
		System.out.println(findMax(new int[] { 6, 6, 5, 4, 3, 2, 1 }));
//
		System.out.println(findMax(new int[] { 6, 5, 4, 3, 2, 1 }));
		System.out.println(findMax(new int[] { 1, 2 }));
		System.out.println(findMax(new int[] { 2, 1 }));
		System.out.println(findMax(new int[] { 2, 2 }));
		System.out.println(findMax(new int[] { 1 }));
	}
}
