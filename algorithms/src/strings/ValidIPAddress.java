package strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a function to check whether an input string is a valid IPv4 address or
 * IPv6 address or neither.
 * 
 * IPv4 addresses are canonically represented in dot-decimal notation, which
 * consists of four decimal numbers, each ranging from 0 to 255, separated by
 * dots ("."), e.g.,172.16.254.1;
 * 
 * Besides, leading zeros in the IPv4 is invalid. For example, the address
 * 172.16.254.01 is invalid.
 * 
 * IPv6 addresses are represented as eight groups of four hexadecimal digits,
 * each group representing 16 bits. The groups are separated by colons (":").
 * For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid
 * one. Also, we could omit some leading zeros among four hexadecimal digits and
 * some low-case characters in the address to upper-case ones, so
 * 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading
 * zeros and using upper cases).
 * 
 * However, we don't replace a consecutive group of zero value with a single
 * empty group using two consecutive colons (::) to pursue simplicity. For
 * example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
 * 
 * Besides, extra leading zeros in the IPv6 is also invalid. For example, the
 * address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
 * 
 * Note: You may assume there is no extra space or special characters in the
 * input string.
 * 
 * @author rajan-c
 *
 */
public class ValidIPAddress {
	public static String validIPAddress(String IP) {
		if (IP == null)
			return "Neither";
		int length = IP.length();
		if (length == 0 || length > 39)
			return "Neither";
		IP = IP.toLowerCase();
		char firstChar = IP.charAt(0), lastChar = IP.charAt(length - 1);
		if (firstChar == '.' || firstChar == ':' || lastChar == ':' || lastChar == '.')
			return "Neither";
		if (isIP4Address(IP))
			return "IPv4";
		else if (isIP6Address(IP))
			return "IPv6";
		return "Neither";
	}

	private static boolean isIP6Address(String ip) {
		String[] ipParts = ip.split(":");
		if (ipParts.length != 8)
			return false;
		if (hasLeadingZeros(ipParts[0]))
			return false;
		Set<Character> hexDigits = new HashSet<>();
		hexDigits.add('a');
		hexDigits.add('b');
		hexDigits.add('c');
		hexDigits.add('d');
		hexDigits.add('e');
		hexDigits.add('f');

		Set<Character> digits = new HashSet<>();
		digits.add('0');
		digits.add('1');
		digits.add('2');
		digits.add('3');
		digits.add('4');
		digits.add('5');
		digits.add('6');
		digits.add('7');
		digits.add('9');
		digits.add('8');

		for (String ipPart : ipParts) {
			int length = ipPart.length();
			if (length == 0 || length > 4)
				return false;
			for (int i = 0; i < length; i++) {
				char c = ipPart.charAt(i);
				if (!digits.contains(c) && !hexDigits.contains(c))
					return false;
			}
		}
		return true;
	}

	private static boolean hasLeadingZeros(String s) {
		boolean leadingZero = s.charAt(0) == '0';
		int length = s.length();
		for (int i = 1; i < length && leadingZero; i++) {
			if (s.charAt(i) != '0')
				return leadingZero;
		}
		return false;
	}

	private static boolean isIP4Address(String ip) {
		String[] ipParts = ip.split("\\.");
		if (ipParts.length != 4)
			return false;
		Set<Character> digits = new HashSet<>();
		digits.add('0');
		digits.add('1');
		digits.add('2');
		digits.add('3');
		digits.add('4');
		digits.add('5');
		digits.add('6');
		digits.add('7');
		digits.add('9');
		digits.add('8');
		for (String ipPart : ipParts) {
			int length = ipPart.length();
			if ((length > 1 && ipPart.charAt(0) == '0') || length == 0)
				return false;
			for (int i = 0; i < length; i++) {
				char c = ipPart.charAt(i);
				if (!digits.contains(c))
					return false;
			}
			if (Integer.parseInt(ipPart) > 255)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(validIPAddress("0.0..0"));
		System.out.println(validIPAddress("2001:0db8:85a3:00000:0:8A2E:0370:7334"));
		System.out.println(validIPAddress("2001:0db8:85a3:0000:0:8A2E:0370:7334"));
		System.out.println(validIPAddress("2001:0db8:85a3:0000:0:8A2E:3700:7334"));
		System.out.println(validIPAddress(
				"11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"));
	}
}
