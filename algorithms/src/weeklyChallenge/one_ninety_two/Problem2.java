package weeklyChallenge.one_ninety_two;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 5429. The k Strongest Values in an Array User Accepted:5748 User Tried:6386
 * Total Accepted:5888 Total Submissions:10896 Difficulty:Medium Given an array
 * of integers arr and an integer k.
 * 
 * A value arr[i] is said to be stronger than a value arr[j] if |arr[i] - m| >
 * |arr[j] - m| where m is the median of the array. If |arr[i] - m| == |arr[j] -
 * m|, then arr[i] is said to be stronger than arr[j] if arr[i] > arr[j].
 * 
 * Return a list of the strongest k values in the array. return the answer in
 * any arbitrary order.
 * 
 * Median is the middle value in an ordered integer list. More formally, if the
 * length of the list is n, the median is the element in position ((n - 1) / 2)
 * in the sorted list (0-indexed).
 * 
 * For arr = [6, -3, 7, 2, 11], n = 5 and the median is obtained by sorting the
 * array arr = [-3, 2, 6, 7, 11] and the median is arr[m] where m = ((5 - 1) /
 * 2) = 2. The median is 6. For arr = [-7, 22, 17, 3], n = 4 and the median is
 * obtained by sorting the array arr = [-7, 3, 17, 22] and the median is arr[m]
 * where m = ((4 - 1) / 2) = 1. The median is 3.
 * 
 * @author rajan-c
 *
 */
public class Problem2 {
	public static int[] getStrongest(int[] arr, int k) {
		Arrays.sort(arr);
		int median = arr[(arr.length - 1) / 2];
		int[] strongest = new int[k];
		Integer[] arrWithIntegers = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++)
			arrWithIntegers[i] = arr[i];
		Arrays.sort(arrWithIntegers, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1 - median) > Math.abs(o2 - median)
						|| (Math.abs(o1 - median) == Math.abs(o2 - median) && o1.compareTo(o2) > 0))
					return 1;
				else if (Math.abs(o2 - median) > Math.abs(o1 - median)
						|| (Math.abs(o2 - median) == Math.abs(o1 - median) && o2.compareTo(o1) > 0))
					return -1;
				return 0;
			}
		});
		for (int i = 0; i < k; i++)
			strongest[i] = arrWithIntegers[arrWithIntegers.length - k + i];
		return strongest;
	}

	public static void main(String[] args) {
		System.out.println(getStrongest(new int[] { 1, 2, 3, 4, 5 }, 2));
	}
}
