package practice.graph.spanningTree;

public class MinHeapOperations {

	public static <T extends Comparable<T>> void heapify(int index, Heap<T> heap) {
		int left = left(index), right = right(index);
		int minIndex = index;
		if (left < heap.getHeapSize() && heap.getDataAtIndex(left).compareTo(heap.getDataAtIndex(index)) < 0)
			minIndex = left;
		if (right < heap.getHeapSize() && heap.getDataAtIndex(right).compareTo(heap.getDataAtIndex(minIndex)) < 0)
			minIndex = right;
		if (minIndex != index) {
			swap(heap, minIndex, index);
			heapify(minIndex, heap);
		}
	}

	public static <T extends Comparable<T>> void bubbleUp(int index, Heap<T> heap) {
		int parent = parent(index);
		if (parent >= 0 && index < heap.getHeapSize()
				&& heap.getDataAtIndex(parent).compareTo(heap.getDataAtIndex(index)) > 0) {
			swap(heap, parent, index);
			bubbleUp(parent, heap);
		}
	}

	public static <T extends Comparable<T>> void insert(T data, Heap<T> heap) {
		if (heap.isFull())
			throw new IllegalStateException("Heap overflow!");
		heap.setDataAtIndex(heap.getHeapSize(), data);
		heap.setHeapSize(heap.getHeapSize() + 1);
		bubbleUp(heap.getHeapSize() - 1, heap);
	}

	public static <T extends Comparable<T>> Heap<T> makeHeap(T[] data) {
		Heap<T> heap = new Heap<>(data.length);
		for (T item : data)
			insert(item, heap);
		return heap;
	}

	public static <T extends Comparable<T>> void swap(Heap<T> heap, int i, int j) {
		T temp = heap.getDataAtIndex(i);
		heap.setDataAtIndex(i, heap.getDataAtIndex(j));
		heap.setDataAtIndex(j, temp);
	}

	public static <T extends Comparable<T>> void decreaseKey(Heap<T> heap, int index, T newKey) {
		if (index < 0 || index >= heap.getHeapSize() || heap.getDataAtIndex(index).compareTo(newKey) < 0)
			throw new IllegalArgumentException("Invalid argument!");
		heap.setDataAtIndex(index, newKey);
		bubbleUp(index, heap);
	}

	public static <T extends Comparable<T>> T extractMin(Heap<T> heap) {
		if (heap.isEmpty())
			throw new IllegalStateException("Heap underflow!");
		T extractedData = heap.getDataAtIndex(0);
		swap(heap, 0, heap.getHeapSize() - 1);
		heap.setHeapSize(heap.getHeapSize() - 1);
		heapify(0, heap);
		return extractedData;
	}

	public static int parent(double index) {
		return (int) Math.ceil(index / 2) - 1;
	}

	public static int left(int index) {
		return (index << 1) + 1;
	}

	public static int right(int index) {
		return (index >> 1) + 2;
	}

	public static void main(String[] args) {
		Heap<Integer> heap = makeHeap(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
		while (!heap.isEmpty())
			System.out.println(extractMin(heap));

		insert(1, heap);
		insert(3, heap);
		insert(5, heap);
		decreaseKey(heap, 0, -1);

		while (!heap.isEmpty())
			System.out.println(extractMin(heap));
	}
}
