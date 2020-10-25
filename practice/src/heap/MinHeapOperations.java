package heap;

public class MinHeapOperations<T extends Comparable<T>> {
	public static <T extends Comparable<T>> Heap<T> makeHeap(T[] data, int capacity) {
		if (capacity < data.length)
			throw new IllegalArgumentException("Capacity should be at least data size.");
		Heap<T> heap = new Heap<>(capacity);
		heap.setHeapSize(data.length);
		int n = heap.getHeapSize();
		for (int i = 0; i < n; i++)
			heap.setItem(i, data[i]);
		for (int i = n / 2; i >= 0; i--)
			heapify(heap, i);
		return heap;
	}

	public static <T extends Comparable<T>> T min(Heap<T> heap) {
		if (heap.isEmpty())
			throw new IllegalStateException("Heap underflow");
		return heap.getItem(0);
	}

	public static <T extends Comparable<T>> T extractMin(Heap<T> heap) {
		if (heap.isEmpty())
			throw new IllegalStateException("Heap underflow");
		T min = heap.getItem(0);
		int n = heap.getHeapSize() - 1;
		heap.setItem(0, heap.getItem(n));
		heapify(heap, 0);
		return min;
	}

	public static <T extends Comparable<T>> void decreaseKey(Heap<T> heap, T item, T newItem) {
		if (newItem.compareTo(item) >= 0)
			throw new IllegalArgumentException("NewItem should be smaller than item.");
		int index = heap.getIndexOfItem(item);
		heap.setItem(index, newItem);
		bubbleUp(heap, index);
	}

	public static <T extends Comparable<T>> void bubbleUp(Heap<T> heap, int index) {
		int parent = parent(index);
		if (parent >= 0 && heap.getItem(parent).compareTo(heap.getItem(index)) > 0) {
			T temp = heap.getItem(parent);
			heap.setItem(parent, heap.getItem(index));
			heap.setItem(index, temp);
			bubbleUp(heap, parent);
		}
	}

	public static <T extends Comparable<T>> void heapify(Heap<T> heap, int i) {
		int n = heap.getHeapSize();
		int left = left(i);
		int largest = i;
		if (left < n && heap.getItem(left).compareTo(heap.getItem(i)) < 0)
			largest = left;
		int right = right(i);
		if (right < n && heap.getItem(right).compareTo(heap.getItem(largest)) < 0)
			largest = right;

		if (largest != i) {
			T temp = heap.getItem(largest);
			heap.setItem(largest, heap.getItem(i));
			heap.setItem(i, temp);
			heapify(heap, largest);
		}
	}

	private static int parent(double index) {
		return (int) (Math.ceil(index / 2) - 1);
	}

	private static int left(int index) {
		return (index << 1) + 1;
	}

	private static int right(int index) {
		return (index << 1) + 2;
	}

	public static void main(String[] args) {
		Heap<Integer> minHeap = MinHeapOperations.makeHeap(new Integer[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 }, 9);
		System.out.println(minHeap);
		MinHeapOperations.decreaseKey(minHeap, 9, -1);
		System.out.println(minHeap);
	}
}
