package algorithms;

import java.util.Scanner;

public class FizzBuzzSum {
	private static long fizzbuzzSum(int number) {
		long sum = 0;
		for (int i = 1; i <= number; i++) {
			if (i % 3 != 0 && i % 5 != 0)
				sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(fizzbuzzSum(scanner.nextInt()));
		}
	}
}
