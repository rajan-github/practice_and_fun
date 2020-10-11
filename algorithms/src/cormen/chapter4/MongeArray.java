package cormen.chapter4;

public class MongeArray {

	public static int[] leftmostMinimumIndex(int[][] array) {
		int[] indexes = new int[array.length];
		int[] evenRows = new int[array.length / 2];
		for (int i = 0, index = 0; i < array.length; i++)
			if ((i & 1) == 1)
				evenRows[index++] = i;
		leftMostMinimumIndexInEvenRow(array, evenRows, indexes);
		return indexes;
	}

	private static void leftMostMinimumIndexInEvenRow(int[][] array, int[] evenRows, int[] indexes) {
		if (evenRows.length == 1) {
			int[] row = array[evenRows[0]];
			indexes[evenRows[0]] = findMinItemIndex(row, 0, row.length - 1);
		} else {
			int[] evenIndexes = new int[evenRows.length / 2];
			for (int i = 0, index = 0; i <= evenIndexes.length; i++) {
				if ((i & 1) == 1)
					evenIndexes[index++] = evenRows[i];
			}
			leftMostMinimumIndexInEvenRow(array, evenIndexes, indexes);

			for (int i = 0; i < evenIndexes[evenIndexes.length - 1]; i++) {
				if ((i & 1) == 1)
					indexes[evenRows[i]] = findMinItemIndex(array[evenRows[i]], 0, indexes[evenIndexes[i]]);
			}

			for (int i = evenIndexes[evenIndexes.length - 1] + 1; i < evenRows.length; i++) {
				if ((i & 1) == 1)
					indexes[i] = findMinItemIndex(array[evenRows[i]], indexes[evenRows[i] - 2], array[0].length - 1);
			}
		}
	}

	private static int findMinItemIndex(int[] array, int start, int end) {
		int min = start;
		for (int i = start; i <= end; i++)
			if (array[i] < array[min])
				min = i;
		return min;
	}

	public static boolean isMongeArray(int[][] array) {
		if (array == null || array.length == 0)
			return true;
		for (int row = 0; row < array.length - 1; row++) {
			for (int col = 0; col < array[0].length - 1; col++) {
				if (array[row][col] + array[row + 1][col + 1] > array[row][col + 1] + array[row + 1][col])
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] array = new int[][] { { 37, 23, 22, 32 }, { 21, 6, 5, 10 }, { 53, 34, 30, 31 }, { 32, 13, 9, 6 },
				{ 43, 21, 15, 8 } };

		int[] indexes = leftmostMinimumIndex(array);
		System.out.println(indexes);
	}
}
