package arrays;

import java.util.HashMap;
import java.util.Map;

public class MaxEvents {
	public int maxEvents(int[][] events) {
		events = mergeSort(events, 0, events.length - 1);
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 0; i < events.length; i++) {
			int j = events[i][0];
			while (j <= events[i][1] && map.containsKey(j))
				j++;
			if (j <= events[i][1]) {
				max++;
				map.put(j, 1);
			}
		}
		return max;
	}

	public int[][] mergeSort(int[][] events, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			int[][] left = mergeSort(events, start, middle);
			int[][] right = mergeSort(events, middle + 1, end);
			return merge(left, right, start, middle, end);
		}
		return new int[][] { events[start] };
	}

	public int[][] merge(int[][] left, int[][] right, int start, int middle, int end) {
		int leftSize = middle - start + 1, rightSize = end - middle, leftIndex = 0, rightIndex = 0, index = 0;
		int[][] events = new int[end - start + 1][2];
		while (index < events.length && leftIndex < left.length && rightIndex < right.length) {
			if (left[leftIndex][1] <= right[rightIndex][1]) {
				events[index] = left[leftIndex];
				leftIndex++;
			} else {
				events[index] = right[rightIndex];
				rightIndex++;
			}
			index++;
		}

		while (leftIndex < leftSize) {
			events[index++] = left[leftIndex++];
		}
		while (rightIndex < rightSize) {
			events[index++] = right[rightIndex++];
		}
		return events;
	}

	public static void main(String[] args) {
		MaxEvents max = new MaxEvents();

		int[][] events = { { 1, 100000 } };

//		int[][] events = { { 1, 1 }, { 1, 2 }, { 5, 5 }, { 3, 3 }, { 1, 3 }, { 1, 4 }, { 4, 4 } };
		System.out.println(max.maxEvents(events));
	}

}
