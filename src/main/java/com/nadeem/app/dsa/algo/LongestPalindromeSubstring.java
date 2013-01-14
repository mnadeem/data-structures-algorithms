package com.nadeem.app.dsa.algo;

public class LongestPalindromeSubstring {

	private String source;
	private int sourceLength = 0;

	public LongestPalindromeSubstring(String sourceString) {

		this.source = sourceString;
		if (null != sourceString) {
			this.sourceLength = sourceString.length();
		}
	}

	public String get() {
		
		if (null == this.source || this.source.length() == 0) {
			return "";
		}

		String result 	= this.source.substring(0, 1);

		for (int center = 0; center < this.sourceLength; center++) {

			String oddSubPalin = extractPalinFromCenter(center, center);
			if (oddSubPalin.length() > result.length()) {
				result = oddSubPalin;
			}
			String evenSubPalin = extractPalinFromCenter(center, center + 1);
			if (evenSubPalin.length() > result.length()) {
				result = evenSubPalin;
			}
		}

		return result;
	}

	private String extractPalinFromCenter(int left, int right) {
		while (left >=0 && right < this.sourceLength && this.source.charAt(left) == this.source.charAt(right)) {
			--left;
			++right;			
		}
		return source.substring(left + 1, right);
	}
}
