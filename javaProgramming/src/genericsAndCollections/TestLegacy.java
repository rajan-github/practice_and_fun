package genericsAndCollections;

import java.util.ArrayList;
import java.util.List;

//a Java 5 or later class using a generic collection
public class TestLegacy {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		Adder adder = new Adder();
		System.out.println(adder.addAll(list));
	}
}
