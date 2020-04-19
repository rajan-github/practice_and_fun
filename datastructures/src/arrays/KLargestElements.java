package arrays;

import heap.Heap;
import heap.MaxHeapOperations;

public class KLargestElements {
	public static void kLargest(int[] array, int k) {
		if (array != null && array.length > 0 && array.length >= k) {
			Heap heap = MaxHeapOperations.buildHeap(array);
			while (k-- > 0)
				System.out.println(MaxHeapOperations.extractMax(heap));
		}
	}

	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		kLargest(data, 4);
	}
}
