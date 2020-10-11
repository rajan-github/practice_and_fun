package practice.graph.tardos.exercise.chapter3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Problem4Tests {
	@Test
	public void testCanpartition() {
		assertFalse(Problem4.isBipertite(3, new int[][] { { 0, 1 }, { 0, 2 }, { 2, 1 } }));
		assertTrue(Problem4.isBipertite(4, new int[][] { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 3, 1 } }));
		assertFalse(Problem4.isBipertite(4, new int[][] { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 3 }, { 3, 1 } }));
		assertTrue(Problem4.isBipertite(4, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 } }));
		assertTrue(Problem4.isBipertite(4, new int[][] {}));
	}
}
