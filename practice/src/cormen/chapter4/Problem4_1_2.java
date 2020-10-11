package cormen.chapter4;

public class Problem4_1_2 {
	public static int maximumSubarrayBruteforce(int[] array) {
		int[] prefixSum = new int[array.length];
		prefixSum[0] = array[0];
		for (int i = 1; i < array.length; i++)
			prefixSum[i] = prefixSum[i - 1] + array[i];

		int maximumSum = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (i == 0)
					maximumSum = Math.max(maximumSum, prefixSum[j]);
				else
					maximumSum = Math.max(maximumSum, prefixSum[j] - prefixSum[i - 1]);
			}
		}
		return maximumSum;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
		System.out.println(maximumSubarrayBruteforce(array));
	}
}
