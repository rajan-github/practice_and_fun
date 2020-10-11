package dynamicProgramming.practice2;

/**
 * Given keys in sorted order and frequencies for these keys. Compute the
 * minimum cost BST according to these frequencies.
 * 
 * @author rajan-c
 *
 */
public class OptimalBinarySearchTree {
	public static int optimalBST(int[] treeData, int[] frequencies) {
		int[] prefixSum = new int[treeData.length];
		prefixSum[0] = frequencies[0];
		for (int index = 1; index < frequencies.length; index++)
			prefixSum[index] = prefixSum[index - 1] + frequencies[index];
		return optimalBST(treeData, prefixSum, frequencies, 0, treeData.length - 1);
	}

	private static int optimalBST(int[] treeData, int[] prefixSum, int[] frequencies, int start, int end) {
		if (start == end)
			return frequencies[start];
		else if (start > end)
			return 0;
		int minCost = Integer.MAX_VALUE;
		for (int i = start; i <= end; i++)
			minCost = Math.min(minCost,
					optimalBST(treeData, prefixSum, frequencies, start, i - 1)
							+ optimalBST(treeData, prefixSum, frequencies, i + 1, end)
							+ (start > 0 ? prefixSum[end] - prefixSum[start - 1] : prefixSum[end]));
		return minCost;
	}

	public static int optimalBSTIterative(int[] keys, int[] frequencies) {
		if (keys == null || frequencies == null || keys.length != frequencies.length || keys.length == 0)
			return 0;
		int[] prefixSum = new int[keys.length];
		prefixSum[0] = frequencies[0];

		for (int i = 1; i < frequencies.length; i++)
			prefixSum[i] = prefixSum[i - 1] + frequencies[i];

		int[][] memory = new int[frequencies.length][frequencies.length];
		for (int i = 0; i < frequencies.length; i++)
			memory[i][i] = frequencies[i];

		for (int length = 2; length <= keys.length; length++) {
			for (int i = 0; i <= (keys.length - length); i++) {
				int j = i + length - 1;
				int cost = Integer.MAX_VALUE;
				for (int k = i; k <= j; k++)
					cost = Math.min(cost, (k > i ? memory[i][k - 1] : 0) + (k + 1 <= j ? memory[k + 1][j] : 0));
				memory[i][j] = cost + (prefixSum[j] - (i > 0 ? prefixSum[i - 1] : 0));
			}
		}
		return memory[0][frequencies.length - 1];
	}

	public static void main(String[] args) {
		int[] keys = new int[] { 10, 12 }, frequencies = new int[] { 34, 50 };
		System.out.println(optimalBST(keys, frequencies) == optimalBSTIterative(keys, frequencies));
		keys = new int[] { 10, 12, 20 };
		frequencies = new int[] { 34, 8, 50 };
		System.out.println(optimalBST(keys, frequencies) == optimalBSTIterative(keys, frequencies));
	}
}
