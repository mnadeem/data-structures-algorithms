package com.nadeem.app.dsa.algo;

import java.util.ArrayList;
import java.util.List;

public class MaxSumPath {
	private List<Integer> path;
	private int maxSum;
	private int currentSum;
	
	public MaxSumPath(int maxSumSoFar) {
		this(0, maxSumSoFar);
	}
	
	public MaxSumPath(int currentSum, int maxSumSoFar) {
		this.maxSum = maxSumSoFar;
		this.currentSum = currentSum;
		this.path = new ArrayList<Integer>();
	}

	public List<Integer> getPath() {
		return path;
	}

	public boolean updateSum(int newSum) {
		if (newSum > maxSum) {
			this.maxSum = newSum;
			return true;
		} else {
			return false;
		}
	}

	public void addPaths(List<Integer> paths) {
		this.path.clear();
		this.path.addAll(paths);
	}
	public int getMaxSum() {
		return maxSum;
	}

	public int getCurrentSum() {
		return currentSum;
	}

	public void setCurrentSum(int currentSum) {
		this.currentSum = currentSum;
	}

	@Override
	public String toString() {
		return String.valueOf(this.maxSum);
	}
}
