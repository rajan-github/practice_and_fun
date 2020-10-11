package java8Features.lambda;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxHeap {
	public static void main(String[] args) {
		double[] weights = new double[] { 0.37, 0.17, 0.93, 0.23, 0.39, 0.04 };
		Arrays.fill(weights, Integer.MIN_VALUE);
		weights[3] = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((v1, v2) -> Double.compare(weights[v2], weights[v1]));
		for (int i = 0; i < 5; i++)
			queue.add(i);
		while (!queue.isEmpty())
			System.out.println(queue.remove());
	}
}
