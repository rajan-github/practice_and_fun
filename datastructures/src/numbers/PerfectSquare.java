package numbers;

public class PerfectSquare {
	public static boolean isPerfectSquare(int num) {
		long number = num, square = 1, sqrt = 1;
		while (square < number) {
			if (sqrt * 2 * 2 * sqrt < number)
				sqrt = 2 * sqrt;
			else if (sqrt * 4 * 4 * sqrt < number)
				sqrt = 4 * sqrt;
			else
				sqrt += 1;
			square = sqrt * sqrt;
		}
		return square == number;
	}

	public static void main(String[] args) {
		System.out.println(isPerfectSquare(25));
		System.out.println(isPerfectSquare(25));
		System.out.println(isPerfectSquare(10000000));
		System.out.println(isPerfectSquare(1000 * 1000));
		System.out.println(isPerfectSquare(Integer.MAX_VALUE));
	}
}
