package genericsAndCollections;

import java.util.ArrayList;
import java.util.List;

public class GenericMethod {
	public <T> void makeArrayList(T t) {
		List<T> list = new ArrayList<T>();
		list.add(t);
	}

	public void makeArrayList(Dog t) {
		List<Dog> list = new ArrayList<>();
		list.add(t);
	}
}
