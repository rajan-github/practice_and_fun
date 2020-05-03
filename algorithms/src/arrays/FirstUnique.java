package arrays;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * You have a queue of integers, you need to retrieve the first unique integer
 * in the queue.
 * 
 * Implement the FirstUnique class:
 * 
 * FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
 * int showFirstUnique() returns the value of the first unique integer of the
 * queue, and returns -1 if there is no such integer. void add(int value) insert
 * value to the queue.
 * 
 * @author rajan-c
 *
 */
public class FirstUnique {
	private int[] data;
	private int size = 0;
	Map<Integer, Integer> frequency = new HashMap<>();
	LinkedHashMap<Integer, Integer> uniques = new LinkedHashMap<>();

	public FirstUnique(int[] nums) {
		data = new int[(int) Math.pow(10, 5) * 2];
		frequency.clear();
		for (int i = 0; i < nums.length; i++) {
			data[size++] = nums[i];
			if (frequency.containsKey(nums[i])) {
				frequency.replace(nums[i], frequency.get(nums[i]) + 1);
				uniques.remove(nums[i]);
			} else {
				frequency.put(nums[i], 1);
				uniques.put(nums[i], nums[i]);
			}

		}
	}

	public int showFirstUnique() {
		if (!uniques.isEmpty()) {
			for (Map.Entry<Integer, Integer> entry : uniques.entrySet())
				return entry.getKey();
		}
		return -1;
	}

	public void add(int value) {
		if (size < data.length) {
			this.data[size++] = value;
			if (frequency.containsKey(value)) {
				frequency.replace(value, frequency.get(value) + 1);
				uniques.remove(value);
			} else {
				frequency.put(value, 1);
				uniques.put(value, value);
			}

		}
	}

	public static void main(String[] args) {
		int[] nums = new int[100000];
		for (int i = 0; i < 100000; i++)
			nums[i] = i + 1;
		FirstUnique fq = new FirstUnique(nums);
		System.out.println(fq.showFirstUnique());
		for (int i = 0; i < 49998; i++) {
			if (i == 49997) {
				fq.add(i + 1);
			} else
				fq.add(i + 1);

		}
		int temp = fq.showFirstUnique();
		System.out.println(temp);
	}
}
