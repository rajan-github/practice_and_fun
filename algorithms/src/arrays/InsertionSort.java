package arrays;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class InsertionSort {

	public long quicksort(int[] array) {
		return quicksort(array, 0, array.length - 1);
	}

	private long quicksort(int[] array, int left, int right) {
		if (left < right) {
			int index = partition(array, left, right);
			long leftComparisons = quicksort(array, left, index - 1);
			long rightComparisons = quicksort(array, index + 1, right);
			return leftComparisons + rightComparisons + (right - left);
		} else
			return 0;
	}

	private int partition(int[] array, int left, int right) {
		int first = left, middle = (left + right) / 2, last = right;
		int medianIndex = median(array, first, middle, last);
		swap(array, left, medianIndex);
		int i = left + 1;
		int pivot = array[left];
		for (int j = left + 1; j <= right; j++) {
			if (array[j] < pivot) {
				swap(array, i, j);
				i++;
			}
		}
		swap(array, i - 1, left);
		return i - 1;
	}

	private int median(int[] array, int left, int middle, int right) {
		if ((array[left] >= array[right] && array[left] <= array[middle])
				|| (array[left] <= array[right] && array[left] >= array[middle]))
			return left;
		else if ((array[right] >= array[middle] && array[right] <= array[left])
				|| (array[right] >= array[left] && array[right] <= array[middle]))
			return right;
		return middle;
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) throws IOException {
		String path = Paths.get("").toAbsolutePath() + "\\src\\arrays\\quicksort1.txt";
		List<String> lines = Files.readAllLines(Paths.get(path));
		int[] data = new int[lines.size()];
		for (int i = 0; i < data.length; i++)
			data[i] = Integer.parseInt(lines.get(i));
		System.out.println(new InsertionSort().quicksort(data));
		System.out.println(Arrays.toString(data));
	}
}
