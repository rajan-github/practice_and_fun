package dynamicProgramming.practice;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * @author rajan-c
 *
 */
public class HouseRobber {
	public static int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] memory = new int[nums.length];
		for (int i = 0; i < memory.length; i++)
			memory[i] = -1;
		rob(nums, 0, memory);
		return memory[0];
	}

	private static int rob(int[] nums, int robbed, int[] memory) {
		if (robbed >= nums.length)
			return 0;
		if (memory[robbed] >= 0)
			return memory[robbed];
		memory[robbed] = Math.max(nums[robbed] + rob(nums, robbed + 2, memory),
				((robbed == nums.length - 1) ? 0 : nums[robbed + 1]) + rob(nums, robbed + 3, memory));
		return memory[robbed];
	}

	public static void main(String[] args) {
		System.out.println(rob(new int[] { 1, 2, 3, 1 }));

		System.out.println(rob(new int[] { 2, 7, 9, 3, 1 }));
		System.out.println(rob(new int[] { 6, 6, 4, 8, 4, 3, 3, 10 }));

	}
}
