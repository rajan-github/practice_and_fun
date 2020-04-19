package google_kickstart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * There are N houses for sale. The i-th house costs Ai dollars to buy. You have
 * a budget of B dollars to spend.
 * 
 * What is the maximum number of houses you can buy?
 * 
 * The first line of the input gives the number of test cases, T. T test cases
 * follow. Each test case begins with a single line containing the two integers
 * N and B. The second line contains N integers. The i-th integer is Ai, the
 * cost of the i-th house.
 * 
 * For each test case, output one line containing Case #x: y, where x is the
 * test case number (starting from 1) and y is the maximum number of houses you
 * can buy.
 * 
 * @author rajan-c
 *
 */
public class MaxHouse {

	private static void houseCount(int budget, int[] housePrices, int testCase) {
		Arrays.sort(housePrices);
		int count = 0, index = 0;
		while (index < housePrices.length && budget > 0) {
			if (housePrices[index] <= budget) {
				budget -= housePrices[index];
				count++;
			}
			index++;
		}
		System.out.printf("Case #%d: %d\n", testCase + 1, count);
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nexInt() {
			return Integer.parseInt(next());
		}

		long nexLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int testCount = fr.nexInt();
		for (int i = 0; i < testCount; i++) {
			int houseCount = fr.nexInt();
			int budget = fr.nexInt();
			int[] houseprices = new int[houseCount];
			for (int j = 0; j < houseCount; j++)
				houseprices[j] = fr.nexInt();
			houseCount(budget, houseprices, i);
		}
	}

	public static void display(int[] nums) {
		for (int item : nums)
			System.out.print(item + ", ");
		System.out.println();
	}

}
