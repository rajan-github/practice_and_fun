package heap;

public class Heap {
	private int capacity;
	private int heapSize;
	private int[] data;

	public Heap(int length) {
		super();
		this.capacity = length;
		data = new int[length];
		this.heapSize = 0;
	}

	public Heap(int length, int heapSize, int[] data) {
		super();
		this.capacity = length;
		this.data = data;
		this.heapSize = heapSize;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int length) {
		this.capacity = length;
	}

	public int getHeapSize() {
		return heapSize;
	}

	public void setHeapSize(int heapSize) {
		this.heapSize = heapSize;
	}

	public void insert(int element) {
		if (heapSize < capacity) {
			data[heapSize++] = element;
		}
	}

	public int get(int index) {
		if (index >= heapSize)
			throw new IllegalArgumentException("Index is out of bound!");
		return data[index];
	}

	public void set(int val, int index) {
		if (index >= heapSize)
			throw new IllegalArgumentException("Index is out of bound!");
		data[index] = val;
	}

	public void display() {
		for (int i = 0; i < heapSize; i++)
			System.out.print(data[i] + ", ");
	}
}
