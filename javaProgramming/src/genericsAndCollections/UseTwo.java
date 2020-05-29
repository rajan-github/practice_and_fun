package genericsAndCollections;

public class UseTwo<T, X> {
	T one;
	X two;

	UseTwo(T t, X x) {
		this.one = t;
		this.two = x;
	}

	T getT() {
		return one;
	}

	X getX() {
		return two;
	}

	public static void main(String[] args) {
		UseTwo<String, Integer> useTwo = new UseTwo<>("ram", 1);
		System.out.println(useTwo.getT() + ", " + useTwo.getX());
	}
}
