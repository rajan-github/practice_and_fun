package designPatterns.singleton;

import java.util.HashSet;
import java.util.Set;

/**
 * Let's suppose we are going to put on a show. We have one performance of this
 * show and we only have a few seats in the theater. This is simple implementation without singleton.
 * 
 * @author rajan-c
 *
 */
public class SimpleShow {

	private Set<String> availableSeats;

	public SimpleShow() {
		availableSeats = new HashSet<>();
		availableSeats.add("1A");
		availableSeats.add("1B");
	}

	public boolean bookSeat(String seat) {
		return availableSeats.remove(seat);
	}

	public static void main(String[] args) {
		ticketAgentBooks("1A"); //we just booked 1A
		ticketAgentBooks("1A"); //we booked same seat twice.
	}

	private static void ticketAgentBooks(String seat) {
		SimpleShow show = new SimpleShow();
		System.out.println(show.bookSeat(seat));
	}
}
