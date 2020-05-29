package heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This is implementation of the heap datastructure.
 * 
 * @author rajan-c
 *
 */
public class Heap<T extends Comparable<T>> {
	private T[] data;
	private int heapsize;
	private int capacity;
	private Map<T, Integer> indexMap;

	@SuppressWarnings({ "unchecked" })
	public Heap(int capacity) {
		if (capacity <= 0)
			throw new IllegalArgumentException("Invalid argument: " + capacity);
		this.capacity = capacity;
		data = (T[]) new Comparable[capacity];
		this.heapsize = 0;
		this.indexMap = new HashMap<>();
	}

	public void insert(T item) {
		this.indexMap.put(item, heapsize);
		this.data[heapsize++] = item;
	}

	public boolean isEmpty() {
		return this.heapsize == 0;
	}

	public T getItem(int index) {
		if (isEmpty())
			throw new IllegalStateException("Heap underflow!");
		else if (index < 0 || index >= heapsize)
			throw new IllegalArgumentException("Invalid argument: " + index);
		return this.data[index];
	}

	public void setItem(int index, T item) {
		if (isEmpty())
			throw new IllegalStateException("Heap underflow!");
		else if (index < 0 || index >= heapsize)
			throw new IllegalArgumentException("Invalid argument: " + index);
		this.data[index] = item;
	}

	public int getHeapsize() {
		return heapsize;
	}

	public void setHeapsize(int heapsize) {
		this.heapsize = heapsize;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getIndex(T item) {
		if (indexMap.containsKey(item))
			return indexMap.get(item);
		return -1;
	}

	public void setIndex(T item, int index) {
		indexMap.put(item, index);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + heapsize;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		Heap<T> other = (Heap<T>) obj;
		if (!Arrays.equals(data, other.data))
			return false;
		if (heapsize != other.heapsize)
			return false;
		return true;
	}
}
