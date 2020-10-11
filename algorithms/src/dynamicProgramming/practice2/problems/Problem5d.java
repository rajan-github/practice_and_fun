package dynamicProgramming.practice2.problems;

public class Problem5d {
	public int longestOscillatingSubsequence(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		int[][][] memory = new int[array.length + 1][array.length + 1][2];

		for (int i = 0; i <= array.length; i++) {
			for (int j = i + 1; j <= array.length; j++) {
				if (i == 0) {
//array[i]
				}
			}
		}

		return memory[array.length - 1][memory.length - 1][0];
	}

	private int longestOscilatingSubsequence(int[] array, int index, boolean shouldBeHigher, int lastIndex) {
		if (index < 0)
			return 0;

		if (lastIndex == array.length)
			return Math.max(1 + longestOscilatingSubsequence(array, index - 1, !shouldBeHigher, index),
					longestOscilatingSubsequence(array, index - 1, shouldBeHigher, lastIndex));
		if (shouldBeHigher && array[index] > array[lastIndex])
			return Math.max(1 + longestOscilatingSubsequence(array, index - 1, !shouldBeHigher, index),
					longestOscilatingSubsequence(array, index - 1, shouldBeHigher, lastIndex));
		else if (shouldBeHigher)
			return longestOscilatingSubsequence(array, index - 1, shouldBeHigher, lastIndex);
		else if (!shouldBeHigher && array[index] < array[lastIndex])
			return Math.max(1 + longestOscilatingSubsequence(array, index - 1, !shouldBeHigher, index),
					longestOscilatingSubsequence(array, index - 1, shouldBeHigher, lastIndex));
		else
			return longestOscilatingSubsequence(array, index - 1, shouldBeHigher, lastIndex);
	}

	public static void main(String[] args) {
		int[] array = new int[] { 10, 22, 9, 33, 49, 50, 31, 60 };
		System.out.println(new Problem5d().longestOscillatingSubsequence(array));
	}
}
