package dynamicProgramming.practice;

/**
 * We are playing the Guess Game. The game is as follows:
 * 
 * I pick a number from 1 to n. You have to guess which number I picked.
 * 
 * Every time you guess wrong, I'll tell you whether the number I picked is
 * higher or lower.
 * 
 * However, when you guess a particular number x, and you guess wrong, you pay
 * $x. You win the game when you guess the number I picked.
 * 
 * @author rajan-c
 *
 */
public class GuessNumber {

	public static int getMoneyAmount(int n) {
		if (n == 1)
			return 0;
		int[][] memory = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++)
				if (i == j)
					memory[i][j] = 0;
				else
					memory[i][j] = -1;
		}
		return getMoneyAmount(1, n, memory);
	}

	private static int getMoneyAmount(int lower, int upper, int[][] memory) {
		if (lower >= upper)
			return 0;
		if (memory[lower][upper] >= 0)
			return memory[lower][upper];
		int minAmount = Integer.MAX_VALUE;
		for (int i = lower; i <= upper; i++) {
			minAmount = Math.min(minAmount,
					Math.max(i + getMoneyAmount(i + 1, upper, memory), i + getMoneyAmount(lower, i - 1, memory)));
		}
		memory[lower][upper] = minAmount;
		return minAmount;
	}

	public static void main(String[] args) {
		System.out.println(getMoneyAmount(4));
		System.out.println(getMoneyAmount(5));
		System.out.println(getMoneyAmount(6));
		System.out.println(getMoneyAmount(10));
	}
}
