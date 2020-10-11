package arrays;

/**
 * We have a list of points on the plane. Find the K closest points to the
 * origin (0, 0).
 * 
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * 
 * You may return the answer in any order. The answer is guaranteed to be unique
 * (except for the order that it is in.)
 * 
 * @author rajan-c
 *
 */
public class KClosestPointsToOrigin {
	public int[][] kClosest(int[][] points, int K) {
		int pointCount = points.length;
		PointDistance[] distances = new PointDistance[pointCount];

		for (int i = 0; i < pointCount; i++) {
			int x = points[i][0], y = points[i][1];
			distances[i] = new PointDistance(i, (x * x + y * y));
		}

		HeapOperations heapOperations = new HeapOperations();
		Heap heap = new Heap(pointCount);
		heapOperations.makeHeap(heap, distances);

		int[][] closestPairs = new int[K][2];
		for (int i = 0; i < K; i++) {
			int index = heapOperations.extractMin(heap).index;
			closestPairs[i] = points[index];
		}
		return closestPairs;
	}

	public static void main(String[] args) {
		int[][] pairs = new int[][] { { 1, 3 }, { -2, 2 } };
		int[][] closest = new KClosestPointsToOrigin().kClosest(pairs, 1);
		System.out.println(closest[0][0] + ", " + closest[0][1]);
	}
}

class Heap {
	PointDistance[] data;
	int size;

	public Heap(int capacity) {
		data = new PointDistance[capacity];
		size = 0;
	}
}

class HeapOperations {
	int parent(double index) {
		return (int) Math.ceil(index / 2) - 1;
	}

	int left(int index) {
		return (index << 1) + 1;
	}

	int right(int index) {
		return (index << 1) + 2;
	}

	private void swap(PointDistance[] data, int i, int j) {
		PointDistance temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public void makeHeap(Heap heap, PointDistance[] items) {
		for (PointDistance item : items)
			insert(item, heap);
	}

	private void insert(PointDistance item, Heap heap) {
		heap.data[heap.size] = item;
		heap.size += 1;
		bubbleUp(heap.size - 1, heap);
	}

	private void bubbleUp(int index, Heap heap) {
		while (index > 0) {
			int parent = parent(index);
			if (heap.data[parent].compareTo(heap.data[index]) > 0) {
				swap(heap.data, index, parent);
				index = parent;
			} else
				return;
		}
	}

	public PointDistance extractMin(Heap heap) {
		PointDistance distance = heap.data[0];
		heap.data[0] = heap.data[heap.size - 1];
		heap.size -= 1;
		heapify(0, heap);
		return distance;
	}

	private void heapify(int index, Heap heap) {
		while (index < heap.size) {
			int left = left(index), right = right(index);
			int smallest = index;
			if (left < heap.size && heap.data[smallest].compareTo(heap.data[left]) > 0)
				smallest = left;
			if (right < heap.size && heap.data[smallest].compareTo(heap.data[right]) > 0)
				smallest = right;
			if (smallest != index) {
				swap(heap.data, smallest, index);
				index = smallest;
			} else
				return;
		}
	}
}

class PointDistance implements Comparable<PointDistance> {
	int index;
	Integer distance;

	public PointDistance(int index, Integer distance) {
		this.index = index;
		this.distance = distance;
	}

	@Override
	public int compareTo(PointDistance arg0) {
		return distance.compareTo(arg0.distance);
	}
}
