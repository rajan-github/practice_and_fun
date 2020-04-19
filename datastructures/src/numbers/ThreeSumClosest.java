package numbers;

public class ThreeSumClosest {

	public int[] mergeSort(int[] array, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			int left[] = mergeSort(array, start, middle);
			int right[] = mergeSort(array, middle + 1, end);
			return merge(left, right, start, middle, end);
		}
		return (array.length > 0) ? new int[] { array[start] } : new int[] {};
	}

	private int[] merge(int[] left, int[] right, int start, int middle, int end) {
		int leftSize = middle - start + 1, rightSize = end - middle, leftIndex = 0, rightIndex = 0, index = 0;
		int[] merged = new int[leftSize + rightSize];
		while (leftIndex < leftSize && rightIndex < rightSize) {
			if (left[leftIndex] <= right[rightIndex]) {
				merged[index] = left[leftIndex++];
			} else {
				merged[index] = right[rightIndex++];
			}
			index++;
		}

		while (leftIndex < leftSize)
			merged[index++] = left[leftIndex++];

		while (rightIndex < rightSize)
			merged[index++] = right[rightIndex++];
		return merged;
	}

	public int threeSumClosest(int[] nums, int target) {
		int closestSum = Integer.MAX_VALUE;
		if (nums.length > 2) {
			nums = mergeSort(nums, 0, nums.length - 1);
			closestSum = nums[0] + nums[1] + nums[2];
			for (int i = 0; i < nums.length - 2; i++) {
				int j = i + 1, k = nums.length - 1;
				while (j < k) {
					int sum = nums[i] + nums[j] + nums[k];
					if (sum == target) {
						return target;
					} else if (Math.abs(sum - target) < Math.abs(closestSum - target))
						closestSum = sum;
					if ((sum - target) > 0)
						k--;
					else
						j++;
				}
			}
		}
		return closestSum;
	}

	public static void main(String[] args) {
		ThreeSumClosest sum = new ThreeSumClosest();
		System.out.println(sum.threeSumClosest(new int[] { -1, -2, -4, -8, -16, -32, -64, -128 }, -134));
	}
}
