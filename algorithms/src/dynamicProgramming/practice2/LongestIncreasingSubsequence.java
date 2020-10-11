package dynamicProgramming.practice2;

/**
 * Longest common increasing subsequence.
 * 
 * @author rajan-c
 *
 */
public class LongestIncreasingSubsequence {
	public static int longestIncreasingSubsequence(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		int[][] memory = new int[array.length][array.length];
		for (int i = 0; i < memory.length; i++) {
			for (int j = 0; j < memory.length; j++)
				memory[i][j] = -1;
		}
		int maxLength = longestIncreasingSubsequence(array, 0, -1, memory);
//		CommonMethods.display(memory);
		return maxLength;
	}

	private static int longestIncreasingSubsequence(int[] array, int currentIndex, int lastIndex, int[][] memory) {
		if (currentIndex >= array.length)
			return 0;

		if (lastIndex >= 0 && memory[currentIndex][lastIndex] >= 0)
			return memory[currentIndex][lastIndex];
		int longestSubseq = Integer.MIN_VALUE;
		if ((lastIndex >= 0 && array[currentIndex] >= array[lastIndex]) || lastIndex < 0) {
			longestSubseq = Math.max(longestSubseq,
					1 + longestIncreasingSubsequence(array, currentIndex + 1, currentIndex, memory));
		}
		longestSubseq = Math.max(longestSubseq,
				longestIncreasingSubsequence(array, currentIndex + 1, lastIndex, memory));
		memory[currentIndex][lastIndex < 0 ? 0 : lastIndex] = longestSubseq;
		return longestSubseq;
	}

	private static int longestIncreasingSubsequenceIterative(int[] array) {
		int[] newArray = new int[array.length + 1];
		newArray[0] = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++)
			newArray[i + 1] = array[i];

		array = newArray;
		int[][] memory = new int[array.length][array.length + 1];
		int currentIndex = array.length - 1;

		while (currentIndex >= 0) {
			for (int lastIndex = 0; lastIndex < currentIndex; lastIndex++) {
				int skip = memory[lastIndex][currentIndex + 1];
				int keep = 1 + memory[currentIndex][currentIndex + 1];
				if (array[lastIndex] >= array[currentIndex])
					memory[lastIndex][currentIndex] = skip;
				else
					memory[lastIndex][currentIndex] = Math.max(skip, keep);
			}
			currentIndex--;
		}

//		CommonMethods.display(memory);
		return memory[0][1];
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(longestIncreasingSubsequence(array) + ", " + longestIncreasingSubsequenceIterative(array));

		array = new int[] { 5, 4, 3, 2, 1 };
		System.out.println(longestIncreasingSubsequence(array) + ", " + longestIncreasingSubsequenceIterative(array));
//
		array = new int[] { 1, 0, 2, 3, 1, 4, 5, 7, 2, 4 };
		System.out.println(longestIncreasingSubsequence(array) + ", " + longestIncreasingSubsequenceIterative(array));

		array = new int[] { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(longestIncreasingSubsequence(array) + ", " + longestIncreasingSubsequenceIterative(array));
	}
}
