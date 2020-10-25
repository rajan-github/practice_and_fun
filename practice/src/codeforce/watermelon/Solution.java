

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int weight = scanner.nextInt();
			for (int i = 1; i < weight; i++)
				if ((i & 1) == 0 && ((weight - i) & 1) == 0) {
					System.out.println("YES");
					return;
				}

		}
		System.out.println("NO");
	}
}
