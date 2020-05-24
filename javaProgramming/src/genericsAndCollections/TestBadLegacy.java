package genericsAndCollections;

import java.util.ArrayList;
import java.util.List;

public class TestBadLegacy {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		Inserter in = new Inserter();
		in.insert(list);
		System.out.println(list);
	}
}

class Inserter {
	public void insert(List list) {
		list.add(new String("ram"));
	}
}
