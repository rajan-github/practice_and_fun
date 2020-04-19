package backtracking.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * @author rajan-c
 *
 */
public class RestoreIPAddress {
	public static List<String> restoreIpAddresses(String s) {
		List<String> addresses = new ArrayList<>();
		restoreIpAddresses(s, new ArrayList<String>(), addresses);
		return addresses;
	}

	private static void restoreIpAddresses(String remaining, List<String> address, List<String> addressList) {
		if (address.size() == 3 && remaining.length() <= 3 && remaining.length() > 0) {
			int number = Integer.parseInt(remaining);
			if ((remaining.length() == 3 && number > 99 && number <= 255) || (remaining.length() == 2 && number >= 10)
					|| (remaining.length() == 1 && number >= 0 && number < 10)) {
				address.add(remaining);
				addressList.add(buildIP(address));
				address.remove(address.size() - 1);
			}
		} else if (address.size() < 3 && remaining.length() > 0) {

			String singleDigit = remaining.substring(0, 1);
			address.add(singleDigit);
			restoreIpAddresses(remaining.substring(1, remaining.length()), address, addressList);
			address.remove(address.size() - 1);

			if (remaining.length() >= 2) {
				String doubleDigit = remaining.substring(0, 2);
				if (Integer.parseInt(doubleDigit) >= 10) {
					address.add(doubleDigit);
					restoreIpAddresses(remaining.substring(2, remaining.length()), address, addressList);
					address.remove(address.size() - 1);
				}
			}

			if (remaining.length() >= 3) {
				String threeDigit = remaining.substring(0, 3);
				int decimalValue = Integer.parseInt(threeDigit);
				if (decimalValue < 256 && decimalValue > 99) {
					address.add(threeDigit);
					restoreIpAddresses(remaining.substring(3, remaining.length()), address, addressList);
					address.remove(address.size() - 1);
				}
			}
		}
	}

	private static String buildIP(List<String> address) {
		StringBuilder ip = new StringBuilder();

		for (String item : address)
			if (ip.length() == 0)
				ip.append(item);
			else {
				ip.append(".");
				ip.append(item);
			}
		return ip.toString();
	}

	public static void main(String[] args) {
		String address = "25525511135";
		System.out.println(restoreIpAddresses(address));
		address = "0000";
		System.out.println(restoreIpAddresses(address));

		address = "010010";
		System.out.println(restoreIpAddresses(address));
	}
}
