package arrays;

public class Subsets {

	private static void printSubset(int[] nums, boolean[] subset) {
		System.out.print("[");
		for (int i = 0; i < nums.length; i++) {
			if (subset[i])
				System.out.print(nums[i] + ", ");
		}
		System.out.println("]");
	}

	private static void backtrack(int[] nums, boolean[] subset, int k) {
		if (k == nums.length) {
			printSubset(nums, subset);
			return;
		} else {
			subset[k] = false;
			backtrack(nums, subset, k + 1);
			subset[k] = true;
			backtrack(nums, subset, k + 1);
		}
	}

	private static void generateSubsets(int[] nums) {
		boolean[] subset = new boolean[nums.length];
		for (int i = 0; i < subset.length; i++)
			subset[i] = true;
		backtrack(nums, subset, 0);
	}

	public static void main(String[] args) {
		generateSubsets(new int[] { 1, 2 });
	}
}
