package dynamicProgramming.practice;

//import auxiliaryMethods.CommonMethods;

public class MaxCoins {

	public static int maxCoins(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		else if (nums.length == 1)
			return nums[0];

		int maxCoins = Integer.MIN_VALUE;
		int[][] memory = new int[nums.length][nums.length];

		for (int length = 1; length < nums.length; length++) {
			for (int row = 0; row <= nums.length - length; row++) {
				int col = Math.min(nums.length, row + length - 1);
				if (row == col) {
					if (row == 0)
						memory[row][col] = nums[row] * nums[col + 1];
					else if (row == nums.length - 1)
						memory[row][col] = nums[row - 1] * nums[row];
					else
						memory[row][col] = nums[row - 1] * nums[row] * nums[row + 1];

				} else {
					int coins = Integer.MIN_VALUE;
					for (int i = row; i <= col; i++) {
						if (i == 0) {
							coins = Math.max(coins, memory[i + 1][col]);
						}
					}
				}
			}
		}
		return maxCoins;
	}

	public static void main(String[] args) {
		System.out.println(maxCoins(new int[] { 3, 1, 5 }));
	}

}
