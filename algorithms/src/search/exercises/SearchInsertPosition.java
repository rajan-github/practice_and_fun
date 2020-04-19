package search.exercises;

public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
		return search(nums, 0, nums.length - 1, target);
	}

	private static int search(int[] nums, int first, int last, int target) {
		if (first == 0 && nums[first] >= target)
			return 0;
		else if (first <= last) {
			int middle = (first + last) / 2;
			if (nums[middle] == target || (middle > 0 && nums[middle - 1] < target && nums[middle] > target))
				return middle;
			else if (middle == last && nums[middle] < target)
				return middle + 1;
			else if (nums[middle] > target)
				return search(nums, first, middle - 1, target);
			else
				return search(nums, middle + 1, last, target);
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8 };
//		System.out.println(search(nums, 0, nums.length - 1, 1));
//		System.out.println(search(nums, 0, nums.length - 1, 8));
//		System.out.println(search(nums, 0, nums.length - 1, 9));
//		System.out.println(search(nums, 0, nums.length - 1, 0));
		nums = new int[] { 1, 3, 5, 6 };
		System.out.println(search(nums, 0, nums.length - 1, 0));
		System.out.println(search(nums, 0, nums.length - 1, 7));
		System.out.println(search(nums, 0, nums.length - 1, 2));
		System.out.println(search(nums, 0, nums.length - 1, 4));
		System.out.println(search(nums, 0, nums.length - 1, 5));
		nums = new int[] { 1 };
		System.out.println(search(nums, 0, nums.length - 1, 2));
	}
}
