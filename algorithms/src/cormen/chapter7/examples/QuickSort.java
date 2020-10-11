package cormen.chapter7.examples;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import auxiliaryMethods.CommonMethods;

/**
 * Randomized Quicksort implementation.
 * 
 * @author rajan-c
 *
 */
public class QuickSort {
	public static void sort(int[] array) {
		sort(array, 0, array.length - 1);
	}

	private static void sort(int[] array, int start, int end) {
		if (start < end) {
			int index = partition(array, start, end);
			sort(array, start, index - 1);
			sort(array, index + 1, end);
		}
	}

	private static int partition(int[] array, int start, int end) {
		int randomIndex = ThreadLocalRandom.current().nextInt(start, end + 1);
		swap(array, randomIndex, end);
		int pivot = array[end];

		int j = start, i = start - 1;
		for (j = start, i = start - 1; j < end; j++) {
			if (array[j] <= pivot) {
				swap(array, i + 1, j);
				i++;
			}
		}
		swap(array, i + 1, end);
		return i + 1;
	}

	/**
	 * It partitions the array in three parts: smaller than pivot, equal to pivot,
	 * and greater than pivot.
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	private static int[] partition1(int[] array, int start, int end) {
		int randomIndex = ThreadLocalRandom.current().nextInt(start, end + 1);
		swap(array, randomIndex, end);
		int pivot = array[end];
		int smallerThanPivot = 0;
		for (int i = start; i <= end; i++)
			if (array[i] < pivot)
				smallerThanPivot++;
		int i = start - 1, j = start, k = start + smallerThanPivot - 1;
		while (j < end) {
			if (array[j] < pivot) {
				swap(array, i + 1, j);
				i = i + 1;
			} else if (array[j] == pivot) {
				swap(array, k + 1, j);
				k++;
			}
			j++;
		}
		swap(array, k + 1, end);
		CommonMethods.display(array);
		return new int[] { i, k + 1 };
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 5, 4, 3, 2, 1, 0 };
		sort(array);
//		System.out.println(Arrays.toString(array));

		array = new int[] { 0, 1, 2, 3, 4, 5 };
		sort(array);
//		System.out.println(Arrays.toString(array));

		array = new int[] { 4, 3, 2, 5, 1, 0 };
		sort(array);
//		System.out.println(Arrays.toString(array));

		array = new int[] { 0, 0, 0, 0, 0, 0 };
		int[] indexes = partition1(array, 0, array.length - 1);
		System.out.println(Arrays.toString(indexes));
	}
}
