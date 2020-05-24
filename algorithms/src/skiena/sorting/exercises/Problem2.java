package skiena.sorting.exercises;

/**
 * For each of the following problems, give an algorithm that finds the desired
 * numbers within the given amount of time. To keep your answers brief, feel
 * free to use algorithms from the book as subroutines. For the example, S =
 * {6,13,19,3,8}, 19 − 3 maximizes the difference, while 8 − 6 minimizes the
 * difference.
 * 
 * @author rajan-c
 *
 */
public class Problem2 {

	/**
	 * Array is unsorted and we need to maximize |x-y|.
	 * 
	 * @param array
	 * @return
	 */
	public int maximizeDifference(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		int maximum = Integer.MIN_VALUE, minimum = Integer.MAX_VALUE;
		for (int item : array) {
			if (item > maximum)
				maximum = item;
			else if (item < minimum)
				minimum = item;
		}
		return Math.abs(maximum - minimum);
	}

	public static void main(String[] args) {

	}

}
