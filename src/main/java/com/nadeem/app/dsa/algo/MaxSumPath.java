package com.nadeem.app.dsa.algo;

import java.util.ArrayList;
import java.util.List;

public class MaxSumPath {
	private List<Integer> path;
	private int sum;

	public MaxSumPath(int sum) {
		this.sum = sum;
		this.path = new ArrayList<Integer>();
	}

	public List<Integer> getPath() {
		return path;
	}

	public boolean updateSum(int newSum) {
		if (newSum > sum) {
			this.sum = newSum;
			return true;
		} else {
			return false;
		}
	}

	public void addPaths(List<Integer> paths) {
		this.path.clear();
		this.path.addAll(paths);
	}
	public int getSum() {
		return sum;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.sum);
	}
}
