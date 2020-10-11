package dynamicProgramming.practice2.problems;

public class Problem3 {
	/**
	 * Describe and analyze an algorithm that finds the largest sum of elements in a
	 * contiguous subarray A[i .. j].
	 * 
	 * @param array
	 * @return
	 */
	public static int largestSumInContigousSubarray(int[] array) {
		int largestSum = 0;
		if (array == null || array.length == 0)
			return largestSum;
		int currentSum = 0;
		for (int i = 0; i < array.length; i++) {
			currentSum += array[i];
			largestSum = Math.max(largestSum, currentSum);
			if (currentSum < 0)
				currentSum = 0;
		}
		return largestSum;
	}

	/**
	 * Describe and analyze an algorithm that finds the largest product of elements
	 * in a contiguous subarray A[i .. j].
	 * 
	 * @param array
	 * @return
	 */
	public static int largestMultiplicationInContigousSubaray(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		int largestMultiplication = 0;
		int[][] multiplications = new int[array.length][array.length];
		for (int i = 0; i < array.length; i++)
			multiplications[i][i] = array[i];
		for (int length = 2; length <= array.length; length++) {
			for (int i = 0; i <= array.length - length; i++) {
				int j = i + length - 1;
				multiplications[i][j] = multiplications[i][j - 1] * multiplications[j][j];
				largestMultiplication = Math.max(largestMultiplication, multiplications[i][j]);
			}
		}
		return largestMultiplication;
	}

	public static void main(String[] args) {
//		System.out.println(largestSumInContigousSubarray(new int[] { -6, 12, -7, 0, 14, -7, 5 }));
//		System.out.println(largestSumInContigousSubarray(new int[] { -365 }));
		System.out.println(largestMultiplicationInContigousSubaray(new int[] { -6, 12, -7, 0, 14, -7, 5 }));
		System.out.println(largestMultiplicationInContigousSubaray(new int[] { 1, 2, 3, 4, 5 }));
//		System.out.println(largestSumInContigousSubarray(new int[] { -365 }));
	}
}
