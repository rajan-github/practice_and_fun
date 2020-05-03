package heap;

import java.util.Arrays;

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

	@SuppressWarnings({ "unchecked" })
	public Heap(int capacity) {
		if (capacity <= 0)
			throw new IllegalArgumentException("Invalid argument: " + capacity);
		this.capacity = capacity;
		data = (T[]) new Comparable[capacity];
		this.heapsize = 0;
	}

	public void insert(T item) {
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
