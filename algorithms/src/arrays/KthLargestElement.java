package arrays;

public class KthLargestElement {

	public int findKthLargest(int[] nums, int k) {
		MaxHeapOperations heapOperations = new MaxHeapOperations();
		MaxHeap maxHeap = heapOperations.makeHeap(nums);
		for (int i = 1; i < k; i++)
			heapOperations.extractMax(maxHeap);
		return heapOperations.extractMax(maxHeap);
	}

	public static void main(String[] args) {
		System.out.println();
		System.out.println();
	}
}

class MaxHeap {
	int[] data;

	// as index in data.
	int heapsize;

	public MaxHeap(int capacity) {
		data = new int[capacity];
		heapsize = 0;
	}
}

class MaxHeapOperations {
	public MaxHeap makeHeap(int[] data) {
		MaxHeap heap = new MaxHeap(data.length);
		for (int item : data) {
			heap.data[heap.heapsize++] = item;
			bubbleup(heap, heap.heapsize - 1);
		}
		return heap;
	}

	private void bubbleup(MaxHeap heap, int index) {
		if (index > 0) {
			int parent = parent(index);
			if (heap.data[index] > heap.data[parent]) {
				int temp = heap.data[parent];
				heap.data[parent] = heap.data[index];
				heap.data[index] = temp;
				bubbleup(heap, parent);
			}
		}
	}

	public int extractMax(MaxHeap heap) {
		int heapsize = heap.heapsize;
		int leafItem = heap.data[heapsize - 1];
		int maxItem = heap.data[0];
		heap.data[0] = leafItem;
		heap.heapsize = heapsize - 1;
		heapify(heap, 0);
		return maxItem;
	}

	private void heapify(MaxHeap heap, int index) {
		if (index < heap.heapsize) {
			int largest = index;
			int left = left(index);
			if (left < heap.heapsize && heap.data[left] > heap.data[largest])
				largest = left;
			int right = right(index);
			if (right < heap.heapsize && heap.data[right] > heap.data[largest])
				largest = right;
			if (largest != index) {
				int temp = heap.data[index];
				heap.data[index] = heap.data[largest];
				heap.data[largest] = temp;
				heapify(heap, largest);
			}
		}
	}

	private int left(int index) {
		return (index << 1) + 1;
	}

	private int right(int index) {
		return (index << 1) + 2;
	}

	private int parent(double index) {
		return (int) Math.ceil(index / 2) - 1;
	}
}
