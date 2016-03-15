package com.nadeem.app.dsa.algo.stream;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {

	PriorityQueue<Integer> lower = new PriorityQueue<Integer>(10, new MaxHeapComparator());
	PriorityQueue<Integer> higher = new PriorityQueue<Integer>();

	public void insert(Integer data) {
		if (lower.isEmpty() && higher.isEmpty()) {
			lower.add(data);
		} else{
			if (lower.peek() >= data) {
				lower.add(data);
			} else {
				higher.add(data);
			}
		}
		rebalance();
	}

	private void rebalance() {
		if (lower.size() < higher.size() - 1) {
			lower.add(higher.remove());
		} else if (higher.size() < lower.size() - 1) {
			higher.add(lower.remove());
		}		
	}

	public Double get() {
		if (lower.isEmpty() && higher.isEmpty()) {
			return null;
		} else if (lower.size() == higher.size()) {
			return (lower.peek() + higher.peek()) / 2.0;
		}
		Integer median = lower.size() > higher.size() ? lower.peek() : higher.peek();
		return Double.valueOf(median);
	}

	private static class MaxHeapComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}		
	}
}
