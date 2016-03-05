package com.nadeem.app.dsa.algo.lang.processor;

public class UnitProcessor extends AbstractProcessor {

	private static final String[] TOKENS = new String[] { "one", "two", "three", "four", "five",
														  "six", "seven",  "eight", "nine","ten",
														  "eleven", "tweleve", "thirteen", "fourteenn", "fifteen", 
														  "sixteen", "seventeen", "eighteen","nineteen"};

	@Override
	public String getName(String name) {
		if (name == null || name.trim().length() == 0) {
			return "";
		}
		int offset = NO_VALUE;
		int number;
		if (name.length() > 3) {
			number = Integer.valueOf(name.substring(name.length() - 3), 10);
		} else {
			number = Integer.valueOf(name, 10);
		}
		number %= 100; // keep only two digits
		if (number < 10) {
			offset = number % 10 - 1;
		} else if (number < 20) {
			offset = number % 20 - 1;
		}
		if (offset != NO_VALUE && offset < TOKENS.length) {
			return TOKENS[offset];
		}
		return "";
	}
}
