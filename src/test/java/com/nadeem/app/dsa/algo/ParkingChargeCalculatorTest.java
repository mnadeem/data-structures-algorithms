package com.nadeem.app.dsa.algo;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.nadeem.app.dsa.algo.ParkingChargeCalculator.Interval;

public class ParkingChargeCalculatorTest {

	@Test
	public void test() {
		ParkingChargeCalculator chargeCalculator = new ParkingChargeCalculator(buildPriceRules());
		//assertThat(chargeCalculator.weekDayCharge(3), equalTo(15));
		//assertThat(chargeCalculator.weekEndCharge(3), equalTo(15));
	}

	private List<Interval> buildPriceRules() {
		List<Interval> rules = new ArrayList<ParkingChargeCalculator.Interval>();
		rules.add(new Interval(0, 1, 5, 8));
		rules.add(new Interval(2, 5, 10, 13));
		rules.add(new Interval(6, 11, 15, 18));
		rules.add(new Interval(12, 24, 20, 25));
		return rules;
	}

}
