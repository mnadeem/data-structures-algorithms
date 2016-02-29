package com.nadeem.app.dsa.algo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public final class StringUtilTest {

	@Test
	public void anagramTest() {
		assertTrue(StringUtil.isAnagram("keep" , "PeeK"));
		assertFalse(StringUtil.isAnagram("Hello", "hell"));
		assertTrue(StringUtil.isAnagram("SiLeNt caT", "LisTen cat"));		
	}
}
