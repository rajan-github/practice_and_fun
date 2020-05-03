package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. put(key, value) - Set or insert the
 * value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new
 * item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up: Could you do both operations in O(1) time complexity?
 * 
 * @author rajan-c
 *
 */
public class LRUCache {
	private Map<Integer, Integer> map = new HashMap<>();
	private int[] keys;

	public LRUCache(int capacity) {
		keys = new int[capacity];
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			int index = findIndex(key);
			if (index >= 0) {
				updateIndex(index);
				return map.get(key);
			} else
				return -1;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			updateIndex(findIndex(key));
			map.replace(key, value);
		} else if (map.size() < keys.length) {
			keys[map.size()] = key;
			map.put(key, value);
		} else {
			updateIndex(0);
			int deletedKey = keys[map.size() - 1];
			keys[map.size() - 1] = key;
			map.remove(deletedKey);
			map.put(key, value);
		}
	}

	private void updateIndex(int index) {
		int temp = keys[index];
		int i = index, size = map.size();
		for (; i < size - 1; i++)
			keys[i] = keys[i + 1];
		keys[i] = temp;
	}

	private int findIndex(int key) {
		int size = map.size();
		for (int i = 0; i < size; i++)
			if (keys[i] == key)
				return i;
		return -1;
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(2, 1);
		cache.put(2, 2);
		System.out.println(cache.get(2));
		cache.put(1, 1);
		cache.put(4, 1);
		System.out.println(cache.get(2));
	
//		System.out.println(cache.get(1));
//		System.out.println(cache.get(3));
//		System.out.println(cache.get(4));
	}
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
