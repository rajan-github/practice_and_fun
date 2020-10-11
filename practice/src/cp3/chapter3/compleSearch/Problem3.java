package cp3.chapter3.compleSearch;

import java.util.Scanner;

public class Problem3 {
	public static long integerSequence(int[] coefficients, int k, int d) {
		long ans = 0;
		int n = 1;
		while (k > 0) {
			long an = computeA(coefficients, n);
			ans = an;
			if (n * d > k)
				break;
			k -= n * d;
			n++;
		}
		return ans;
	}

	private static long computeA(int[] coefficients, int n) {
		long lastPower = 1;
		long a = coefficients[0];
		for (int index = 1; index < coefficients.length; index++) {
			a += (lastPower * n) * coefficients[index];
			lastPower *= n;
		}

		return a;
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int testCases = scanner.nextInt();
			for (int test = 1; test <= testCases; test++) {
				int i = scanner.nextInt();
				int[] coefficients = new int[i + 1];
				for (int j = 0; j <= i; j++)
					coefficients[j] = scanner.nextInt();
				int d = scanner.nextInt();
				int k = scanner.nextInt();
				System.out.println(integerSequence(coefficients, k, d));
			}

		}
	}
}
