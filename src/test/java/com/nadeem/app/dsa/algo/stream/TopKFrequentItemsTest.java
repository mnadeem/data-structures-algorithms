package com.nadeem.app.dsa.algo.stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.nadeem.app.dsa.algo.stream.TopKFrequentItems.TopK;

public class TopKFrequentItemsTest {

	@Test
	public void test() {
		TopKFrequentItems stream = new TopKFrequentItems(2);
		
		stream.add("hell");
		stream.add("hello");
		stream.add("hello");
		stream.add("hello");
		stream.add("hello");
		stream.add("hello");
		stream.add("hero");
		stream.add("hero");
		stream.add("hero");
		stream.add("hello");
		stream.add("hello");
		stream.add("hello");
		stream.add("home");
		stream.add("go");
		stream.add("go");
		assertThat(stream.getItems()).hasSize(2).contains(new TopK("hero", 3), new TopK("hello", 8));
	}

}
