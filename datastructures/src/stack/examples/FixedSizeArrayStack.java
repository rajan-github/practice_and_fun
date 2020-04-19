package stack.examples;

public class FixedSizeArrayStack {
	private int capacity;
	private int size;
	private int[] data;

	public FixedSizeArrayStack() {
		super();
		this.capacity = 10;
		data = new int[this.capacity];
	}

	public FixedSizeArrayStack(int capacity) {
		super();
		if (capacity <= 0)
			throw new IllegalArgumentException("Invalid capacity: " + capacity);
		this.capacity = capacity;
		data = new int[this.capacity];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == capacity;
	}

	public void push(int item) {
		if (isFull()) {
			throw new IllegalStateException("Stack overflow!");
		}
		this.data[size++] = item;
	}

	public int pop() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Stack underflow!");
		}
		return this.data[--size];
	}

	public int size() {
		return size + 1;
	}

	@Override
	public String toString() {
		StringBuilder stack = new StringBuilder();
		if (!isEmpty()) {
			for (int item : data)
				stack.append(item).append(", ");
		}
		return "[" + stack.toString() + "]";
	}

	public static void main(String[] args) {
		FixedSizeArrayStack stack = new FixedSizeArrayStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		System.out.println(stack);
	}
}
