package designPatterns.singleton;

import java.util.HashSet;
import java.util.Set;

/**
 * Let's suppose we are going to put on a show. We have one performance of this
 * show and we only have a few seats in the theater. This is singleton pattern
 * implementation.
 * 
 * @author rajan-c
 *
 */
public class Show {

	private static Show INSTANCE = new Show();
	private Set<String> availableSeats;

	/*
	 * Note: Its not thread safe and could create two instances of the show at the
	 * same time.
	 */
	public static Show getInstance() {
		if (INSTANCE == null)
			INSTANCE = new Show();
		return INSTANCE;
	}

	private Show() {
		availableSeats = new HashSet<>();
		availableSeats.add("1A");
		availableSeats.add("1B");
	}

	public boolean bookSeat(String seat) {
		return this.availableSeats.remove(seat);
	}

	public static void main(String[] args) {

	}

	public static void ticketAgentBooks(String seat) {
		Show show = Show.getInstance();
		System.out.println(show.bookSeat(seat));
	}
}
