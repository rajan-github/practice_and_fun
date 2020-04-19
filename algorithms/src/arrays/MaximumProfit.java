package arrays;

/**
 * 
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (i.e., buy one and sell one share of the stock
 * multiple times).
 * 
 * Note: You may not engage in multiple transactions at the same time (i.e., you
 * must sell the stock before you buy again).
 * 
 * @author rajan-c
 *
 */
public class MaximumProfit {
	public static int maxProfit(int[] prices) {
		int profit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i] < prices[i + 1])
				profit += (prices[i + 1] - prices[i]);
		}
		return profit;
	}

	public static void main(String[] args) {
		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(prices));
		prices = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(maxProfit(prices));

		prices = new int[] { 7, 6, 4, 3, 1 };
		System.out.println(maxProfit(prices));
	}
}
