package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonOverlappingIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;
		Arrays.sort(intervals, (int[] x, int[] y) -> x[1] - y[1]);
		List<int[]> intervalList = new ArrayList<>();
		for (int[] interval : intervals)
			intervalList.add(interval);
//		return eraseOverlapIntervals(intervalList);
		return -1;
	}

	public static void main(String[] args) {
//		int[][] intervals = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
		int[][] intervals = new int[][] { { 1, 2 }, { 1, 2 }, { 1, 2 }, { 1, 2 } };
		NonOverlappingIntervals n = new NonOverlappingIntervals();
		System.out.println(n.eraseOverlapIntervals(intervals));
	}
}
