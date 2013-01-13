package com.nadeem.app.dsa.algo;

public class LongestPalindromeSubstring {

	private String source;
	private int sourceLength = 0;

	public LongestPalindromeSubstring(String sourceString) {
		this.source = sourceString;
		if (null != source) {
			sourceLength = source.length();
		}
	}

	public String get() {
		
		if (null == source || source.length() == 0) {
			return "";
		}

		String result 	= this.source.substring(0, 1);

		for (int i = 0; i < sourceLength; i++) {
			String oddSubPalin = extractPalinFromCenter(i, i);
			if (oddSubPalin.length() > result.length()) {
				result = oddSubPalin;
			}
		}

		return result;
	}

	private String extractPalinFromCenter(int left, int right) {
		while (left >=0 && right < sourceLength && source.charAt(left) == source.charAt(right)) {
			--left;
			++right;			
		}
		return source.substring(left + 1, right);
	}
}
