package numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Triplet {
	int a, b, c;

	public Triplet(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		result = prime * result + c;
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
		Triplet other = (Triplet) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		if (c != other.c)
			return false;
		return true;
	}

}

public class TripletSumZero {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> triplets = new ArrayList<List<Integer>>();
		if (nums.length > 2) {
			Map<Triplet, Integer> map = new HashMap<>();
			nums = MergeSort.mergeSort(nums, 0, nums.length - 1);
			for (int i = 0; i < nums.length; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					int sum = nums[i] + nums[j];
					int index = binarySearch(nums, j + 1, nums.length - 1, -1 * sum);
					if (index >= 0) {
						Triplet triplet = new Triplet(nums[i], nums[j], nums[index]);
						if (!map.containsKey(triplet)) {
							map.put(triplet, 1);
							List<Integer> list = new ArrayList<>();
							list.add(nums[i]);
							list.add(nums[j]);
							list.add(nums[index]);
							triplets.add(list);
						}
					}
				}
			}
		}
		return triplets;
	}

	private int binarySearch(int[] nums, int start, int end, int key) {
		if (start <= end) {
			int middle = (start + end) / 2;
			if (nums[middle] == key) {
				return middle;
			} else if (nums[middle] > key)
				return binarySearch(nums, start, middle - 1, key);
			else
				return binarySearch(nums, middle + 1, end, key);
		}
		return -1;
	}

	public static void main(String[] args) {
		TripletSumZero trip = new TripletSumZero();
		List<List<Integer>> triplets = trip.threeSum(new int[] { -2, 0, 1, 1, 2 });
		triplets.forEach((item) -> System.out.println(item));
//		System.out.println(trip.getTriplet(0, 2, 0));
//		System.out.println(trip.getTriplet(1, 2, -3));
//		System.out.println(trip.getTriplet(-1, -2, -4));
	}
}
