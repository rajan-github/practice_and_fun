package genericsAndCollections;

public class TestGenerics<T> { // as the class type
	T anInstance; // as an instance variable type
	T[] anArrayOfTs; // as an array type

	T get() {
		return anInstance;
	}
}
