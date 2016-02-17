package com.nadeem.app.dsa.algo;

public class StringUtil {

	public static boolean isAnagram(String first, String second) {
		if (first == null || second == null) {
			return false;
		}
		if (first.length() != second.length()) {
			return false;
		}
		int count[] = buildCounter(first.toLowerCase().toCharArray(), second.toLowerCase().toCharArray());

		return isCounterValid(count);
	}

	private static int[] buildCounter(char[] firstArray, char[] secondArray) {
		int count[] = new int[25];
		for (int i = 0; i < firstArray.length; i++) {
			count[buildIndex(firstArray[i])]++;  // Increment the count of the character at i
			count[buildIndex(secondArray[i])]--; // Decrement the count of the character at i
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
}
