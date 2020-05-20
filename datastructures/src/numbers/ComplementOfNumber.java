package numbers;

/**
 * Given a positive integer, output its complement number. The complement
 * strategy is to flip the bits of its binary representation.
 * 
 * @author rajan-c
 *
 */
public class ComplementOfNumber {
	public static int findComplement(int num) {
		int complement = 0, index = 0;
		while (num > 0) {
			if ((num & 1) == 0)
				complement += Math.pow(2, index++);
			else
				index++;
			num = num >> 1;
		}
		return complement;
	}

	public static void main(String[] args) {
		System.out.println(findComplement(5) + "," + Integer.MAX_VALUE + ", " + Integer.MIN_VALUE);
	}
}
