package arrays;

/**
 * Given a sorted array nums, remove the duplicates in-place such that
 * duplicates appeared at most twice and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * @author rajan-c
 *
 */
public class RemoveDuplicates {
	public static int removeDuplicates(int[] nums) {
		int updatedLength = nums.length, index = 0;
		while (index < updatedLength) {
			int[] nextIndexInfo = getNextNumberIndex(nums, index, updatedLength);
			updatedLength -= (nextIndexInfo[1]);
			index = nextIndexInfo[0];
		}
		return updatedLength;
	}

	private static int[] getNextNumberIndex(int[] nums, int index, int length) {
		int nextNumberIndex = index;
		int[] temp = new int[2];
		while (nextNumberIndex < length && nums[nextNumberIndex] == nums[index])
			nextNumberIndex++;
		int i = index + 2;
		if (i < nextNumberIndex) {
			temp[1] = nextNumberIndex - i;
			while (i < length && nextNumberIndex < length) {
				nums[i] = nums[nextNumberIndex];
				i++;
				nextNumberIndex++;
			}
		}
		temp[0] = i == index + 2 ? nextNumberIndex : index + 2;
		return temp;
	}

	public static void display(int[] nums) {
		System.out.print("[");
		for (int item : nums)
			System.out.print(item + ", ");
		System.out.println("]");
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 5, 5, 5, 5, 5, 6 };
//		System.out.println(removeDuplicates(nums));
//		display(nums);

//		nums = new int[] { 1, 2, 3, 4, 5 };
//		System.out.println(removeDuplicates(nums));
//		display(nums);

		nums = new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
		System.out.println(removeDuplicates(nums));
		display(nums);

	}
}
