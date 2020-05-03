package algorithms;

import java.util.Scanner;

public class SumOfGCDTuples {

	private static long sumOfgcdTuples(int k) {
		long sum = 0;
		for (int a = 1; a <= k; a++) {
			for (int b = 1; b <= k; b++) {
				for (int c = 1; c <= k; c++)
					sum += gcd(a, b, c);
			}
		}
		return sum;
	}

	private static int gcd(int a, int b, int c) {
		return gcd(a, gcd(b, c));
	}

	private static int gcd(int a, int b) {
		if (a == 1 || b == 1)
			return 1;
		else if (a % b == 0)
			return b;
		else
			return gcd(b, a % b);
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(sumOfgcdTuples(scanner.nextInt()));
		}
	}

}
