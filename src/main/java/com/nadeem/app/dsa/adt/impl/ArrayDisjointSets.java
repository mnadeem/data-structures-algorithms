package com.nadeem.app.dsa.adt.impl;

import com.nadeem.app.dsa.adt.DisjointSets;

public class ArrayDisjointSets implements DisjointSets<Integer> {

	private Integer[] parent;
	private Integer[] rank;
	
	private static final int DEFAULT_SIZE = 20;
	
	public ArrayDisjointSets() {
		this(DEFAULT_SIZE);
	}

	public ArrayDisjointSets(int size) {
		this.parent =  new Integer[size];
		this.rank = new Integer[size];
		
		for (int i = 0; i < parent.length; i++) {
			this.parent[i] = i;
			this.rank[i] = 0;
		}
	}

	@Override
	public Integer findRepresentative(Integer item) {
		assertIsItem(item);
		if (this.parent[item] == item) {
			return item;
		} else {
			Integer representative = findRepresentative(this.parent[item]);
			this.parent[item] = representative;
			return representative;
		}		
	}

	@Override
	public void union(Integer x, Integer y) {

		int xRep = findRepresentative(x);
		int yRep = findRepresentative(y);
		int xRank = this.rank[x];
		int yRank = this.rank[y];
		
		if (xRep == yRep) {
			throw new IllegalArgumentException("Roots should be unique"); 
		}
		
		if (xRank < yRank) {
			this.parent[xRep] = yRep; 
		} else {
			if (xRep ==  yRep) {
				this.rank[xRep]++;
			}
			this.parent[yRep] = xRep;
		}
	}

	
	private void assertIsItem(int item) {
		if (item < 0 && item >= this.parent.length) {
			throw new IllegalArgumentException("Invalid Item " + item);
		}
	}
}
