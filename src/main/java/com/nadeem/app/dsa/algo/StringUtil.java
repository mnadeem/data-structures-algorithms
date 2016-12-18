package com.nadeem.app.dsa.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

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

	private static boolean validateMap(Map<Character, Integer> counter) {
		for (int val : counter.values()) {
			if (val != 0) {
				return false;
			}
		}
		return true;
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

	public static List<String> permutations(String input) {
		List<String> result = new ArrayList<String>();
		findPermutations("", input, result);
		return result;
	}

	private static void findPermutations(String prefix, String input, List<String> result) {
		int length = input.length();
		if (length == 0 && prefix.length() > 0) {
			result.add(prefix);
		} else {
			for (int i = 0; i < length; i++) {
				findPermutations(prefix+ input.charAt(i), input.substring(0, i) + input.substring(i+1), result);
			}
		}
		
	}

	public static String wordBreak(String input, Set<String> dictionary) {
		if (dictionary.contains(input)) {
			return input;
		}
		int len = input.length();
		for (int i = 1; i < len; i++) {
			String prefix = input.substring(0, i);
			if (dictionary.contains(prefix)) {
				String suffix = input.substring(i, len);
				String segSuffix = wordBreak(suffix, dictionary);
				if (segSuffix != null) {
					return prefix + " " + segSuffix;
				}
			}
		}
		return null;
	}

	public static String shortestSubstrContainingAllChars(String input, String target) {
		int needToFind[] = new int[256];
		int hasFound[] = new int[256];
		int totalCharCount = 0;
		String result = null;
		
		char[] targetCharArray = target.toCharArray();
		for (int i = 0; i < targetCharArray.length; i++) {
			needToFind[targetCharArray[i]]++;			
		}
		
		char[] inputCharArray = input.toCharArray();
		for (int begin = 0, end = 0; end < inputCharArray.length; end++) {
			
			if (needToFind[inputCharArray[end]] == 0) {
				continue;
			}
			
			hasFound[inputCharArray[end]]++;
			if (hasFound[inputCharArray[end]] <= needToFind[inputCharArray[end]]) {
				totalCharCount ++;
			}
			if (totalCharCount == target.length()) {
				while (needToFind[inputCharArray[begin]] == 0 
						|| hasFound[inputCharArray[begin]] > needToFind[inputCharArray[begin]]) {
					
					if (hasFound[inputCharArray[begin]] > needToFind[inputCharArray[begin]]) {
						hasFound[inputCharArray[begin]]--;
					}
					begin++;
				}
				
				String substring = input.substring(begin, end + 1);
				if (result == null || result.length() > substring.length()) {
					result = substring;
				}
			}
		}
		return result;
	}

	public static List<String> wordLadder(String begin, String end, Set<String> dictionary) {
		Queue<LadderNode> queue = new LinkedList<LadderNode>();
		queue.offer(new LadderNode(begin, null));

		return wordLadderResult(end, dictionary, queue);
	}

	private static List<String> wordLadderResult(String end, Set<String> dictionary, Queue<LadderNode> queue) {
		int currentSize = Integer.MAX_VALUE;
		List<String> result = Collections.emptyList();
		while (!queue.isEmpty()) {
			int count = queue.size();
			for (int i = 0; i < count; i++) {
				LadderNode current = queue.poll();			
				if (current.value.equals(end)) {
					List<String> currentResult = current.buildResult();
					if (currentSize > currentResult.size()) {
						result = currentResult;
					}
				}
				for(String next: allRelated(current, dictionary)) {
					if (current.notInLadder(next)) {					
						queue.offer(new LadderNode(next, current));
					}
				}
			}
		}
		return result;
	}

	private static class LadderNode {
		private String value;
		private LadderNode previous;
		public LadderNode(final String value, final LadderNode previous) {
			this.value = value;
			this.previous = previous;
		}

		@Override
		public String toString() {
			return this.value;
		}

		public boolean notInLadder(String next) {
			LadderNode tmp = this;
			while (tmp != null) {
				if (tmp.value.equals(next)) {
					return false;
				}
				tmp = tmp.previous;
			}
			return true;
		}
		
		public List<String> buildResult() {
			List<String> result = new ArrayList<String>();
			LadderNode current = this;
			while(current != null) {
				result.add(current.value);
				current = current.previous;
			}
			return result;
		}
	}

	private static Set<String> allRelated(LadderNode current, Set<String> dictionary) {
		Set<String> related = new HashSet<String>();
		for (String word : dictionary) {
			if (related(current.value, word) && current.notInLadder(word)) {
				related.add(word);			
			}
		}
		return related;
	}

	private static boolean related(String word1, String word2) {
		// Use Edit differences instead
		int differences = 1;
	    if(word1.length() == word2.length()) {
	        for(int i = 0; i < word1.length(); i++) {
	            if(word1.charAt(i) != word2.charAt(i)) {
	            	differences--;
	                if(differences < 0) {
	                    return false;
	                }
	            }
	        }
	    }
	    return true;
	}
}
