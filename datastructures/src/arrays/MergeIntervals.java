package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * 
 * @author rajan-c
 *
 */
public class MergeIntervals {

	private static int[][] mergeSort(int[][] intervals, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			int[][] leftPart = mergeSort(intervals, left, middle);
			int[][] rightPart = mergeSort(intervals, middle + 1, right);
			return mergeArrays(leftPart, rightPart);
		} else if (left == right) {
			return new int[][] { intervals[left] };
		} else
			return intervals;
	}

	private static int compareIntervals(int[] interval1, int[] interval2) {
		int difference = 0;
		if (interval1[0] < interval2[0] || (interval1[0] == interval2[0] && interval1[1] < interval2[1])) {
			difference = -1;
		} else if (interval1[0] > interval2[0] || (interval1[0] == interval2[0] && interval1[1] > interval2[1])) {
			difference = 1;
		}
		return difference;
	}

	private static int[][] mergeArrays(int[][] leftArray, int[][] rightArray) {
		int leftLength = leftArray.length;
		int rightLength = rightArray.length;

		int mergedLength = leftLength + rightLength;
		int[][] mergedArray = new int[mergedLength][2];

		int leftIndex = 0, rightIndex = 0, mergeArrayIndex = 0;

		while (leftIndex < leftLength && rightIndex < rightLength) {
			int diff = compareIntervals(leftArray[leftIndex], rightArray[rightIndex]);
			if (diff <= 0)
				mergedArray[mergeArrayIndex++] = leftArray[leftIndex++];
			else
				mergedArray[mergeArrayIndex++] = rightArray[rightIndex++];
		}

		while (leftIndex < leftLength && rightIndex >= rightLength)
			mergedArray[mergeArrayIndex++] = leftArray[leftIndex++];

		while (rightIndex < rightLength && leftIndex >= leftLength)
			mergedArray[mergeArrayIndex++] = rightArray[rightIndex++];
		return mergedArray;
	}

	private static boolean doOverlap(int[] interval1, int[] interval2) {
		if (interval1.length == 0 || interval2.length == 0)
			return true;
		if (interval1[interval1.length - 1] >= interval2[0])
			return true;
		return false;
	}

	private static int[] mergeInterval(int[] interval1, int[] interval2) {
		if (interval1.length == 0)
			return interval2;
		else if (interval2.length == 0)
			return interval1;
		else {
			int[] mergedInterval = { Math.min(interval1[0], interval2[0]),
					Math.max(interval1[interval1.length - 1], interval2[interval2.length - 1]) };
			return mergedInterval;
		}
	}

	public static int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length == 0)
			return intervals;

		intervals = mergeSort(intervals, 0, intervals.length - 1);
		List<int[]> mergedIntervals = new ArrayList<>();
		int intervalNumber = 0, length = intervals.length;
		while (intervalNumber < length) {
			int[] currentInterval = intervals[intervalNumber];
			int nextInterval = intervalNumber + 1;
			while (nextInterval < intervals.length) {
				if (doOverlap(currentInterval, intervals[nextInterval])) {
					currentInterval = mergeInterval(currentInterval, intervals[nextInterval]);
					nextInterval++;
				} else {
					intervalNumber = nextInterval;
					break;
				}
			}
			mergedIntervals.add(currentInterval);
			if (nextInterval >= intervals.length) {
				intervalNumber = nextInterval;
			}
		}
		int mergedListSize = mergedIntervals.size();
		int[][] mergedArrays = new int[mergedListSize][2];
		for (int i = 0; i < mergedListSize; i++)
			mergedArrays[i] = mergedIntervals.get(i);
		return mergedArrays;
	}

	private static void display(int[][] lists) {
		for (int[] interval : lists)
			System.out.print("[" + interval[0] + ", " + interval[1] + "]");
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] nums = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
//		display(merge(nums));
		nums = new int[][] { { 1, 4 }, { 4, 5 } };
		display(merge(nums));

		nums = new int[][] { { 1, 4 }, { 5, 5 }, { 5, 5 }, { 5, 5 }, { 5, 5 } };
		display(merge(nums));

//		nums = new int[][] { { 1, 4 }, { 6, 7 }, { 8, 9 }, { 10, 11 }, { 12, 13 } };
//		display(merge(nums));

		nums = new int[][] { { 1, 4 }, { 0, 0 } };
		display(merge(nums));

		nums = new int[][] { { 2, 3 }, { 4, 5 }, { 6, 7 }, { 8, 9 }, { 1, 10 } };
		display(merge(nums));

		nums = new int[][] { { 2, 3 }, { 4, 5 }, { 6, 7 }, { 8, 9 }, { 4, 10 } };
		display(merge(nums));

		nums = new int[][] { { 2, 3 }, { 4, 5 }, { 6, 7 }, { 8, 9 }, { 2, 10 } };
		display(merge(nums));
		
		nums = new int[][] { { 2, 3 }, { 4, 5 }, { 6, 7 }, { 8, 9 }, { 2, 10 } };
		display(merge(nums));
	}
}
