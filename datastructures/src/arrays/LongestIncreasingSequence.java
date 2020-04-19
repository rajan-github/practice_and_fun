package arrays;

/**
 * Given a sequence of N numbers – A[1] , A[2] , …, A[N] . Find the length of
 * the longest non-decreasing sequence.
 * 
 * @author rajan-c
 *
 */
public class LongestIncreasingSequence {

	public static int longestIncreasingSequence(int[] nums) {
		int[] memory = new int[nums.length + 1];
		memory[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			int lastSmallIndex = lastSmallerValue(nums, i);
			memory[i + 1] = memory[lastSmallIndex + 1] + 1;
		}
		return memory[nums.length];
	}

	private static int lastSmallerValue(int[] nums, int index) {
		int current = nums[index];
		index--;
		while (index >= 0 && current < nums[index])
			index--;
		return index;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 3, 4, 8, 6, 7 };
		System.out.println(longestIncreasingSequence(nums));
		nums = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(longestIncreasingSequence(nums));
		nums = new int[] { 5, 4, 3, 2, 1 };
		System.out.println(longestIncreasingSequence(nums));
	}
}
