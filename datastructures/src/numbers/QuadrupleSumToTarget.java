package numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Quad {
	int a, b, c, d;

	public Quad(int a, int b, int c, int d) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		result = prime * result + c;
		result = prime * result + d;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quad other = (Quad) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		if (c != other.c)
			return false;
		if (d != other.d)
			return false;
		return true;
	}

}

public class QuadrupleSumToTarget {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> quadrupleList = new ArrayList<>();
		Map<Quad, Integer> map = new HashMap<>();
		if (nums.length > 3) {
			nums = mergeSort(nums, 0, nums.length - 1);
			for (int i = 0; i < nums.length; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					for (int k = j + 1; k < nums.length; k++) {
						int index = binarySearch(nums, k + 1, nums.length - 1, target - nums[i] - nums[j] - nums[k]);
						if (index >= 0 && !map.containsKey(new Quad(nums[i], nums[j], nums[k], nums[index]))) {
							List<Integer> quadruple = new ArrayList<>();
							quadruple.add(nums[i]);
							quadruple.add(nums[j]);
							quadruple.add(nums[k]);
							quadruple.add(nums[index]);
							quadrupleList.add(quadruple);
							map.put(new Quad(nums[i], nums[j], nums[k], nums[index]), 1);
						}
					}
				}
			}
		}
		return quadrupleList;
	}

	public int binarySearch(int[] nums, int start, int end, int key) {
		if (start <= end) {
			int middle = (start + end) / 2;
			if (nums[middle] == key)
				return middle;
			else if (nums[middle] > key)
				return binarySearch(nums, start, middle - 1, key);
			else
				return binarySearch(nums, middle + 1, end, key);
		}
		return -1;
	}

	public static int[] mergeSort(int[] array, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			int left[] = mergeSort(array, start, middle);
			int right[] = mergeSort(array, middle + 1, end);
			return merge(left, right, start, middle, end);
		}
		return (array.length > 0) ? new int[] { array[start] } : new int[] {};
	}

	private static int[] merge(int[] left, int[] right, int start, int middle, int end) {
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

	public static void main(String[] args) {
		QuadrupleSumToTarget quad = new QuadrupleSumToTarget();
		List<List<Integer>> quadruples = quad.fourSum(new int[] { 1, 0, -1, 0, -2, 2,1, 0, -1, 0, -2, 2 }, 3);
		quadruples.forEach(item -> System.out.println(item));
	}

}
