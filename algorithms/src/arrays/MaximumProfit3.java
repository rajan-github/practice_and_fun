package arrays;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (i.e., you
 * must sell the stock before you buy again).
 * 
 * @author rajan-c
 *
 */
public class MaximumProfit3 {

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;

		int[] diff = new int[prices.length - 1];
		for (int i = 1; i < prices.length; i++)
			diff[i - 1] = prices[i] - prices[i - 1];
		int maxSubarray[] = maximumSubarray(diff);
		if (maxSubarray[0] >= 0 && allPositive(diff, maxSubarray[0], maxSubarray[1] >= 0 ? maxSubarray[1] : 0))
			return sum(diff, maxSubarray[0], maxSubarray[1] >= 0 ? maxSubarray[1] : 0);
		else if (maxSubarray[0] >= 0) {
			return sumOfTwoMax(diff, maxSubarray[0], maxSubarray[1] >= 0 ? maxSubarray[1] : 0);
		} else
			return 0;
	}

	private static int sum(int[] array, int start, int end) {
		int sum = 0;
		for (int i = start; i <= end; i++)
			sum += array[i];
		return sum;
	}

	private static int sumOfTwoMax(int[] array, int start, int end) {
		int firstMax = array[start], secondMax = (start + 1) < array.length ? array[(start + 1)] : 0;
		for (int i = start + 2; i <= end; i++) {
			if (array[i] > firstMax) {
				if (firstMax > secondMax)
					secondMax = firstMax;
				firstMax = array[i];
			} else if (array[i] > secondMax)
				secondMax = array[i];
		}
		return firstMax + secondMax;
	}

	private static boolean allPositive(int[] array, int start, int end) {
		boolean allpositive = true;
		for (int i = 0; i <= end && allpositive; i++)
			if (array[i] < 0)
				allpositive = false;
		return allpositive;
	}

	private static int[] maximumSubarray(int[] array) {
		int maxSubarray = 0, current = 0;
		int[] indexes = { -1, -1 };
		boolean newsubarray = true;
		for (int i = 0; i < array.length; i++) {
			current += array[i];
			if (current >= 0) {
				if (newsubarray && current >= maxSubarray) {
					indexes[0] = i;
					newsubarray = false;

				} else if (current >= maxSubarray)
					indexes[1] = i;
				maxSubarray = Math.max(maxSubarray, current);
			} else {
				current = 0;
				if (!newsubarray)
					indexes[1] = i - 1;
				newsubarray = true;
			}

		}
		return indexes;
	}

	public static void main(String[] args) {
		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
//		prices = new int[] { 1, 2 };
		prices = new int[] { 7, 6, 4, 3, 1 };
//		System.out.println(maxProfit(prices));

		prices = new int[] { 3, 3, 5, 0, 0, 3, 1, 4 };
//		System.out.println(maxProfit(prices));

		prices = new int[] { 1, 2, 3, 4, 5 };
//		System.out.println(maxProfit(prices));

		prices = new int[] { 2, 1, 4 };
//		System.out.println(maxProfit(prices));

		prices = new int[] { 2, 1, 4, 0, 0, 3, 5, 2, 3, 1, 9 };
//		System.out.println(maxProfit(prices));

		prices = new int[] { 2, 1, 2, 0, 1 };
		System.out.println(maxProfit(prices));

//		System.out.println(sumOfTwoMax(new int[] { 5, -1, 2, -1, 3 }, 0, 4));
	}

}
