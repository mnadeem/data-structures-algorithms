package com.nadeem.app.dsa.algo.lang.processor;

import com.nadeem.app.dsa.algo.lang.Scale;
import com.nadeem.app.dsa.algo.lang.ScaleUnits;

public class CompositeBigProcessor extends AbstractProcessor {
	private Scale scale;
	private int exponent;
	private HundredProcessor highProcessor;
	private AbstractProcessor lowProcessor;
	
	public CompositeBigProcessor(int exponent, Scale scale) {
		this.scale = scale;
		this.exponent = exponent;
		this.highProcessor = new HundredProcessor(scale);
		if (exponent <= 3) {
			this.lowProcessor = new HundredProcessor(scale);
		} else {
			this.lowProcessor = new CompositeBigProcessor(exponent - 3, scale);
		}
	}

	@Override
	public String getName(String name) {
		StringBuilder  result = new StringBuilder();
		String high, low;
		if (name.length() > getPartDivider()) {
			int index = name.length() - getPartDivider();
			high = name.substring(0, index);
			low = name.substring(index);
		} else {
			high = "";
			low = name;
		}
		
		String highName = getHighProcessor().getName(high);
		String lowName = getLowProcessor().getName(low);
		
		if (!highName.isEmpty()) {
			result.append(highName);
			result.append(SEPERATOR);
			result.append(getToken());
			
			if (!lowName.isEmpty()) {
				result.append(SEPERATOR);
			}			
		}
		if (!lowName.isEmpty()) {
			result.append(lowName);
		}
		
		return result.toString();
	}
	
	private String getToken() {
		return ScaleUnits.getName(this.scale, getPartDivider());
	}

	public int getPartDivider() {
		return exponent;
	}

	public HundredProcessor getHighProcessor() {
		return highProcessor;
	}

	public AbstractProcessor getLowProcessor() {
		return lowProcessor;
	}
}
