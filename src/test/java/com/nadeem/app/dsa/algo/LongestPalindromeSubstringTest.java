package com.nadeem.app.dsa.algo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LongestPalindromeSubstringTest {

	@Test
	public void logestPalindromStringIsEmpty() {
		LongestPalindromeSubstring lps = new LongestPalindromeSubstring("");
		assertThat(lps.get(), is(""));
	}
	
	@Test
	public void logestPalindromStringIsEmptyForNull() {
		LongestPalindromeSubstring lps = new LongestPalindromeSubstring(null);
		assertThat(lps.get(), is(""));
	}
	
	@Test
	public void shouldReturnValidOddLengthPalin() {
		LongestPalindromeSubstring lps = new LongestPalindromeSubstring("asabasb");
		assertThat(lps.get(), is("sabas"));
	}
	
	@Test
	public void shouldReturnValidEvenLengthPalin() {
		LongestPalindromeSubstring lps = new LongestPalindromeSubstring("asabbasb");
		assertThat(lps.get(), is("sabbas"));
	}
}
