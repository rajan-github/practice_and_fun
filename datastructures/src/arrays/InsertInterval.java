package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5] Output: [[1,5],[6,9]]
 * 
 * @author rajan-c
 *
 */
public class InsertInterval {

	private static boolean doOverlap(int[] interval1, int[] interval2) {
		boolean overlap = true;
		if ((interval1[0] < interval2[0] && interval1[1] < interval2[0])
				|| (interval2[0] < interval1[0] && interval2[1] < interval1[0]))
			overlap = false;
		return overlap;
	}

	private static int[] mergeInterval(int[] interval1, int[] interval2) {
		int[] mergedInterval = new int[] { Math.min(interval1[0], interval2[0]), Math.max(interval1[1], interval2[1]) };
		return mergedInterval;
	}

	private static List<int[]> insertInterval(int[][] intervals, int[] newInterval) {
		List<int[]> intervalsAfterInsertion = new ArrayList<>();
		boolean isAdded = false;
		for (int[] interval : intervals) {
			if (doOverlap(interval, newInterval) && !isAdded) {
				intervalsAfterInsertion.add(mergeInterval(interval, newInterval));
				isAdded = true;
			} else if (newInterval[1] < interval[0] && !isAdded) {
				intervalsAfterInsertion.add(newInterval);
				intervalsAfterInsertion.add(interval);
				isAdded = true;
			} else
				intervalsAfterInsertion.add(interval);
		}

		if (!isAdded) {
			intervalsAfterInsertion.add(newInterval);
			isAdded = true;
		}
		return intervalsAfterInsertion;
	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		if (intervals.length == 0) {
			return new int[][] { newInterval };
		}
		List<int[]> intervalsList = insertInterval(intervals, newInterval);
		List<int[]> mergedList = new ArrayList<>();
		int i = 0;
		while (i < intervalsList.size()) {
			int[] currentInterval = intervalsList.get(i);
			int j = i + 1;
			while (j < intervalsList.size() && doOverlap(currentInterval, intervalsList.get(j))) {
				currentInterval = mergeInterval(currentInterval, intervalsList.get(j));
				j++;
			}
			i = j;
			mergedList.add(currentInterval);
		}

		int[][] insertedIntervals = new int[mergedList.size()][2];
		int index = 0;
		for (int[] interval : mergedList)
			insertedIntervals[index++] = interval;

		return insertedIntervals;
	}

	public static void display(int[][] intervals) {
		for (int[] interval : intervals)
			System.out.println("[" + interval[0] + ", " + interval[1] + "]");
	}

	public static void main(String[] args) {
		int[][] intervals = new int[][] { { 1, 3 }, { 6, 9 } };
//		display(insert(intervals, new int[] { 2, 5 }));

		intervals = new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
		display(insert(intervals, new int[] { 4, 8 }));

//		intervals = new int[][] { { 2, 3 } };
//		display(insert(intervals, new int[] { 1, 8 }));

		intervals = new int[][] {};
//		display(insert(intervals, new int[] { 1, 8 }));

		intervals = new int[][] { { 1, 3 }, { 4, 6 } };
//		display(insert(intervals, new int[] { 3, 8 }));

		intervals = new int[][] { { 1, 3 }, { 4, 6 } };
//		display(insert(intervals, new int[] { 0, 0 }));

	}
}
