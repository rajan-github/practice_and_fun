package search;

public class MergeSort {
	public static int[] mergeSort(int[] array, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			int left[] = mergeSort(array, start, middle);
			int right[] = mergeSort(array, middle + 1, end);
			return merge(left, right, start, middle, end);
		}
		return new int[] { array[start] };
	}

	private static int[] merge(int[] left, int[] right, int start, int middle, int end) {
		int leftSize = middle - start + 1, rightSize = end - middle, leftIndex = 0, rightIndex = 0, index = 0;
		int[] merged = new int[leftSize + rightSize];
		while (leftIndex < leftSize && rightIndex < rightSize) {
			if (left[leftIndex] <= right[rightIndex]) {
				merged[index] = left[leftIndex++];
			} else {
				merged[index] = right[rightIndex++];
			}
			index++;
		}

		while (leftIndex < leftSize)
			merged[index++] = left[leftIndex++];

		while (rightIndex < rightSize)
			merged[index++] = right[rightIndex++];
		return merged;
	}

	public static void main(String[] args) {
		int array[] = { 5, 4, 3, 3, 2, 1 };
		array = mergeSort(array, 0, array.length - 1);
		for (int i = 0; i < array.length; i++)
			System.out.println(array[i]);
	}
}
