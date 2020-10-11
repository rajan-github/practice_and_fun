package arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Suppose you have a random list of people standing in a queue. Each person is
 * described by a pair of integers (h, k), where h is the height of the person
 * and k is the number of people in front of this person who have a height
 * greater than or equal to h. Write an algorithm to reconstruct the queue.
 * 
 * Note: The number of people is less than 1,100.
 * 
 * @author rajan-c
 *
 */
public class ReconstructQueue {
	public static int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] > o2[0])
					return 1;
				else if (o1[0] < o2[0])
					return -1;
				return 0;
			}
		});
		int[][] queue = new int[people.length][2];
		for (int i = 0; i < queue.length; i++)
			queue[i] = null;

		for (int[] height : people) {
			int largerPeopleAhead = height[1];
			int index = 0;
			while (largerPeopleAhead > 0) {
				if (queue[index] == null || queue[index][0] >= height[0])
					largerPeopleAhead--;
				index++;
			}
			while (index < queue.length && queue[index] != null)
				index++;
			queue[index] = height;
		}
		return queue;
	}

	public static void main(String[] args) {
		// {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}}
		reconstructQueue(new int[][] { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } });

//		reconstructQueue(new int[][] { { 2, 4 }, { 3, 4 }, { 9, 0 }, { 0, 6 }, { 7, 1 }, { 6, 0 }, { 7, 3 }, { 2, 5 },
//				{ 1, 1 }, { 8, 0 } });
	}
}
