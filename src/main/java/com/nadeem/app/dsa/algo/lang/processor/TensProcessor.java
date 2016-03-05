package com.nadeem.app.dsa.algo.lang.processor;

public class TensProcessor extends AbstractProcessor {
	
	private static final String[] TOKENS = { "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};

	private UnitProcessor  unitProcessor = new UnitProcessor();

	@Override
	public String getName(String name) {
		if (name == null || name.trim().length() == 0) {
			return "";
		}
		boolean tensFound = false;
		StringBuffer result = new StringBuffer();
		int number;
		if (name.length() > 3) {
			number = Integer.valueOf(name.substring(name.length() - 3), 10);
		} else {
			number = Integer.valueOf(name, 10);
		}
		
		number %= 100; // keep only two digits

		if (number >= 20) {
			result.append(TOKENS[(number / 10) - 2]);
			number %= 10;
			tensFound = true;
		} else {
			number %= 20;
		}
		
		if (number != 0) {
			if (tensFound) {
				result.append("-");
			}
			result.append(unitProcessor.getName(number));
		}	
		
		return result.toString();
	}
}
