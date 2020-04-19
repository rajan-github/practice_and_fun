package search;

/**
 * Find the missing number in given array.
 * 
 * @author rajan-c
 *
 */
public class MissingNumber {

	public static int missingNumber(int[] array) {
		if (array.length > 0) {
			int sum = (array[array.length - 1] * (array[array.length - 1] + 1)) / 2;
			int temp = 0;
			for (int i = 0; i < array.length; i++)
				temp += array[i];
			return sum - temp;
		}

		throw new IllegalArgumentException();
	}

	public static void main(String[] args) {
		System.out.println(missingNumber(new int[] { 1, 2, 4, 6, 3, 7, 8 }));
	}
}
