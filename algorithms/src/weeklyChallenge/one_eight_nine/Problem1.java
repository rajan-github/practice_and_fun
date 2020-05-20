package weeklyChallenge.one_eight_nine;

/**
 * Given two integer arrays startTime and endTime and given an integer
 * queryTime.
 * 
 * The ith student started doing their homework at the time startTime[i] and
 * finished it at time endTime[i].
 * 
 * Return the number of students doing their homework at time queryTime. More
 * formally, return the number of students where queryTime lays in the interval
 * [startTime[i], endTime[i]] inclusive.
 * 
 * 
 * @author rajan-c
 *
 */
public class Problem1 {
	public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
		int count = 0;
		if (startTime.length > 0 && endTime.length > 0) {
			int length = startTime.length;
			for (int i = 0; i < length; i++) {
				int start = startTime[i], end = endTime[i];
				if (queryTime >= start && queryTime <= end)
					count++;
			}
		}

		return count;
	}
}
