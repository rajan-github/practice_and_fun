package taking_inputs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReadWithHelpOfBufferedReader {

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
//			int budget = fr.nexInt();
			int[] houseprices = new int[houseCount];
			for (int j = 0; j < houseCount; j++)
				houseprices[j] = fr.nexInt();
			display(houseprices);
		}
	}

	public static void display(int[] nums) {
		for (int item : nums)
			System.out.print(item + ", ");
		System.out.println();
	}
}
