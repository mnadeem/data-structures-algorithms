package com.nadeem.app.dsa.algo;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		
		List<Integer> result = StringUtil.lexicogrSmallestPermutation("IIII");
		assertThat(result.toArray(new Integer[0]), equalTo(new Integer[]{1, 2, 3, 4, 5}));
		
		result = StringUtil.lexicogrSmallestPermutation("DDDI");
		assertThat(result.toArray(new Integer[0]), equalTo(new Integer[]{4,3,2,1,5}));
		
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

	@Test 
	public void permutationsTest() {
		List<String> permutations = StringUtil.permutations("AB");
		assertThat(permutations, equalTo(Arrays.asList("AB", "BA")));
		
		permutations = StringUtil.permutations("ABC");
		assertThat(permutations, equalTo(Arrays.asList("ABC", "ACB", "BAC","BCA","CAB", "CBA")));
	}
	
	@Test
	public void wordBreakTest() {
		String result = StringUtil.wordBreak("applepieball", dictionary());
		assertThat(result, equalTo("apple pie ball"));
	}


	private Set<String> dictionary() {
		Set<String> dict = new HashSet<String>();
		dict.add("apple");
		dict.add("pie");
		dict.add("ball");
		return dict;
	}
	
	@Test
	public void shortestSubstringContainingAllCharsTest() {
		String result = StringUtil.shortestSubstrContainingAllChars("acbbaca", "aba");
		assertThat(result, equalTo("baca"));
		
		result = StringUtil.shortestSubstrContainingAllChars("acbbADOBECODEBANCaca", "ABC");
		assertThat(result, equalTo("BANC"));
		
		result = StringUtil.shortestSubstrContainingAllChars("this is a test string", "tist");
		assertThat(result, equalTo("t stri"));
	}
	
	@Test
	public void wordLadderTest() {
		String begin="hit", end ="cog";
		Set<String> dictionary = wordLadderDictonary();
		List<String> result = StringUtil.wordLadder(begin, end, dictionary);

		org.assertj.core.api.Assertions.assertThat(result).containsAll(Arrays.asList("hit","hot","lot","log","cog"));
	}

	private Set<String> wordLadderDictonary() {
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dog");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");		
		dict.add("cog");
		dict.add("hit");
		return dict;
	}
	
	@Test
	public void allPermutationsTest() {
		Collection<String> result = StringUtil.allPermutations(1221);
		org.assertj.core.api.Assertions.assertThat(result).hasSize(5).containsAll(Arrays.asList("abba","abu", "ava", "lba", "lu"));
		
		result = StringUtil.allPermutations(10);
		org.assertj.core.api.Assertions.assertThat(result).hasSize(2).containsAll(Arrays.asList("a","j"));
	}
}
