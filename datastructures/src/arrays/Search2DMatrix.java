package arrays;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row.
 * 
 * @author rajan-c
 *
 */
public class Search2DMatrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		boolean found = false;
		for (int[] row : matrix) {
			if (target <= row[row.length - 1]) {
				int index = search(row, target);
				if (index >= 0) {
					found = true;
					break;
				}
			}
		}
		return found;
	}

	private static int search(int[] nums, int key) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (nums[middle] == key)
				return middle;
			else if (nums[middle] < key)
				left = middle + 1;
			else
				right = middle - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[][] nums = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		System.out.println(searchMatrix(nums, 3));
		System.out.println(searchMatrix(nums, 16));
		System.out.println(searchMatrix(nums, 34));
		System.out.println(searchMatrix(nums, 50));
		System.out.println(searchMatrix(nums, 5));
		System.out.println(searchMatrix(nums, 11));
		System.out.println(searchMatrix(nums, 13));
		System.out.println(searchMatrix(new int[][] {}, 13));
	}
}
