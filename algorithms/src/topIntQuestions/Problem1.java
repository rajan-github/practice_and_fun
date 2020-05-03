package topIntQuestions;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each
 * element appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * 
 * Your function should return length = 5, with the first five elements of nums
 * being modified to 0, 1, 2, 3, and 4 respectively.
 * 
 * It doesn't matter what values are set beyond the returned length.
 * 
 * @author rajan-c
 *
 */
public class Problem1 {

	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int slow = 0;
		for (int fast = 0; slow < nums.length && fast < nums.length; slow++) {
			int nextIndex = getNextNumberIndex(nums, fast);
			if (nextIndex < nums.length)
				nums[slow + 1] = nums[nextIndex];
			fast = nextIndex;
		}
		return slow;
	}

	private static int getNextNumberIndex(int[] nums, int index) {
		int i = index + 1;
		while (i < nums.length && nums[i] == nums[index])
			i++;
		return i;
	}

	private static void display(int[] nums) {
		for (int item : nums)
			System.out.print(item + ", ");
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 1, 2 };
		System.out.println(removeDuplicates(array));
		display(array);
	}

}
