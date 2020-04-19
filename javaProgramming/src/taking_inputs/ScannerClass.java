package taking_inputs;

import java.util.Scanner;

public class ScannerClass {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter the number: \n");
			int n = scanner.nextInt();
			while (n-- > 0) {
				int x = scanner.nextInt();
				System.out.println(x);
			}
		}
	}
}
