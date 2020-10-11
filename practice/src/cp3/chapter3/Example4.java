package cp3.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * There are 0 < n ≤ 8 movie goers. They will sit in the front row in n
 * consecutive open seats. There are 0 ≤ m ≤ 20 seating constraints among them,
 * i.e. movie goer a and movie goer b must be at most (or at least) c seats
 * apart. The question is simple: How many possible seating arrangements are
 * there?
 * 
 * @author rajan-c
 *
 */
public class Example4 {
	public static void socialConstraint(int n, int[][] constraints) {
		List<int[]> arrangements = new ArrayList<>();
		int[] teenagers = new int[n];
		for (int i = 0; i < n; i++)
			teenagers[i] = i;
		allArrangements(teenagers, 0, arrangements);
		int ans = 0;
		for (int[] arrangement : arrangements) {
			if (verifyConstraints(arrangement, constraints))
				ans++;
		}
		System.out.println(ans);
	}

	private static boolean verifyConstraints(int[] arrangement, int[][] constraints) {
		boolean passed = true;
		for (int[] constraint : constraints) {
			int a = constraint[0], b = constraint[1], c = constraint[2];
			int[] positions = search(arrangement, a, b);
			if ((c >= 0 && Math.abs(positions[1] - positions[0]) > Math.abs(c))
					|| (c < 0 && Math.abs(positions[1] - positions[0]) < Math.abs(c))) {
				passed = false;
				break;
			}
		}
		return passed;
	}

	private static int[] search(int[] nums, int target1, int target2) {
		int[] indexes = new int[2];

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target1)
				indexes[0] = i;
			if (nums[i] == target2)
				indexes[1] = i;
		}
		return indexes;
	}

	private static void allArrangements(int[] nums, int index, List<int[]> arrangements) {
		if (nums.length - index <= 2) {
			int[] clone = new int[nums.length];
			for (int i = 0; i < nums.length; i++)
				clone[i] = nums[i];
			arrangements.add(clone);
			clone = new int[nums.length];
			for (int i = 0; i < nums.length; i++)
				clone[i] = nums[i];
			swap(clone, clone.length - 2, clone.length - 1);
			arrangements.add(clone);
		} else {
			for (int i = index; i < nums.length; i++) {
				swap(nums, i, index);
				allArrangements(nums, index + 1, arrangements);
				swap(nums, i, index);
			}
		}
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		socialConstraint(3, new int[][] { { 0, 1, -2 } });
		socialConstraint(3, new int[][] {});
	}
}
