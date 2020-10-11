package practice.graph.tardos.exercise.chapter3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class Problem3Tests {
	@Test
	public void testTopologicalOrder() {
		int n = 5;
		int[][] edges = new int[][] { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 4 }, { 3, 4 } };
		Stack<Integer> stack = new Stack<>();
		assertTrue(Problem3.topologicalOrder(n, edges, stack));

		n = 3;
		edges = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 } };
		stack.clear();
		assertFalse(Problem3.topologicalOrder(n, edges, stack));

		n = 3;
		edges = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 } };
		stack.clear();
		assertFalse(Problem3.topologicalOrder(n, edges, stack));

		n = 3;
		edges = new int[][] { { 0, 1 }, { 0, 2 }, { 2, 1 } };
		stack.clear();
		assertTrue(Problem3.topologicalOrder(n, edges, stack));
	}
}
