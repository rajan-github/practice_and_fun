package genericsAndCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is an example of comparable interface.
 * 
 * @author rajan-c
 *
 */
public class DVDInfo implements Comparable<DVDInfo> {
	private String title;
	private String genre;
	private String leadActor;

	public DVDInfo(String title, String genre, String leadActor) {
		super();
		this.title = title;
		this.genre = genre;
		this.leadActor = leadActor;
	}

	@Override
	public int compareTo(DVDInfo o) {
		return title.compareTo(o.getTitle());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLeadActor() {
		return leadActor;
	}

	public void setLeadActor(String leadActor) {
		this.leadActor = leadActor;
	}

	@Override
	public String toString() {
		return "DVDInfo [title=" + title + ", genre=" + genre + ", leadActor=" + leadActor + "]";
	}

	public static void main(String[] args) {
		List<DVDInfo> list = new ArrayList<>();
		list.add(new DVDInfo("Star Wars", "sci-fi", "Ford, Harrison"));
		list.add(new DVDInfo("Caddyshack", "Games", "Ford, Harrison"));
		list.add(new DVDInfo("Patriot", "sci-fi", "Ford, Harrison"));
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}

}
