package httpCalls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CountTopicInResponse {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=pizza");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.addRequestProperty("Accept", "application/json");
		connection.setRequestMethod("GET");
		connection.connect();
		int status = connection.getResponseCode();
		System.out.println("status is: " + status);
		InputStream responseStream = connection.getInputStream();
		StringBuilder response = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(responseStream))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				response.append(line);
			}
		}
		System.out.println(countSubstrMatch(response.toString(), "pizza"));
		System.out.println(response);
	}

	private static int countSubstrMatch(String text, String substr) {
		int count = 0;
		int lastIndex = 0;
		int n = text.length();
		while (lastIndex < n) {
			int index = text.indexOf(substr, lastIndex);
			if (index >= 0) {
				count++;
				lastIndex = index + 1;
			} else
				break;
		}
		return count;
	}
}
