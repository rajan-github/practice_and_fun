package arrays;

public class SearchOnRotatedArray {
	public static boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return false;
		else if (nums.length == 1) {
			return nums[0] == target ? true : false;
		} else {
			int rotationPoint = findPivot(nums, 0, nums.length - 1);
			boolean foundInLeft = search(nums, 0, rotationPoint < nums.length ? rotationPoint : nums.length - 1,
					target);
			if (!foundInLeft && rotationPoint < nums.length - 1) {
				return search(nums, rotationPoint + 1, nums.length - 1, target);
			} else
				return foundInLeft;
		}
	}

	private static int findPivot(int[] nums, int left, int right) {
		if (left <= right) {
			int middle = (left + right) / 2;
			if (middle < nums.length - 1 && nums[middle] > nums[middle + 1])
				return middle;
			else if (left < middle && nums[middle] < nums[left])
				return findPivot(nums, left, middle - 1);
			else
				return findPivot(nums, middle + 1, right);
		}
		return left;
	}

	private static boolean search(int[] nums, int left, int right, int key) {
		if (left <= right) {
			int middle = (left + right) / 2;
			if (nums[middle] == key)
				return true;
			else if (nums[middle] < key)
				return search(nums, middle + 1, right, key);
			else
				return search(nums, left, middle - 1, key);
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 5, 6, 0, 0, 1 };
//		System.out.println(search(nums, 0));
//		System.out.println(search(nums, 1));
//		System.out.println(search(nums, 2));
//		System.out.println(search(nums, 5));
//		System.out.println(search(nums, 6));
//		System.out.println(search(nums, 7));

//		nums = new int[] { 2, 3, 4, 5, 6, 7, 0, 1 };
//		System.out.println(search(nums, 7));
//		System.out.println(search(nums, 0));
//		System.out.println(search(new int[] {}, 0));

//		nums = new int[] { 1, 3, 1, 1, 1 };
//		System.out.println(search(nums, 1));
//		System.out.println(findRotationPoint(nums, 0, nums.length - 1));
//		nums = new int[] { 1, 1, 1, 1, 1 };
//		System.out.println(findRotationPoint(nums, 0, nums.length - 1));
//		nums = new int[] { 1, 2, 3, 4, 5, 6 };
//		System.out.println(findRotationPoint(nums, 0, nums.length - 1));
		nums = new int[] { 1, 2, 3, 4, 5, 6, 0, 1, 1, 1, };
		System.out.println(findPivot(nums, 0, nums.length - 1));
//		System.out.println(search(nums, 3));

//		nums = new int[] { 2, 2, 2, 3, 1 };
//		System.out.println(findPivot(nums, 0, nums.length - 1));
//		nums = new int[] { 2, 2, 2, 3, 0, 1, 2, 2, 2, 2 };
//		System.out.println(findPivot(nums, 0, nums.length - 1));
//		nums = new int[] { 1, 2, 3, 0 };
//		System.out.println(findPivot(nums, 0, nums.length - 1));
//		nums = new int[] { 2, 2, 1 };
//		System.out.println(findPivot(nums, 0, nums.length - 1));
//
//		nums = new int[] { 3, 1, 2 };
//		System.out.println(findPivot(nums, 0, nums.length - 1));
//
//		nums = new int[] { 3, 4, 2 };
//		System.out.println(findPivot(nums, 0, nums.length - 1));
//
//		nums = new int[] { 3, 1 };
//		System.out.println(findPivot(nums, 0, nums.length - 1));
//		nums = new int[] { 3, 2 };
//		System.out.println(findPivot(nums, 0, nums.length - 1));
//
//		nums = new int[] { 3, 1, 1, 1, 1 };
//		System.out.println(findPivot(nums, 0, nums.length - 1));

		nums = new int[] { 1, 3, 1, 1, 1 };
		System.out.println(findPivot(nums, 0, nums.length - 1));
		System.out.println(search(nums, 3));
	}
}
