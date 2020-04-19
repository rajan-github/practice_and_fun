package arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements. Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * @author rajan-c
 *
 */
public class MoveZeros {

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void moveZeroes(int[] nums) {
		int processed = -1, processing = 0;
		for (processing = 0; processing < nums.length; processing++) {
			if (nums[processing] != 0)
				swap(nums, ++processed, processing);
		}
	}

	public static void main(String[] args) {
		int nums[] = { 0, 1, 0, 3, 2 };
		moveZeroes(nums);
		for (int item : nums) {
			System.out.print(item + ", ");
		}
		System.out.println();
	}

}
