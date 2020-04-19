package dynamicProgramming;

/**
 * Problem: Integer Partition without Rearrangement. Input: An arrangement S of
 * nonnegative numbers {s1 ,...,sn } and an integer k. Output: Partition S into
 * k or fewer ranges, to minimize the maximum sum over all the ranges, without
 * reordering any of the numbers.
 * 
 * @author rajan-c
 *
 */
public class IntegerPartition {
	public static void partition(int[] numbers, int k) {
		if (numbers == null || numbers.length < k)
			return;
		int[][] partitionCost = new int[k + 1][numbers.length + 1];
		int[] prefixSum = new int[numbers.length + 1];
		int[][] partitions = new int[k + 1][numbers.length + 1];
		prefixSum[0] = 0;
		for (int i = 1; i <= numbers.length; i++)
			prefixSum[i] = prefixSum[i - 1] + numbers[i - 1];

		for (int i = 0; i <= numbers.length; i++)
			partitionCost[1][i] = prefixSum[i];
		for (int i = 0; i <= k; i++)
			partitionCost[i][1] = numbers[0];

		for (int row = 2; row <= k; row++) {
			for (int col = 2; col <= numbers.length; col++) {
				partitionCost[row][col] = Integer.MAX_VALUE;
				for (int i = 1; i <= col; i++) {
					int cost = Math.max(partitionCost[row - 1][i], prefixSum[col] - prefixSum[i]);
					if (cost < partitionCost[row][col]) {
						partitionCost[row][col] = cost;
						partitions[row][col] = i;
					}
				}

			}
		}
		reconstructSolution(numbers, partitions, k, numbers.length);
	}

	private static void reconstructSolution(int[] numbers, int[][] partition, int row, int col) {
		if (row <= 0 || col <= 0)
			return;
		System.out.println();
		System.out.print("{");
		for (int index = partition[row][col]; index < col; index++)
			System.out.print(numbers[index] + ", ");
		System.out.print("}");
		reconstructSolution(numbers, partition, row - 1, partition[row][col]);
	}

	public static void display(int[][] array) {
		for (int[] row : array) {
			System.out.print("[");
			for (int item : row)
				System.out.print(item + ", ");
			System.out.println("]");
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 100, 200, 300, 400, 500, 600, 700, 800, 900 };
		partition(nums, 3);

		nums = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		partition(nums, 3);
//		System.out.println(partitions);
	}
}
