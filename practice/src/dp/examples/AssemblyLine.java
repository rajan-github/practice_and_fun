package dp.examples;

import java.util.Arrays;

public class AssemblyLine {
	public static int shortestTime(int[][] a, int[][] t, int[] e, int[] x) {
		int stages = a[0].length;
		int[][] dp = new int[2][stages + 2];

		dp[0][stages + 1] = x[0];
		dp[1][stages + 1] = x[1];

		dp[0][0] = e[0];
		dp[1][0] = e[1];

		for (int j = stages; j > 0; j--) {
			for (int i = 0; i < 2; i++) {
				dp[i][j] += Math.min(dp[i][j + 1] + a[i][j - 1], dp[1 - i][j + 1] + a[i][j - 1] + t[i][j - 1]);
			}

		}

		System.out.println(Arrays.toString(dp[0]));
		System.out.println(Arrays.toString(dp[1]));

		return Math.min(dp[0][0] + dp[0][1], dp[1][0] + dp[1][1]);
	}

	public static int carAssembleTime(int a[][], int t[][], int e[], int x[]) {
		int n = a[0].length;

// time taken to leave first station in line 1   
		int first = e[0] + a[0][0];

// time taken to leave first station in line 2 
		int second = e[1] + a[1][0];

		for (int i = 1; i < n; i++) {
			int up = Math.min(first + a[0][i], second + t[1][i] + a[0][i]),
					down = Math.min(second + a[1][i], first + t[0][i] + a[1][i]);
			first = up;
			second = down;
		}

		first += x[0];
		second += x[1];

		
		return Math.min(first, second);
	}

	public static void main(String[] args) {
		int[][] a = { { 4, 5, 3, 2 }, { 2, 10, 1, 4 } };
		int[][] t = { { 0, 7, 4, 5 }, { 0, 9, 2, 8 } };
		int[] e = { 10, 12 };
		int[] x = { 18, 7 };
		System.out.println(shortestTime(a, t, e, x));
		System.out.println(carAssembleTime(a, t, e, x));
	}

}
