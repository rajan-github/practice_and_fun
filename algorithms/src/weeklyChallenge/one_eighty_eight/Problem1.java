package weeklyChallenge.one_eighty_eight;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array target and an integer n. In each iteration, you will read a
 * number from list = {1,2,3..., n}.
 * 
 * Build the target array using the following operations:
 * 
 * Push: Read a new element from the beginning list, and push it in the array.
 * Pop: delete the last element of the array. If the target array is already
 * built, stop reading more elements. You are guaranteed that the target array
 * is strictly increasing, only containing numbers between 1 to n inclusive.
 * 
 * Return the operations to build the target array.
 * 
 * You are guaranteed that the answer is unique.
 * 
 * @author rajan-c
 *
 */
public class Problem1 {

	public static List<String> buildArray(int[] target, int n) {
		List<String> ops = new ArrayList<>();
		if (n > 0 && target.length > 0) {
			int currentNumber = 1, i = 0;
			for (currentNumber = 1; currentNumber <= target[target.length - 1];) {
				if (target[i] == currentNumber) {
					ops.add("Push");
					i++;
				} else {
					ops.add("Push");
					ops.add("Pop");
				}
				currentNumber++;
			}
		}
		return ops;
	}

	public static void main(String[] args) {
		System.out.println(buildArray(new int[] { 2,3,4 }, 3));
	}

}
