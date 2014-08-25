import java.util.ArrayList;
import java.util.List;


public class StringSearch implements StringSearchInterface {

	@Override
	public List<Integer> boyerMoore(String needle, String haystack) {
		if (needle == null || haystack == null) {
			throw new IllegalArgumentException();
		}
		int[] map = buildLastTable(needle);
		List<Integer> ind = new ArrayList<Integer>();
		int offset = 0;
		
		int counter =  needle.length() - 1; 
		while (!(offset + counter >= haystack.length())) {
			if (haystack.charAt(offset + counter) == needle.charAt(counter)) {
				counter--;
				if (counter <= 0) {
					ind.add(offset);
					counter = needle.length() - 1;
					offset += 1;
				}
			} else {
				int move = Math.max(map[haystack.charAt(offset + counter)] - needle.length() + 1 + counter, 1);
				offset += move;
				counter = needle.length() - 1;
			}
		}
		return ind;
	}

	@Override
	public int[] buildLastTable(String needle) {
		int[] map = new int[Character.MAX_VALUE + 1];
		for (int i = Character.MIN_VALUE; i <= Character.MAX_VALUE; i++) {
			if (needle.contains(Character.toString((char) i))) {
				map[i] = Math.max(needle.length() - needle.lastIndexOf((char) i) - 1, 1);
			} else {
				map[i] = needle.length();
			}
		}
		return map;
	}

	@Override
	public int generateHash(String current) {
		int hash = 0;
		char[] string = current.toCharArray();
		
		for (int m = 1 , i = string.length - 1; i >= 0; i-- , m *= BASE) {
			hash += string[i] * m;
		}
		
		return hash;
	}

	@Override
	public int updateHash(int oldHash, int length, char oldChar, char newChar) {
		return (oldHash - (oldChar * power(BASE, length - 1))) * BASE + newChar;
	}

	@Override
	public List<Integer> rabinKarp(String needle, String haystack) {
		if (needle == null || haystack == null) {
			throw new IllegalArgumentException();
		}
		List<Integer> ind = new ArrayList<Integer>();
		if (needle.length() > haystack.length()) {
			return ind;
		}
		int hash = generateHash(needle);
		int prev = generateHash(haystack.substring(0, needle.length()));
		if (hash == prev) {
			ind.add(0);
		}
		for (int i = 1; i < haystack.length() - needle.length() + 1; i++) {
			prev = updateHash(prev, needle.length(), haystack.charAt(i - 1), haystack.charAt(i + needle.length() - 1));
			if (prev == hash && check(needle, haystack, i)) {
				ind.add(i);
			}
		}
		return ind;
	}
	
	/**
	 * THis method handles raising a base to a power
	 * @param a the base
	 * @param b the power
	 * @return a^b
	 */
	private int power(int a, int b) {
		int ret = 1;
		if (b == 0) {
			return 1;
		} else if (b == 1) {
			return a;
		} else {
			for (int i = 1; i <= b; i++) {
				ret *= a;
			}
			return ret;
		}
	}

	/**
	 * This checks if two strings are equal for Rabin-Karp
	 * @param needle the thing to look for
	 * @param haystack the thing being searched
	 * @param start the starting index
	 * @return true if needle == haystack.substring(start, needle.length()), false otherwise
	 */
	private boolean check(String needle, String haystack, int start) {
		if (start + needle.length() - 1 >= haystack.length()) {
			return false;
		}
		return needle.equals(haystack.substring(start, needle.length() + start));
	}

}
