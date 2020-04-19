package arrays;

/**
 * Given a non-empty array of integers, every element appears twice except for
 * one. Find that single one.
 * 
 * @author rajan-c
 *
 */
public class SingleNumber {
	public static int singleNumber(int[] nums) {
		int singleNumber = 0;
		for (int item : nums) {
			singleNumber ^= item;
		}
		return singleNumber;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 1, 2, 1, 2 };
		System.out.println(singleNumber(nums));

		nums = new int[] { 2, 2, 1 };
		System.out.println(singleNumber(nums));
	}
}
