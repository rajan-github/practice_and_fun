package cp3.chapter3.compleSearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem4 {
	public static void expertEnough(Map<String, int[]> rangeMap, int price) {
		String found = null;
		int count = 0;
		for (Map.Entry<String, int[]> entry : rangeMap.entrySet()) {
			int[] range = entry.getValue();
			if (range[0] <= price && range[1] <= price) {
				found = entry.getKey();
				count++;
			}
		}
		if (found == null || count > 1)
			System.out.println("UNDETERMINED");
		else
			System.out.println(found);
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int tests = scanner.nextInt();
			for (int test = 1; test <= tests; test++) {
				Map<String, int[]> rangeMap = new HashMap<>();
				int companies = scanner.nextInt();
				for (int company = 1; company <= companies; company++) {
					String line = scanner.next(".*");
					String[] tokens = line.split(" ");
					System.out.println(Arrays.toString(tokens));
					rangeMap.put(tokens[0], new int[] { Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]) });
				}
				int queries = scanner.nextInt();
				for (int query = 1; query <= queries; query++)
					expertEnough(rangeMap, scanner.nextInt());
			}
		}
	}
}
