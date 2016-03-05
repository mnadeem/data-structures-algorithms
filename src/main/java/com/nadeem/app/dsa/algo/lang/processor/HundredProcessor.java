package com.nadeem.app.dsa.algo.lang.processor;

import com.nadeem.app.dsa.algo.lang.Scale;
import com.nadeem.app.dsa.algo.lang.ScaleUnits;

public class HundredProcessor extends AbstractProcessor {

	private static int EXPONENT = 2;
	private UnitProcessor unitProcessor = new UnitProcessor();
	private TensProcessor tensProcessor = new TensProcessor();
	
	private Scale scale;
	
	public HundredProcessor(Scale scale) {
		this.scale = scale;
	}

	@Override
	public String getName(String name) {
		
		if (name == null || name.trim().length() == 0) {
			return "";
		}
		
		int number;
		StringBuilder builder = new StringBuilder();
		if (name.length() > 4) {
			number = Integer.valueOf(name.substring(name.length() - 4), 10);
		} else {
			number = Integer.valueOf(name, 10);
		}
		number %= 1000; // keep only 3 digits
		
		if (number >= 100) {
			builder.append(unitProcessor.getName(number/ 100));
			builder.append(SEPERATOR);
			builder.append(ScaleUnits.getName(scale, EXPONENT));
		}
		String tensPart = this.tensProcessor.getName(number % 100);
		if (!tensPart.isEmpty() && number >= 100) {
			builder.append(SEPERATOR);
		}
		builder.append(tensPart);
		return builder.toString();
	}
}
