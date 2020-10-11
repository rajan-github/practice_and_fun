package weeklyChallenge.one_ninety_two;

/**
 * Given the array nums consisting of 2n elements in the form
 * [x1,x2,...,xn,y1,y2,...,yn].
 * 
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 * 
 * @author rajan-c
 *
 */
public class Problem1 {
	public int[] shuffle(int[] nums, int n) {
		int[] shuffled = new int[nums.length];
		int xIndex = 0, yIndex = n, index = 0;
		boolean isITxTurn = true;
		while (index < nums.length) {
			if (isITxTurn)
				shuffled[index++] = nums[xIndex++];
			else
				shuffled[index++] = nums[yIndex++];

			isITxTurn = !isITxTurn;
		}
		return shuffled;
	}
}
