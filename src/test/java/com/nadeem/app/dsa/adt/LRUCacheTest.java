package com.nadeem.app.dsa.adt;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

import com.nadeem.app.dsa.adt.impl.LRUCache;

public class LRUCacheTest {
	
	private LRUCache<Integer, Integer> cache;
	
	@Before
	public void doBeforeEachTestCase() {
		this.cache = new LRUCache<Integer, Integer>(2);
	}

	@Test
	public void setTest() {
		this.cache.set(1, 1);
		assertThat(this.cache.size(), equalTo(1));
		assertThat(this.cache.get(1), equalTo(1));
		
		this.cache.set(2, 2);
		assertThat(this.cache.size(), equalTo(2));
		assertThat(this.cache.get(2), equalTo(2));

		this.cache.set(3, 3);
		assertThat(this.cache.size(), equalTo(2));
		assertThat(this.cache.get(3), equalTo(3));
		
		this.cache.set(1, 3);
		assertThat(this.cache.size(), equalTo(2));
		assertThat(this.cache.get(1), equalTo(3));
		
		assertThat(this.cache.get(4), equalTo(null));
	}

}
