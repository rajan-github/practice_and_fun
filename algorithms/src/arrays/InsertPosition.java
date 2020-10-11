package arrays;

/**
 * Search sorted array and return index of the position where target exists or
 * should be inserted.
 * 
 * @author rajan-c
 *
 */
public class InsertPosition {
	public static int searchInsert(int[] nums, int target) {
		if (target > nums[nums.length - 1])
			return nums.length;
		else if (target < nums[0])
			return 0;
		return search(nums, target, 0, nums.length - 1);
	}

	private static int search(int[] nums, int target, int startIndex, int endIndex) {
		if (startIndex <= endIndex) {
			int middle = (startIndex + endIndex) / 2;
			if (nums[middle] == target || (middle == 0 && nums[middle] > target))
				return middle;
			else if (nums[middle] > target)
				return search(nums, target, startIndex, middle - 1);
			else
				return search(nums, target, middle + 1, endIndex);
		}
		return startIndex;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 7; i++)
			System.out.println(searchInsert(new int[] { 1, 3, 5, 7, 9 }, i));

		System.out.println(searchInsert(new int[] { 1, 3, 5 }, 4));
		System.out.println(searchInsert(new int[] { 1, 3, 5 }, 2));
	}
}
