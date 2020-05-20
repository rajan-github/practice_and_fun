package dynamicProgramming.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * @author rajan-c
 *
 */
public class CoinChange {

	public static int coinChange(int[] coins, int amount) {
		if (amount == 0)
			return 0;
		else if (coins == null || (coins.length == 0 && amount > 0) || amount < 0 || min(coins) > amount)
			return -1;

		Map<Integer, Integer> coinCount = new HashMap<>();
		return coinChange(coins, amount, coinCount);
	}

	public static int coinChange(int[] coins, int amount, Map<Integer, Integer> coinCount) {
		if (amount == 0)
			return 0;
		else if (coins == null || (coins.length == 0 && amount > 0) || amount < 0 || min(coins) > amount)
			return -1;

		if (coinCount.containsKey(amount))
			return coinCount.get(amount);
		int minCoin = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] <= amount) {
				int count = coinChange(coins, amount - coins[i], coinCount);
				if (count >= 0) {
					minCoin = Math.min(1 + count, minCoin);
				}
			}
		}
		coinCount.put(amount, minCoin == Integer.MAX_VALUE ? -1 : minCoin);
		return coinCount.get(amount);
	}

	private static int min(int[] coins) {
		int min = coins[0];
		for (int coin : coins)
			if (coin < min)
				min = coin;
		return min;
	}

	/**
	 * Optimized version: bottoms up solution.
	 * @param coins
	 * @param amount
	 * @return
	 */
	public static int coinChange2(int[] coins, int amount) {
		if (amount == 0)
			return 0;
		else if (coins == null || (coins.length == 0 && amount > 0) || amount < 0 || min(coins) > amount)
			return -1;
		int[][] memory = new int[coins.length][amount + 1];

		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j < memory[0].length; j++) {
				int coin = coins[i];
				if (coin > j && i == 0)
					memory[i][j] = Integer.MAX_VALUE;
				else if (coin > j && i > 0) {
					memory[i][j] = memory[i - 1][j];
				} else {
					if (coin == j)
						memory[i][j] = 1;
					else if (coin < j) {
						memory[i][j] = (memory[i][j - coin] == Integer.MAX_VALUE) ? Integer.MAX_VALUE
								: 1 + memory[i][j - coin];
						if (i > 0)
							memory[i][j] = Math.min(memory[i][j], memory[i - 1][j]);
					} else
						memory[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		return memory[coins.length - 1][amount] == Integer.MAX_VALUE ? -1 : memory[coins.length - 1][amount];
	}

	public static void main(String[] args) {
		System.out.println(coinChange(new int[] { 1, 2, 5 }, 11) == coinChange2(new int[] { 1, 2, 5 }, 11));
		System.out.println(coinChange(new int[] { 50, 60, 100 }, 110) == coinChange2(new int[] { 50, 60, 100 }, 110));
		System.out.println(coinChange(new int[] { 50, 60, 100 }, 100) == coinChange2(new int[] { 50, 60, 100 }, 100));
		System.out.println(coinChange(new int[] { 50, 60, 100 }, 70) == coinChange2(new int[] { 50, 60, 100 }, 70));
		System.out.println(coinChange(new int[] { 50, 60, 100 }, 750) == coinChange2(new int[] { 50, 60, 100 }, 750));
		System.out.println(coinChange(new int[] { 1, 2, 5 }, 100) == coinChange2(new int[] { 1, 2, 5 }, 100));
	}

}
