package backtracking;

public class Permutations {

	private static boolean isSolution(int[] nums, int k) {
		return nums.length == k;
	}

	private static void processSolution(int[] nums) {
		for (int item : nums)
			System.out.print(item + ", ");
		System.out.println();
	}

	public static void permute(int[] nums, int k) {
		if (isSolution(nums, k)) {
			processSolution(nums);
		} else {
			for (int l = k; l < nums.length; l++) {
				swap(nums, k, l);
				permute(nums, k + 1);
				swap(nums, k, l);
			}
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		permute(nums, 0);
	}

}
