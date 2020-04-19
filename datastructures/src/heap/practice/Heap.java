package heap.practice;

/**
 * This is a heap implementation.
 * 
 * @author rajan-c
 *
 */
public class Heap {
	private int[] data;
	private int size;

	public Heap(int[] data) {
		super();
		this.data = data;
		this.size = data.length;
		buildHeap();
	}

	private void buildHeap() {
		int n = size / 2;
		while (n >= 0)
			heapify(n--);
	}

	public void heapify(int i) {
		if (i < size) {
			int leftChild = leftChild(i);
			int largest = i;
			if (leftChild < size && data[leftChild] > data[largest])
				largest = leftChild;
			int rightChild = rightChild(i);
			if (rightChild < size && data[rightChild] > data[largest])
				largest = rightChild;
			if (largest != i) {
				swap(largest, i);
				heapify(largest);
			}

		}
	}

	public int getSize() {
		return this.size;
	}

	public int extractMax() {
		int max = this.data[0];
		swap(0, size - 1);
		size--;
		heapify(0);
		return max;
	}

	public void insert(int key) {
		this.data[size] = Integer.MIN_VALUE;
		increaseKey(size, key);
		size++;
	}

	public void increaseKey(int index, int key) {
		if (index < data.length && data[index] < key) {
			data[index] = key;
			while (index > 0 && data[parent(index)] < data[index]) {
				swap(parent(index), index);
				index = parent(index);
			}
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void swap(int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public int parent(int i) {
		return (int) (Math.ceil((i * 1.0) / 2.0) - 1);
	}

	public int leftChild(int i) {
		return 2 * i + 1;
	}

	public int rightChild(int i) {
		return 2 * i + 2;
	}

	private void display() {
		System.out.print("[");
		for (int index = 0; index < size; index++)
			System.out.print(data[index] + ", ");
		System.out.println("]");
	}

	public static void main(String[] args) throws Exception {
		Heap heap = new Heap(new int[] { 1, 2, 3, 4, 5 });
		heap.display();
		System.out.println(heap.extractMax());
		heap.display();
		System.out.println(heap.extractMax());
		heap.display();
		System.out.println(heap.extractMax());
		heap.display();
		System.out.println(heap.extractMax());
		heap.display();
		System.out.println(heap.extractMax());
		heap.display();
		heap.insert(1);
		heap.display();
	}

}
