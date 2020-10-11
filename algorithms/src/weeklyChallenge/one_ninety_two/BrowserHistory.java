package weeklyChallenge.one_ninety_two;

import java.util.ArrayList;
import java.util.List;

/**
 * You have a browser of one tab where you start on the homepage and you can
 * visit another url, get back in the history number of steps or move forward in
 * the history number of steps.
 * 
 * Implement the BrowserHistory class:
 * 
 * BrowserHistory(string homepage) Initializes the object with the homepage of
 * the browser. void visit(string url) visits url from the current page. It
 * clears up all the forward history. string back(int steps) Move steps back in
 * history. If you can only return x steps in the history and steps > x, you
 * will return only x steps. Return the current url after moving back in history
 * at most steps. string forward(int steps) Move steps forward in history. If
 * you can only forward x steps in the history and steps > x, you will forward
 * only x steps. Return the current url after forwarding in history at most
 * steps.
 * 
 * @author rajan-c
 *
 */
public class BrowserHistory {

	List<String> history;
	int currentPage = -1;

	public BrowserHistory(String homepage) {
		history = new ArrayList<>();
		history.add(homepage);
		currentPage = 0;
	}

	public void visit(String url) {
		int size = history.size();

		for (int i = currentPage + 1; i < size; i++)
			history.remove(history.size() - 1);
		history.add(url);
		currentPage++;
	}

	public String back(int steps) {
		steps = Math.min(steps, currentPage + 1);
		currentPage -= steps;
		if (currentPage < 0)
			currentPage = 0;
		return history.get(currentPage);
	}

	public String forward(int steps) {
		int size = history.size();
		steps = Math.min(steps, size - currentPage - 1);
		if (steps >= 0)
			currentPage += steps;
		return history.get(currentPage);
	}

	public static void main(String[] args) {
		BrowserHistory history = new BrowserHistory("google.com");
		history.visit("rajan.com");
		history.visit("linked.con");
		System.out.println(history.back(4));
		history.visit("k.con");
		System.out.println(history.forward(2));
		System.out.println(history.forward(5));
		history.visit("k.con");
		System.out.println(history.forward(1));
	}
}
