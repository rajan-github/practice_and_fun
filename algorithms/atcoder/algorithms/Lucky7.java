package algorithms;

import java.util.Scanner;

public class Lucky7 {
	public static boolean havedigit7(int number) {
		boolean have7 = false;
		while (number > 0 && !have7)
			if (number % 10 == 7)
				have7 = true;
			else
				number /= 10;
		return have7;
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println(havedigit7(scanner.nextInt()) ? "Yes" : "No");
		}
	}
}
