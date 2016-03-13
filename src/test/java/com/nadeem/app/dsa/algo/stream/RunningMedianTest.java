package com.nadeem.app.dsa.algo.stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RunningMedianTest {

	@Test
	public void test() {
		
		RunningMedian streamMedian = new RunningMedian();
		streamMedian.insert(1);
		assertThat(streamMedian.get(), equalTo(1.0));
		streamMedian.insert(5);
		streamMedian.insert(10);
		streamMedian.insert(12);
		streamMedian.insert(2);
		assertThat(streamMedian.get(), equalTo(5.0));
		streamMedian.insert(3);
		streamMedian.insert(8);
		streamMedian.insert(9);
		assertThat(streamMedian.get(), equalTo(6.5));
		
	}

}
