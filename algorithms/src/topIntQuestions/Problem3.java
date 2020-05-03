package topIntQuestions;

import auxiliaryMethods.CommonMethods;

/**
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative. Input: [1,2,3,4,5,6,7] and k = 3 Output: [5,6,7,1,2,3,4]
 * 
 * @author rajan-c
 *
 */
public class Problem3 {
	public static void rotate(int[] nums, int k) {
		k = k % nums.length;
		while (k-- > 0)
			rotateOnce(nums);
	}

	private static void rotateOnce(int[] nums) {
		int temp = nums[nums.length - 1];
		int index = nums.length - 2;
		while (index >= 0) {
			nums[index + 1] = nums[index];
			index--;
		}
		nums[0] = temp;
	}

	public static void rotateFast(int[] nums, int k) {
		k = k % nums.length;
		int[] indexArray = new int[nums.length], aux = new int[k];

		for (int i = 0; i < k; i++)
			aux[i] = nums[nums.length - k + i];

		for (int i = indexArray.length - k - 1; i >= 0; i--) {
			nums[(i + k)] = nums[i];
		}

		for (int i = 0; i < k; i++)
			nums[i] = aux[i];
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
//		rotate(nums, 3);
		rotateFast(nums, 3);
		CommonMethods.display(nums);
	}
}
