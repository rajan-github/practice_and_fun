package heap;

public class MaxHeapOperations {
	public static Heap insert(Heap heap, int item) {
		if (heap.getHeapSize() < heap.getCapacity()) {
			heap.insert(Integer.MIN_VALUE);
			heap = increaseKey(heap, heap.getHeapSize() - 1, item);
			return heap;
		} else
			throw new IllegalStateException("Heap overflow!");
	}

	public static Heap buildHeap(int[] data) {
		if (data != null) {
			int index = (data.length / 2);
			Heap heap = new Heap(data.length, data.length, data);
			while (index >= 0) {
				heap = heapify(heap, index);
				index--;
			}
			return heap;
		}
		throw new IllegalArgumentException("Invalid data passed!");
	}

	public static Heap increaseKey(Heap heap, int index, int key) {
		if (index >= heap.getHeapSize())
			throw new IllegalArgumentException("Index is overflowing!");
		if (key < heap.get(index))
			throw new IllegalArgumentException("Key is less than existing value!");
		heap.set(key, index);
		while (index > 0 && heap.get(index) > heap.get(parent(index))) {
			int parent = parent(index);
			int temp = heap.get(parent);
			heap.set(heap.get(index), parent);
			heap.set(temp, index);
			index = parent;
		}
		return heap;
	}

	public static Heap heapify(Heap heap, int i) {
		if (i >= heap.getHeapSize())
			return heap;
		int largest = i;
		if (left(i) < heap.getHeapSize() && heap.get(left(i)) > heap.get(i))
			largest = left(i);
		if (right(i) < heap.getHeapSize() && heap.get(right(i)) > heap.get(largest))
			largest = right(i);
		if (largest != i) {
			int temp = heap.get(i);
			heap.set(heap.get(largest), i);
			heap.set(temp, largest);
			heap = heapify(heap, largest);
		}
		return heap;
	}

	private static int parent(int i) throws IllegalArgumentException {
		if (i > 0) {
			if ((i & 1) == 1) {
				return ((i + 1) / 2) - 1;
			}
			return (i / 2) - 1;
		}
		throw new IllegalArgumentException("Invalid value of i: " + i);
	}

	private static int left(int i) {
		return 2 * i + 1;
	}

	private static int right(int i) {
		return 2 * i + 2;
	}

	public int getMax(Heap heap) {
		if (heap.getHeapSize() <= 0)
			throw new IllegalStateException("Heap underflow!");
		return heap.get(0);
	}

	public static int extractMax(Heap heap) {
		if (heap.getHeapSize() <= 0)
			throw new IllegalStateException("Heap underflow!");
		int temp = heap.get(0);
		heap.set(heap.get(heap.getHeapSize() - 1), 0);
		heap.setHeapSize(heap.getHeapSize() - 1);
		heap = heapify(heap, 0);
		return temp;
	}

	public static void main(String[] args) {
		Heap heap = new Heap(7);
		heap.insert(4);
		heap.insert(1);
		heap.insert(2);
		System.out.println(extractMax(heap));
		System.out.println(extractMax(heap));
		System.out.println(extractMax(heap));
//		System.out.println(extractMax(heap));
//		heap.display();
	}
}
