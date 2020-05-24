package skiena.sorting.exercises;

import java.util.Arrays;

/**
 * The Grinch is given the job of partitioning 2n players into two teams of n
 * players each. Each player has a numerical rating that measures how good
 * he/she is at the game. He seeks to divide the players as unfairly as
 * possible, so as to create the biggest possible talent imbalance between team
 * A and team B. Show how the Grinch can do the job in O(nlogn) time.
 * 
 * @author rajan-c
 *
 */
public class Problem1 {

	/**
	 * It returns the index after partition. Right to the returned index are higher
	 * rating players.
	 * 
	 * @param ratings
	 * @return
	 */
	public int imbalancedPartition(int[] ratings) {
		Arrays.sort(ratings);
		return ratings.length / 2;
	}

}
