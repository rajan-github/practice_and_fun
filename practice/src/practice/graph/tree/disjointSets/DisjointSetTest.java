package practice.graph.tree.disjointSets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DisjointSetTest {

	@Test
	public void testMakeSet() {
		DisjointSet disjointSet = new DisjointSet();
		Node node1 = disjointSet.makeSet(1);
		Node node2 = disjointSet.makeSet(2);
		Node node3 = disjointSet.makeSet(3);
		Node node4 = disjointSet.makeSet(4);
		Node node5 = disjointSet.makeSet(-1);
		assertTrue(node1 != null);
		assertTrue(node1.parent == node1);
		assertTrue(node1.data == 1);
		assertTrue(node2 != null);
		assertTrue(node2.parent == node2);
		assertTrue(node2.data == 2);
		assertTrue(node3 != null);
		assertTrue(node3.parent == node3);
		assertTrue(node3.data == 3);
		assertTrue(node4 != null);
		assertTrue(node4.parent == node4);
		assertTrue(node4.data == 4);
		assertTrue(node5 != null);
		assertTrue(node5.parent == node5);
		assertTrue(node5.data == -1);
	}

	@Test
	public void testFindSet() {
		DisjointSet disjointSet = new DisjointSet();
		disjointSet.makeSet(1);
		disjointSet.makeSet(2);
		disjointSet.makeSet(3);
		disjointSet.makeSet(4);
		disjointSet.makeSet(-1);
		assertTrue(disjointSet.findSet(1) == disjointSet.findSet(1));
		assertTrue(disjointSet.findSet(2) == disjointSet.findSet(2));
		assertFalse(disjointSet.findSet(1) == disjointSet.findSet(3));
		assertTrue(disjointSet.findSet(4) == disjointSet.findSet(4));
		assertFalse(disjointSet.findSet(1) == disjointSet.findSet(-1));
		disjointSet.union(1, 2);
		assertTrue(disjointSet.findSet(1) == disjointSet.findSet(2));

		disjointSet.union(3, 4);
		assertTrue(disjointSet.findSet(3) == disjointSet.findSet(4));
		assertTrue(disjointSet.findSet(1) != disjointSet.findSet(4));

		disjointSet.union(1, -1);
		assertTrue(disjointSet.findSet(3) == disjointSet.findSet(4));
		assertTrue(disjointSet.findSet(1) == disjointSet.findSet(-1));

		disjointSet.union(1, 4);
		assertTrue(disjointSet.findSet(3) == disjointSet.findSet(4));
		assertTrue(disjointSet.findSet(1) == disjointSet.findSet(4));
		assertTrue(disjointSet.findSet(1) == disjointSet.findSet(3));
		assertTrue(disjointSet.findSet(1) == disjointSet.findSet(-1));
	}

}
