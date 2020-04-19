package stack.examples;

public class DynamicArrayStack {
	private int top = -1;
	private int capacity;

	public static final int CAPACITY = 16;
	public static int MINCAPACITY = 1 << 15;

	private int[] data;

	public DynamicArrayStack() {
		this(CAPACITY);
	}

	public DynamicArrayStack(int capacity) {
		super();
		this.capacity = capacity;
		this.data = new int[capacity];
	}

	private boolean isFull() {
		return top == capacity - 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public int size() {
		return top + 1;
	}

	private void ensureSize() {
		if (isFull()) {
			int[] temp = new int[this.capacity * 2];
			for (int i = 0; i < this.capacity; i++) {
				temp[i] = this.data[i];
			}
			this.capacity *= 2;
			this.data = temp;
		}
	}

	private void shrink() {
		if (this.top + 1 < this.capacity / 2) {
			int[] temp = new int[this.capacity / 2];
			for (int i = 0; i <= top; i++) {
				temp[i] = this.data[i];
			}
			this.data = temp;
			this.capacity /= 2;
		}
	}

	public void push(int item) {
		ensureSize();
		this.data[++top] = item;
	}

	public int pop() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Stack underflow!");
		}
		int item = this.data[top--];
		shrink();
		return item;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		for (int i = 0; i <= top; i++)
			string.append(this.data[i]).append(", ");
		return "[" + string.toString() + "]";
	}

	public static void main(String[] args) {
		DynamicArrayStack stack = new DynamicArrayStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack.size());
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack);
	}

}
