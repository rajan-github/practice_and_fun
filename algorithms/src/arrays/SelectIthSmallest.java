package arrays;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Given an arbitrary array, find return the kth samllest element in the array.
 * 
 * @author rajan-c
 *
 */
public class SelectIthSmallest {

	public static int randomSelect(int[] array, int k) {
		if (array == null || array.length == 0 || k > array.length || k < 1)
			return -1;
		k -= 1;
		return randomSelect(array, 0, array.length - 1, k);
	}

	private static int randomSelect(int[] array, int start, int end, int k) {
		int randomIndex = ThreadLocalRandom.current().nextInt(start, end + 1);
		int i = partition(array, start, end, randomIndex);
		if (i == k)
			return array[i];
		else if (i < k)
			return randomSelect(array, i + 1, end, k);
		return randomSelect(array, start, i - 1, k);
	}

	private static int partition(int[] array, int start, int end, int pivotIndex) {
		swap(array, start, pivotIndex);
		int pivot = array[start];
		int i = start + 1;
		for (int j = start + 1; j <= end; j++) {
			if (array[j] <= pivot) {
				swap(array, i, j);
				i++;
			}
		}
		swap(array, start, i - 1);
		return i - 1;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
//		for (int i = 0; i < 100; i++)
		System.out.println(randomSelect(new int[] { 8, 5, 4, 3, 9, 1, 2, 6, 7 }, 3));
		System.out.println(randomSelect(new int[] { 8, 5, 4, 3, 9, 1, 2, 6, 7 }, 1));
		System.out.println(randomSelect(new int[] { 8, 5, 4, 3, 9, 1, 2, 6, 7 }, 2));
		System.out.println(randomSelect(new int[] { 8, 5, 4, 3, 9, 1, 2, 6, 7 }, 4));
		System.out.println(randomSelect(new int[] { 8, 5, 4, 3, 9, 1, 2, 6, 7 }, 5));
		System.out.println(randomSelect(new int[] { 8, 5, 4, 3, 9, 1, 2, 6, 7 }, 6));
		System.out.println(randomSelect(new int[] { 8, 5, 4, 3, 9, 1, 2, 6, 7 }, 7));
		System.out.println(randomSelect(new int[] { 8, 5, 4, 3, 9, 1, 2, 6, 7 }, 8));
		System.out.println(randomSelect(new int[] { 8, 5, 4, 3, 9, 1, 2, 6, 7 }, 9));
	}
}
