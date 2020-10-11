package cormen.chapter4;

public class Problem4_1_3 {
	public static int maximumSubarrayDC(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		return maximumSubarray(array, 0, array.length - 1);
	}

	private static int maximumSubarray(int[] array, int start, int end) {
		if (start == end)
			return array[start];
		int middle = (start + end) / 2;
		int left = maximumSubarray(array, start, middle);
		int right = maximumSubarray(array, middle + 1, end);
		int acrossMiddle = maximumSubarrayAcross(array, start, middle, end);
		return max(left, right, acrossMiddle);
	}

	private static int max(int a, int b, int c) {
		if (a >= b && a >= c)
			return a;
		else if (b >= a && b >= c)
			return b;
		return c;
	}

	private static int maximumSubarrayAcross(int[] array, int start, int middle, int end) {
		int maximumLeft = 0;
		int leftIndex = middle;
		int sum = 0;
		while (leftIndex >= 0) {
			sum += array[leftIndex];
			leftIndex--;
			maximumLeft = Math.max(sum, maximumLeft);
		}

		int rightIndex = middle + 1;
		sum = 0;
		int maximumRight = 0;
		while (rightIndex <= end) {
			sum += array[rightIndex];
			rightIndex++;
			maximumRight = Math.max(maximumRight, sum);
		}
		return maximumRight + maximumLeft;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
		System.out.println(maximumSubarrayDC(array));
	}
}
