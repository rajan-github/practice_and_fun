package heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Heap<T extends Comparable<T>> {
	private T[] data;
	private int heapsize = 0;
	private Map<T, Integer> itemToIndexMap;

	@SuppressWarnings("unchecked")
	public Heap(int capacity) {
		super();
		if (capacity < 0)
			throw new IllegalArgumentException("Capacity cannot be less than zero!");
		itemToIndexMap = new HashMap<>();
		this.data = (T[]) new Comparable[capacity];
	}

	public T getItem(int index) {
		if (index >= heapsize)
			throw new IllegalArgumentException("Index cannot exceed heapsize.");
		return data[index];
	}

	public void setItem(int index, T item) {
		if (index >= heapsize)
			throw new IllegalStateException("Index cannot exceed headsize.");
		data[index] = item;
		itemToIndexMap.put(item, index);
	}

	public int getHeapSize() {
		return heapsize;
	}

	public void setHeapSize(int newSize) {
		heapsize = newSize;
	}

	public boolean isEmpty() {
		return heapsize == 0;
	}

	public int getIndexOfItem(T item) {
		return itemToIndexMap.getOrDefault(item, -1);
	}

	@Override
	public String toString() {
		return Arrays.toString(data);
	}
}
