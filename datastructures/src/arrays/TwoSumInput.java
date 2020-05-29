package arrays;

/**
 * Find two indexes which sum to the target. Indexes are 1 based not 0 starting.
 * Do it in O(n) time.
 * 
 * @author rajan-c
 *
 */
public class TwoSumInput {
	public static int[] twoSum(int[] numbers, int target) {
		int[] indexes = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			int item = numbers[i];
			int index = binarySearch(numbers, target - item);
			if (index >= 0 && index != i) {
				indexes[0] = (i < index) ? i + 1 : index + 1;
				indexes[1] = (i < index) ? index + 1 : i + 1;
				return indexes;
			}
		}
		return indexes;
	}

	private static int binarySearch(int[] numbers, int target) {
		int start = 0, end = numbers.length - 1;
		while (start < end && start < numbers.length) {
			int middle = (start + end) / 2;
			if (numbers[middle] == target)
				return middle;
			else if (numbers[middle] < target)
				start = middle + 1;
			else
				end = middle - 1;
		}
		return numbers[start] == target ? start : -1;
	}

	public static void main(String[] args) {
		int[] indexes = twoSum(new int[] { 5, 25, 75 }, 100);
		System.out.println(indexes[0] + ", " + indexes[1]);
	}
}
