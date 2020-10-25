package greedy;

import java.util.Arrays;

public class Knapsack01WithEqualWeights {
	public static int maximumValue(int[][] items, int capacity) {
		Arrays.sort(items, (x, y) -> Integer.compare(y[1], x[1]));
		return maximumValue(items, 0, capacity);
	}

	private static int maximumValue(int[][] items, int index, int capacity) {
		if (capacity <= 0 || index >= items.length || capacity < items[index][0])
			return 0;
		return items[index][1] + maximumValue(items, index, capacity - items[index][0]);
	}

	public static void main(String[] args) {
		System.out.println(maximumValue(new int[][] { { 10, 60 }, { 10, 100 }, { 10, 120 } }, 15));
	}
}
