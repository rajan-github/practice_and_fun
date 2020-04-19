package arrays;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * @author rajan-c
 *
 */
public class JumpGame {
	public static boolean canJump(int[] nums) {
		return canJumpBacktrack(nums, 0);
	}

	private static boolean canJumpBacktrack(int[] nums, int position) {
		if (nums == null || nums.length == 0 || position == nums.length - 1)
			return true;
		int nextPositions = Math.min(nums.length - 1, position + nums[position]);
		for (int nextPosition = position + 1; nextPosition <= nextPositions; nextPosition++) {
			if (canJumpBacktrack(nums, nextPosition))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println(canJump(nums));
//
		nums = new int[] { 3, 2, 1, 0, 4 };
		System.out.println(canJump(nums));

		nums = new int[] { 8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0, 8, 6, 9, 1, 1, 6, 3, 5, 1, 2, 6, 6, 0, 4, 8, 6, 0, 3, 2,
				8, 7, 6, 5, 1, 7, 0, 3, 4, 8, 3, 5, 9, 0, 4, 0, 1, 0, 5, 9, 2, 0, 7, 0, 2, 1, 0, 8, 2, 5, 1, 2, 3, 9, 7,
				4, 7, 0, 0, 1, 8, 5, 6, 7, 5, 1, 9, 9, 3, 5, 0, 7, 5 };

		System.out.println(canJump(nums));

		nums = new int[] { 8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0 };
		System.out.println(canJump(nums));
	}
}
