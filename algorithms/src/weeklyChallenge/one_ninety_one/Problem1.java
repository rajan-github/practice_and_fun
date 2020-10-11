package weeklyChallenge.one_ninety_one;

/**
 * Given the array of integers nums, you will choose two different indices i and
 * j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
 * 
 * @author rajan-c
 *
 */
public class Problem1 {
	public int maxProduct(int[] nums) {
		int maxProduct = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				maxProduct = Math.max(maxProduct, (nums[i] - 1) * (nums[j] - 1));
			}
		}
		return maxProduct;
	}
}
