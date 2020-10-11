package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNumber {
	public static int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			int item = nums[i];
			if (!map.containsKey(item))
				map.put(item, 1);
			else
				map.replace(item, map.get(item) + 1);
			if (map.get(item).intValue() == 1)
				set.add(nums[i]);
			else if (map.get(item).intValue() > 1)
				set.remove(item);
		}
		return set.iterator().next();
	}

	public static int singleNumberFaster(int[] nums) {
		int number = 0;
		for (int item : nums)
			number ^= item;
		System.out.println(number);
		System.out.println(1 ^ 0);
		return 0;
	}

	public static void main(String[] args) {
//		System.out.println(singleNumber(new int[] { -401451, -177656, -2147483646, -473874, -814645, -2147483646,
//				-852036, -457533, -401451, -473874, -401451, -216555, -917279, -457533, -852036, -457533, -177656,
//				-2147483646, -177656, -917279, -473874, -852036, -917279, -216555, -814645, 2147483645, -2147483648,
//				2147483645, -814645, 2147483645, -216555 }));

		System.out.println(singleNumberFaster(new int[] { 1, 1, 1, 2, 2, 2, 3 }));
	}
}
