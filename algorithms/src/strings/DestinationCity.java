package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * You are given the array paths, where paths[i] = [cityAi, cityBi] means there
 * exists a direct path going from cityAi to cityBi. Return the destination
 * city, that is, the city without any path outgoing to another city.
 * 
 * It is guaranteed that the graph of paths forms a line without any loop,
 * therefore, there will be exactly one destination city.
 * 
 * 
 * @author rajan-c
 *
 */
public class DestinationCity {
	public String destCity(List<List<String>> paths) {
		Map<String, String> pathMap = new HashMap<>();
		Set<String> cities = new HashSet<>();
		for (List<String> path : paths) {
			pathMap.put(path.get(0), path.get(1));
			cities.add(path.get(0));
			cities.add(path.get(1));
		}

		String destination = null;
		Iterator<String> iterator = cities.iterator();
		while (iterator.hasNext() && destination == null) {
			String temp = iterator.next();
			if (!pathMap.containsKey(temp))
				destination = temp;
		}
		return destination;
	}

	public static void main(String[] args) {

	}
}
