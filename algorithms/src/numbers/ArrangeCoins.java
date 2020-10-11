package numbers;

/**
 * Arrange n coins in rows. Each row has 1 more coin than the previous row.
 * Return how many rows can be successfully completed.
 * 
 * @author rajan-c
 *
 */
public class ArrangeCoins {
	public static int arrangeCoins(int n) {
		long number = n;
		long temp = number * 2;
		int stairs = (int) (Math.sqrt(1 + (4 * temp)) - 1) / 2;
		return stairs;
	}

	public static void main(String[] args) {
		System.out.println(arrangeCoins(1804289383));
	}
}
