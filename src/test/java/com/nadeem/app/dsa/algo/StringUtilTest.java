package com.nadeem.app.dsa.algo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public final class StringUtilTest {

	@Test
	public void anagramTest() {
		assertTrue(StringUtil.isAnagram("keep" , "PeeK"));
		assertFalse(StringUtil.isAnagram("Hello", "hell"));
		assertTrue(StringUtil.isAnagram("SiLeNt caT", "LisTen cat"));		
	}
	
	
	@Test
	public void lexicographicallySmallestPermutationTest() {
		String result = StringUtil.lexicogrSmallestPermutation("DDIIDI");
		assertThat(result, equalTo("3 2 1 4 6 5 7 "));
		
		result = StringUtil.lexicogrSmallestPermutation("IID");
		assertThat(result, equalTo("1 2 4 3 "));
		
		result = StringUtil.lexicogrSmallestPermutation("DDD");
		assertThat(result, equalTo("4 3 2 1 "));
		
		
		result = StringUtil.lexicogrSmallestPermutation("IIDIID");
		assertThat(result, equalTo("1 2 4 3 5 7 6 "));
	}
}
