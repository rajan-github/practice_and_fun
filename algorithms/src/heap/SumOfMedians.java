package heap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Stream of number is feed from 1 to n. After reading each number compute the
 * median. For example compute median m1 after reading first number, compute
 * median m2 after second number and after reading nth number compute mn. Time
 * complexity should not exceed O(log(i)) where i is the ith number read.
 * 
 * @author rajan-c
 *
 */
public class SumOfMedians {
	private int sumOfMedians;
	private int sumOfMedianBrute;
	private PriorityQueue<Integer> queueLow;
	private PriorityQueue<Integer> queueHigh;
	private List<Integer> numbers;

	public SumOfMedians() {
		queueLow = new PriorityQueue<>((Integer x, Integer y) -> Integer.compare(y, x));
		queueHigh = new PriorityQueue<>();
		sumOfMedians = 0;
		sumOfMedianBrute = 0;
		numbers = new ArrayList<>();
	}

	public void updateMedianSum(int number) {
		if (number == 5147)
			System.out.println("");
		if (queueLow.isEmpty() || number < queueLow.peek()) {
			queueLow.add(number);
			if (queueLow.size() > queueHigh.size() + 1)
				queueHigh.add(queueLow.remove());
		} else {
			queueHigh.add(number);
			if (queueLow.size() < queueHigh.size()) {
				int temp = queueHigh.remove();
				queueLow.add(temp);
			}
		}

		int median = ((queueLow.size() >= queueHigh.size() || queueHigh.isEmpty()) ? queueLow.peek()
				: queueHigh.peek());

		sumOfMedians += median;
	}

	public void updateMedianSumBrute(int number) {
		numbers.add(number);
		Collections.sort(numbers);
		int median = ((numbers.size() & 1) == 0) ? numbers.get((numbers.size() / 2) - 1)
				: numbers.get(((numbers.size() + 1) / 2) - 1);
		sumOfMedianBrute += median;
	}

	public static void main(String[] args) throws IOException {
		SumOfMedians medianSum = new SumOfMedians();
		Path path = Paths.get(Paths.get("").toAbsolutePath() + "\\src\\heap\\Median.txt");
		List<String> lines = Files.readAllLines(path);
		for (String line : lines) {
			int num = Integer.parseInt(line);
			medianSum.updateMedianSum(num);
			medianSum.updateMedianSumBrute(num);
		}

		System.out.println(medianSum.sumOfMedians % 10000 + ",    " + medianSum.sumOfMedianBrute % 10000);
	}
}
