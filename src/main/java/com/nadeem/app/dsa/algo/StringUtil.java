package com.nadeem.app.dsa.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringUtil {

	public static boolean isAnagram(String first, String second) {
		if (first == null || second == null) {
			return false;
		}
		if (first.length() != second.length()) {
			return false;
		}
		return doCheckAnagramUsingHashMap(first.toLowerCase(), second.toLowerCase());
	}

	private static boolean doCheckAnagramUsingHashMap(final String first, final String second) {
		Map<Character, Integer> counter = populateMap(first, second);
		return validateMap(counter);
	}

	private static boolean validateMap(Map<Character, Integer> counter) {
		for (int val : counter.values()) {
			if (val != 0) {
				return false;
			}
		}
		return true;
	}

	private static Map<Character, Integer> populateMap(final String first, final String second) {
		Map<Character, Integer> counter = new HashMap<Character, Integer>();
		for (int i = 0; i < first.length(); i++) {
			char chr1 = first.charAt(i);
			int char1Count = getCount(counter, chr1);
			counter.put(chr1, ++char1Count);
			char chr2 = second.charAt(i);
			int char2Count = getCount(counter, chr2);
			counter.put(chr2, --char2Count);
		}
		return counter;
	}

	private static int getCount(Map<Character, Integer> map, char charAt) {
		Integer val = map.get(charAt);
		return val == null ? 0 : val;
	}

	static boolean doCheckAnagramUsingCouter(String first, String second) {
		int count[] = buildCounter(first.toCharArray(), second.toCharArray());

		return isCounterValid(count);
	}

	private static int[] buildCounter(char[] firstArray, char[] secondArray) {
		int count[] = new int[25];
		for (int i = 0; i < firstArray.length; i++) {
			count[buildIndex(firstArray[i])]++; // Increment the count of the
												// character at i
			count[buildIndex(secondArray[i])]--; // Decrement the count of the
													// character at i
		}
		return count;
	}

	private static int buildIndex(char chr) {
		return chr - 97;
	}

	private static boolean isCounterValid(int[] count) {
		for (int i = 0; i < count.length; i++) {
			if (count[i] == 1) {
				return false;
			}
		}
		return true;
	}
	// Refer https://www.careercup.com/question?id=14912744
	public static List<Integer> lexicogrSmallestPermutation(String signature) {
		List<Integer> result = new ArrayList<Integer>();
		int lastI = 1;
		for (int i = 0; i < signature.length(); i++) {
			if ('I' == signature.charAt(i)) {
				result.addAll(reverse(lastI, i + 1));
				lastI = i + 2;
			}
		}
		result.addAll(reverse(lastI, signature.length() + 1));
		return result;
	}

	private static List<Integer> reverse(int begin, int end) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = end; i >= begin; i--) {
			result.add(i);
		}
		return result;
	}
}
