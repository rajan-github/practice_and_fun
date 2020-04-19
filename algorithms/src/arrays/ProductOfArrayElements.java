package arrays;

/**
 * Given an array nums of n integers where n > 1, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Constraint: It's guaranteed that the product of the elements of any prefix or
 * suffix of the array (including the whole array) fits in a 32 bit integer.
 * 
 * Note: Please solve it without division and in O(n).
 * 
 * @author rajan-c
 *
 */
public class ProductOfArrayElements {

	public static int[] productExceptSelf(int[] nums) {
		int[] prefixMultiplications = multiplyArrayItems(nums, true);
		int[] suffixMultiplications = multiplyArrayItems(nums, false);
		for (int i = 0; i < nums.length; i++)
			suffixMultiplications[i] = (i > 0 ? prefixMultiplications[i - 1] : 1)
					* (i + 1 < nums.length ? suffixMultiplications[i + 1] : 1);
		return suffixMultiplications;
	}

	private static int[] multiplyArrayItems(int[] nums, boolean ascendingOrder) {
		int[] multiplications = new int[nums.length];
		if (ascendingOrder) {
			multiplications[0] = nums[0];
			for (int index = 1; index < nums.length; index++) {
				multiplications[index] = multiplications[index - 1] * nums[index];
			}
		} else {
			int size = nums.length;
			multiplications[size - 1] = nums[size - 1];
			size -= 2;
			while (size >= 0) {
				multiplications[size] = multiplications[size + 1] * nums[size];
				size--;
			}
		}
		return multiplications;
	}

	private static void display(int[] nums) {
		System.out.print("[");
		for (int item : nums)
			System.out.print(item + ", ");
		System.out.println("]");
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4 };
		display(productExceptSelf(nums));

		nums = new int[] { 3, 2 };
		display(productExceptSelf(nums));
	}
}
