package arrays;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CountInversions {
	public static long countInversions(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		return countInversions(array, 0, array.length - 1);
	}

	private static long countInversions(int[] array, int start, int end) {
		if (end - start > 1) {
			int middle = (start + end) / 2;
			long leftInversion = countInversions(array, start, middle);
			long rightInversion = countInversions(array, middle + 1, end);
			long crossInversion = merge(array, start, middle, middle + 1, end);
			return leftInversion + rightInversion + crossInversion;
		} else if (end - start == 1) {
			int itemAtStart = array[start], itemAtEnd = array[end];
			if (itemAtStart > itemAtEnd) {
				array[start] = itemAtEnd;
				array[end] = itemAtStart;
				return 1;
			} else
				return 0;
		}
		return 0;
	}

	private static long merge(int[] array1, int leftStart, int leftEnd, int rightStart, int rightEnd) {
		long inversionCount = 0;
		int leftLength = leftEnd - leftStart + 1, rightLength = rightEnd - rightStart + 1;
		int[] leftSubarray = new int[leftLength], rightSubarray = new int[rightLength];
		for (int i = leftStart, index = 0; i <= leftEnd; i++)
			leftSubarray[index++] = array1[i];

		for (int i = rightStart, index = 0; i <= rightEnd; i++)
			rightSubarray[index++] = array1[i];

		int mergeArrayIndex = leftStart, leftIndex = 0, rightIndex = 0;
		while (leftIndex < leftLength && rightIndex < rightLength) {
			if (rightSubarray[rightIndex] < leftSubarray[leftIndex]) {
				array1[mergeArrayIndex++] = rightSubarray[rightIndex++];
				inversionCount += (leftLength - leftIndex);
			} else
				array1[mergeArrayIndex++] = leftSubarray[leftIndex++];
		}

		while (leftIndex < leftLength)
			array1[mergeArrayIndex++] = leftSubarray[leftIndex++];

		while (rightIndex < rightLength)
			array1[mergeArrayIndex++] = rightSubarray[rightIndex++];

		return inversionCount;
	}

	private static long countInversionInData(String fileName) throws IOException {
		Path path = Paths.get("D:\\programming\\algorithms\\src\\arrays\\" + fileName);
		List<String> lines = Files.readAllLines(path);
		int[] numbers = new int[lines.size()];
		for (int i = 0; i < numbers.length; i++)
			numbers[i] = Integer.parseInt(lines.get(i));
		return countInversions(numbers);
	}

	public static void main(String[] args) throws IOException {
		System.out.println(countInversionInData("inversion_data.txt"));
//		System.out.println(Paths.get("").toAbsolutePath());
//		System.out.println(countInversions(new int[] { 1, 2, 3, 4, 5 }));
//		System.out.println(countInversions(new int[] { 6, 5, 4, 3, 2, 1 }));
//		System.out.println(countInversions(new int[] { 2, 1, 0 }));
	}
}
