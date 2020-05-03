package strings;

/**
 * Given an array nums of 0s and 1s and an integer k, return True if all 1's are
 * at least k places away from each other, otherwise return False.
 * 
 * @author rajan-c
 *
 */
public class KthLengthApart {
	public static boolean kLengthApart(int[] nums, int k) {
		boolean klengthApart = true;
		int previous = -1;
		for (int i = 0; i < nums.length && klengthApart; i++) {
			if (nums[i] == 1) {
				if (previous == -1)
					previous = i;
				else if (i - previous <= k)
					klengthApart = false;
				else
					previous = i;
			}
		}
		return klengthApart;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 0, 0, 1, 0, 1 };
		System.out.println(kLengthApart(nums, 2));
	}
}
