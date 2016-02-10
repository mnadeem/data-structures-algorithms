package com.nadeem.app.dsa.adt;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import com.nadeem.app.dsa.adt.impl.ArrayDisjointSets;

public class ArrayDisjointSetsTest {

	@Test
	public void testFindRepresentative() {
		DisjointSets<Integer> disjointSets = new ArrayDisjointSets(5);
		
		for (int i = 0; i <5; i++) {
			assertThat(disjointSets.findRepresentative(i), is(i));			
		}		
	}
	
	@Test
	public void testUnion() {
		DisjointSets<Integer> disjointSets = new ArrayDisjointSets(5);
		
		for (int i = 0; i <5; i++) {
			assertThat(disjointSets.findRepresentative(i), is(i));			
		}
		
		disjointSets.union(4, 2);
		disjointSets.union(4, 0);
		assertThat(disjointSets.findRepresentative(4), is(4));	
		assertThat(disjointSets.findRepresentative(2), is(4));
		assertThat(disjointSets.findRepresentative(0), is(4));
		
		disjointSets.union(3, 1);
		assertThat(disjointSets.findRepresentative(3), is(3));	
		disjointSets.union(4, 1);
		
		assertThat(disjointSets.findRepresentative(1), is(4));
		assertThat(disjointSets.findRepresentative(0), is(4));

	}

}
