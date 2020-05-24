package genericsAndCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GenreSort implements Comparator<DVDInfo> {

	@Override
	public int compare(DVDInfo dvd1, DVDInfo dvd2) {
		return dvd1.getGenre().compareTo(dvd2.getGenre());
	}

	public static void main(String[] args) {
		List<DVDInfo> list = new ArrayList<>();
		list.add(new DVDInfo("Star Wars", "sci-fi", "Ford, Harrison"));
		list.add(new DVDInfo("Caddyshack", "Games", "Ford, Harrison"));
		list.add(new DVDInfo("Patriot", "Drama", "Ford, Harrison"));
		System.out.println(list);
		Collections.sort(list, new GenreSort());
		System.out.println(list);
	}
}
