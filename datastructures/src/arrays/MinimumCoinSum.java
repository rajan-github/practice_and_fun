package arrays;

/**
 * Given a list of N coins, their values (V1, V2, … , VN), and the total sum S.
 * Find the minimum number of coins the sum of which is S (we can use as many
 * coins of one type as we want), or report that it’s not possible to select
 * coins in such a way that they sum up to S.
 * 
 * @author rajan-c
 *
 */
public class MinimumCoinSum {

	private static int minCoin(int sum, int[] coins) {
		if (sum == 0)
			return 0;
		else {
			int[] count = new int[sum + 1];
			for (int i = 0; i <= sum; i++)
				count[i] = Integer.MAX_VALUE;
			count[0] = 0;
			for (int coin = 0; coin < coins.length; coin++) {
				for (int i = 1; i <= sum; i++) {
					if (coins[coin] <= i) {
						count[i] = Math.min(count[i], count[i - coins[coin]] + 1);
					}
				}
			}
			return count[sum];
		}
	}

	public static void main(String[] args) {
		int[] coins = { 1, 3, 5 };
		System.out.println(minCoin(20, coins));
	}
}
