package heap;

/**
 * MinHeap Operations, all the methods take heap as input and perform a specific
 * operation on the heap.
 * 
 * @author rajan-c
 *
 * @param <T>
 */
public class MinHeapOperations<T extends Comparable<T>> {
	private void heapify(Heap<T> heap, int index) {
		int left = left(index), right = right(index);
		int minimum = index, heapSize = heap.getHeapsize();
		if (left < heapSize && heap.getItem(left).compareTo(heap.getItem(minimum)) < 0)
			minimum = left;
		if (right < heapSize && heap.getItem(right).compareTo(heap.getItem(minimum)) < 0)
			minimum = right;
		if (minimum != index) {
			swap(heap, minimum, index);
			heapify(heap, minimum);
		}
	}

	public boolean insert(Heap<T> heap, T item) {
		int heapSize = heap.getHeapsize();
		if (heapSize < heap.getCapacity()) {
			heap.insert(item);
			bubbleUp(heap, heap.getHeapsize() - 1);
			return true;
		} else
			return false;
	}

	/**
	 * Create a new Min Heap with the given items. It returns newly created heap.
	 * 
	 * @param items
	 * @return
	 */
	public Heap<T> makeHeap(T[] items) {
		Heap<T> heap = new Heap<>(items.length);
		for (T item : items)
			insert(heap, item);
		return heap;
	}

	private void bubbleUp(Heap<T> heap, int index) {
		if (index > 0) {
			int parent;
			while ((parent = parent(index)) >= 0 && heap.getItem(parent).compareTo(heap.getItem(index)) > 0) {
				swap(heap, index, parent);
				index = parent;
			}
		}
	}

	private void swap(Heap<T> heap, int i, int j) {
		int heapSize = heap.getHeapsize();
		if (i < heapSize && j < heapSize) {
			T temp = heap.getItem(i);
			heap.setItem(i, heap.getItem(j));
			heap.setItem(j, temp);
		}
	}

	public T extractMin(Heap<T> heap) {
		if (heap == null)
			throw new IllegalArgumentException("Ivalid heap: " + heap);
		int heapSize = heap.getHeapsize();
		if (heapSize > 0) {
			T min = heap.getItem(0);
			heap.setItem(0, heap.getItem(heapSize - 1));
			heap.setHeapsize(heapSize - 1);
			heapify(heap, 0);
			return min;
		} else
			throw new IllegalArgumentException("heap underflow!");
	}

	public boolean decreaseKey(Heap<T> heap, int index, T key) {
		if (heap == null || heap.getHeapsize() <= index || heap.getItem(index).compareTo(key) <= 0)
			return false;
		heap.setItem(index, key);
		bubbleUp(heap, index);
		return true;
	}

	private static int parent(double i) {
		return (int) (Math.ceil(i / 2) - 1);
	}

	private static int left(int i) {
		return ((i << 1) + 1);
	}

	private static int right(int i) {
		return (i << 1) + 2;
	}

	public void display(Heap<T> heap) {
		if (heap != null) {
			int heapSize = heap.getHeapsize();
			for (int i = 0; i < heapSize; i++)
				System.out.print(heap.getItem(i) + ", ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		MinHeapOperations<Integer> minHeapOperations = new MinHeapOperations<>();
		Heap<Integer> heap = minHeapOperations.makeHeap(new Integer[] { 8, 7, 6, 5, 4, 3, 2, 1 });
		minHeapOperations.display(heap);
		int heapSize = heap.getHeapsize();
		for (int i = 0; i < heapSize; i++)
			System.out.println("extracted: " + minHeapOperations.extractMin(heap));
		for (int i = 0; i < heapSize; i++)
			minHeapOperations.insert(heap, heapSize - i);
		minHeapOperations.display(heap);
		minHeapOperations.decreaseKey(heap, heapSize - 1, -1);
		minHeapOperations.display(heap);
	}
}
