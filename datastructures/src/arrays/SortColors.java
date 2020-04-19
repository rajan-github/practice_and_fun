package arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * @author rajan-c
 *
 */
public class SortColors {
	public static void sortColors(int[] nums) {
		if (nums == null || nums.length == 0)
			return;
		int[] aux = new int[3];
		for (int item : nums) {
			aux[item] += 1;
		}

		int j = 0;
		for (int i = 0; i <= 2; i++) {
			int colorCount = aux[i];
			while (colorCount-- > 0) {
				nums[j++] = i;
			}
		}
	}

	private static void display(int[] nums) {
		for (int item : nums)
			System.out.print(item + ", ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] nums = { 2, 0, 2, 1, 1, 0 };
		sortColors(nums);
		display(nums);
	}
}
