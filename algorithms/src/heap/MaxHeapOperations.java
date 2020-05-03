package heap;

/**
 * This class implements the max-heap operations.
 * 
 * @author rajan-c
 *
 */
public class MaxHeapOperations<T extends Comparable<T>> {

	public void insert(Heap<T> heap, T item) {
		if (heap == null)
			throw new IllegalArgumentException("Invalid argument: " + heap);
		else if (heap.getHeapsize() >= heap.getCapacity()) {
			System.out.println("Heap overflow!");
			throw new IllegalStateException("Heap overflow!");
		} else {
			heap.insert(item);
			bubbleup(heap, heap.getHeapsize() - 1);
		}
	}

	public void makeHeap(Heap<T> heap, T[] items) {
		if (heap == null || (heap.getCapacity() - heap.getHeapsize()) < items.length)
			throw new IllegalArgumentException("Ivalid parameters!");
		for (T item : items)
			insert(heap, item);
	}

	private void bubbleup(Heap<T> heap, int index) {
		int parent = parent(index);
		if (heap != null && parent >= 0 && heap.getItem(index).compareTo(heap.getItem(parent)) > 0) {
			T temp = heap.getItem(index);
			heap.setItem(index, heap.getItem(parent));
			heap.setItem(parent, temp);
			bubbleup(heap, parent);
		}
	}

	public T extractMax(Heap<T> heap) {
		if (heap == null || heap.isEmpty())
			throw new IllegalArgumentException("Invalid heap: " + heap);

		T max = heap.getItem(0);

		heap.setItem(0, heap.getItem(heap.getHeapsize() - 1));
		heap.setHeapsize(heap.getHeapsize() - 1);
		heapify(heap, 0);
		return max;
	}

	public void heapify(Heap<T> heap, int index) {
		if (heap == null || index >= heap.getHeapsize())
			return;
		int largest = index;
		int left = left(index), right = right(index);
		if (left < heap.getHeapsize() && heap.getItem(left).compareTo(heap.getItem(largest)) > 0)
			largest = left;
		if (right < heap.getHeapsize() && heap.getItem(right).compareTo(heap.getItem(largest)) > 0)
			largest = right;
		if (largest != index) {
			T temp = heap.getItem(largest);
			heap.setItem(largest, heap.getItem(index));
			heap.setItem(index, temp);
			heapify(heap, largest);
		}
	}

	private static int parent(int index) {
		double i = index;
		if (index > 0) {
			return (int) (Math.ceil(i / 2)) - 1;
		}
		return -1;
	}

	private static int left(int index) {
		return (index << 1) + 1;
	}

	private static int right(int index) {
		return (index << 1) + 2;
	}

	public void display(Heap<T> heap) {
		if (heap != null) {
			int heapsize = heap.getHeapsize();
			for (int i = 0; i < heapsize; i++)
				System.out.print(heap.getItem(i) + ", ");
			System.out.println();
		} else
			throw new IllegalArgumentException("Invalid argument: " + heap);
	}

	public static void main(String[] args) {
		Heap<Integer> heap = new Heap<>(10);
		MaxHeapOperations<Integer> operations = new MaxHeapOperations<>();
		operations.insert(heap, 1);
		operations.insert(heap, 2);
		operations.insert(heap, 3);
		operations.insert(heap, 4);
		operations.insert(heap, 12);
		operations.display(heap);

		System.out.println(operations.extractMax(heap));
		operations.display(heap);

		System.out.println(operations.extractMax(heap));
		operations.display(heap);

		System.out.println(operations.extractMax(heap));
		operations.display(heap);
		System.out.println(operations.extractMax(heap));
		operations.display(heap);

		System.out.println(operations.extractMax(heap));
		operations.display(heap);
		
		System.out.println(operations.extractMax(heap));
		operations.display(heap);

	}
}
