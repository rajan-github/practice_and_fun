package hashset;

public class MyHashSet {

	private int[] array;

	/** Initialize your data structure here. */
	public MyHashSet() {
		array = new int[(10000 / 32) + 1];
	}

	public void add(int key) {
		int index = key / 32;
		int bitPosition = key % 32;
		array[index] |= (1 << bitPosition);
	}

	public void remove(int key) {
		int index = key / 32;
		int bitPosition = key % 32;
		int mask = 1 << bitPosition;
		mask = ~(mask);
		array[index] &= mask;
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		int index = key / 32;
		int bitPosition = key % 32;
		int mask = array[index];
		return ((mask >> bitPosition) & 1) == 1;
	}

	public static void main(String[] args) {
		MyHashSet hashset = new MyHashSet();
		hashset.add(1);
		hashset.add(2);
		System.out.println(hashset.contains(1));
		System.out.println(hashset.contains(3));
		System.out.println(hashset.contains(2));
		hashset.remove(2);
		System.out.println(hashset.contains(2));
	}
}
