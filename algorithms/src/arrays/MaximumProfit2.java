package arrays;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (i.e., buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * Note that you cannot sell a stock before you buy one.
 * 
 * @author rajan-c
 *
 */
public class MaximumProfit2 {
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;

		int[] diff = new int[prices.length - 1];
		for (int i = 1; i < prices.length; i++)
			diff[i - 1] = prices[i] - prices[i - 1];
		return maximumSubarray(diff);
	}

	private static int maximumSubarray(int[] array) {
		int maxSubarray = 0, current = 0;
		for (int item : array) {
			current += item;
			if (current >= 0)
				maxSubarray = Math.max(maxSubarray, current);
			else
				current = 0;
		}
		return maxSubarray;
	}

	public static void main(String[] args) {
		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
		prices = new int[] { 1, 2 };
		prices = new int[] { 7, 6, 4, 3, 1 };
		System.out.println(maxProfit(prices));
	}
}
