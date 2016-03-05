package com.nadeem.app.dsa.algo.lang;

import java.util.ArrayList;
import java.util.List;

public class ScaleUnits {
	
	private static List<ScaleUnit> units;
	static {
		units = new ArrayList<ScaleUnit>();
		units.add(new ScaleUnit(2, "hundred", "hundred"));
		units.add(new ScaleUnit(3, "thousand", "thousand"));
		units.add(new ScaleUnit(6, "million", "million"));
		units.add(new ScaleUnit(9, "billion", "milliard"));
		units.add(new ScaleUnit(-1, "tenth", "tenth"));
		units.add(new ScaleUnit(-2, "hundredth", "hundredth"));
		units.add(new ScaleUnit(-3, "thousandth", "thousandth"));
		units.add(new ScaleUnit(-4, "ten-thousandth", "ten-thousandth"));
		units.add(new ScaleUnit(-5, "hundred-thousandth", "hundred-thousandth"));
		units.add(new ScaleUnit(-6, "millionth", "millionth"));
	}

	private ScaleUnits() {
		
	}
	
	public static String getName(Scale scale, int exponent) {
        for (ScaleUnit unit : units) {
            if (unit.getExponent() == exponent) {
                return unit.getName(scale.ordinal());
            }
        }
        return ""; 
    }
}
