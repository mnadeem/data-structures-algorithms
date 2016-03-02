package com.nadeem.app.dsa.algo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

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
		List<Integer> result = StringUtil.lexicogrSmallestPermutation("DDIIDI");
		assertThat(result.toArray(new Integer[0]), equalTo(new Integer[]{3, 2, 1, 4, 6, 5, 7}));
		
		result = StringUtil.lexicogrSmallestPermutation("IIII");
		assertThat(result.toArray(new Integer[0]), equalTo(new Integer[]{1, 2, 3, 4, 5}));
		
		result = StringUtil.lexicogrSmallestPermutation("DDDD");
		assertThat(result.toArray(new Integer[0]), equalTo(new Integer[]{5, 4, 3, 2, 1}));
		
		result = StringUtil.lexicogrSmallestPermutation("IID");
		assertThat(result.toArray(new Integer[0]), equalTo(new Integer[]{1, 2, 4, 3}));
		
		result = StringUtil.lexicogrSmallestPermutation("DDD");
		assertThat(result.toArray(new Integer[0]), equalTo(new Integer[]{4, 3, 2, 1}));
		
		
		result = StringUtil.lexicogrSmallestPermutation("IIDIID");
		assertThat(result.toArray(new Integer[0]), equalTo(new Integer[]{1, 2, 4, 3, 5, 7, 6}));
		
		result = StringUtil.lexicogrSmallestPermutation("IDDI");
		assertThat(result.toArray(new Integer[0]), equalTo(new Integer[]{1, 4, 3, 2, 5}));
		
		result = StringUtil.lexicogrSmallestPermutation("IDDI");
		assertThat(result.toArray(new Integer[0]), equalTo(new Integer[]{1, 4, 3, 2, 5}));
		
		result = StringUtil.lexicogrSmallestPermutation("IIID");
		assertThat(result.toArray(new Integer[0]), equalTo(new Integer[]{1, 2, 3, 5, 4}));
	}
}
