package practice.graph.spanningTree;

import java.util.HashMap;
import java.util.Map;

public class Heap<T extends Comparable<T>> {
	private T[] dataArray;
	private int heapSize;
	private Map<T, Integer> indexMap;

	@SuppressWarnings("unchecked")
	public Heap(int capacity) {
		if (capacity <= 0)
			throw new IllegalArgumentException("Invalid capacity value");
		dataArray = (T[]) new Comparable[capacity];
		heapSize = 0;
		indexMap = new HashMap<>();
	}

	public T getDataAtIndex(int index) {
		if (index >= heapSize || index < 0)
			throw new IllegalArgumentException("Invalid heap size");
		return dataArray[index];
	}

	public void setDataAtIndex(int index, T _data) {
		if (index > heapSize || index < 0)
			throw new IllegalArgumentException("Invalid heap size");
		dataArray[index] = _data;
		indexMap.put(_data, index);
	}

	public int getHeapSize() {
		return heapSize;
	}

	public void setHeapSize(int heapSize) {
		this.heapSize = heapSize;
	}

	public boolean isFull() {
		return this.heapSize == this.dataArray.length;
	}

	public boolean isEmpty() {
		return this.heapSize == 0;
	}

	public int getIndex(T object) {
		return indexMap.getOrDefault(object, -1);
	}

}
