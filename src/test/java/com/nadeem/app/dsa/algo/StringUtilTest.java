package com.nadeem.app.dsa.algo;

import org.junit.Test;
import static org.junit.Assert.*;

public final class StringUtilTest {

	@Test
	public void anagramTest() {
		assertTrue(StringUtil.isAnagram("keep" , "PeeK"));
		assertFalse(StringUtil.isAnagram("Hello", "hell"));
		assertTrue(StringUtil.isAnagram("SiLeNt", "LisTen"));		
	}
}
