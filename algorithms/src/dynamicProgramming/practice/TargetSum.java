package dynamicProgramming.practice;

public class TargetSum {
	int count = 0;

	public int findTargetSumWays(int[] nums, int sum) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] memory = new int[nums.length];
		for (int i = 0; i < memory.length; i++)
			memory[i] = -1;
		findTargetSum(nums, sum, 0, memory);
		return count;
	}

	private void findTargetSum(int[] nums, int sum, int index, int[] memory) {
		if (index >= nums.length) {
			if (sum == 0)
				count++;
			return;
		}
		if (memory[index] >= 0)
			return;
		findTargetSum(nums, sum + nums[index], index + 1, memory);
		findTargetSum(nums, sum - nums[index], index + 1, memory);
		memory[index] = count;
	}

	public static void main(String[] args) {
		TargetSum ts = new TargetSum();
		ts.findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3);
		System.out.println(ts.count);
	}
}
