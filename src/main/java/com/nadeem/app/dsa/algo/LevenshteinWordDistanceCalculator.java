package com.nadeem.app.dsa.algo;

public class LevenshteinWordDistanceCalculator {

	public static final LevenshteinWordDistanceCalculator DEFAULT = new LevenshteinWordDistanceCalculator(1, 1, 1);

	private final int substitutionCost;
	private final int deletionCost;
	private final int insertionCost;

	public LevenshteinWordDistanceCalculator(int costOfSubstitution, int costOfDeletion, int costOfInsertion) {
		substitutionCost = costOfSubstitution;
		deletionCost = costOfDeletion;
		insertionCost = costOfInsertion;
	}

	public int calculate(CharSequence source, CharSequence target) {

		int sourceLength = source.length();
		int targetLength = target.length();

		int[][] grid = new int[sourceLength + 1][targetLength + 1];

		grid[0][0] = 0;

		// source prefixes can be transformed into empty string by dropping all
		// characters (A move straight down/up is a deletion)
		// i.e If target string is empty, only option is to remove all
		// characters of target string
		for (int row = 1; row <= sourceLength; row++) {
			grid[row][0] = row;
		}

		// target prefixes can be reached from empty source prefix by inserting
		// every character (A move to the right/left is an insertion;)
		// i.e. If source string is empty, only option is to insert all
		// characters of target string
		for (int col = 1; col <= targetLength; col++) {
			grid[0][col] = col;
		}

		for (int row = 1; row <= sourceLength; row++) {
			for (int col = 1; col <= targetLength; col++) {
				grid[row][col] = minimumCost(source, target, grid, row, col);
			}
		}

		return grid[sourceLength][targetLength];
	}

	private int minimumCost(CharSequence source, CharSequence target, int[][] grid, int row, int col) {
		return min(substitutionCost(source, target, grid, row, col),
					deleteCost(grid, row, col),
					insertCost(grid, row, col));
	}

	// a move diagonally down is a substitution;
	private int substitutionCost(CharSequence source, CharSequence target, int[][] grid, int row, int col) {
		int cost = 0;
		if (source.charAt(row - 1) != target.charAt(col - 1)) {
			cost = substitutionCost;
		}
		return grid[row - 1][col - 1] + cost;
	}

	// A move straight down/up is a deletion
	private int deleteCost(int[][] grid, int row, int col) {
		return grid[row - 1][col] + deletionCost;
	}

	// A move to the right/left is an insertion
	private int insertCost(int[][] grid, int row, int col) {
		return grid[row][col - 1] + insertionCost;
	}

	private static int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}
}
