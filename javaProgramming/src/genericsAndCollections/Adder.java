package genericsAndCollections;

import java.util.Iterator;
import java.util.List;

/**
 * Pre java5 collections in use.
 * 
 * @author rajan-c
 *
 */
public class Adder {
	@SuppressWarnings("rawtypes")
	public int addAll(List list) {
		Iterator iterator = list.iterator();
		int total = 0;
		while (iterator.hasNext())
			total += (Integer) iterator.next();
		return total;
	}
}
