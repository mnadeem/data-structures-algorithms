package com.nadeem.app.dsa.algo;

public class MatrixUtil {

	public static int longestPath(int[][] mat) {
		int rows = mat.length;
		int columns = mat[0].length;
		int maxLength = 0;
		int temp[][] = buildTempResultArray(rows, columns);
		 for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if (temp[row][column] == -1) {
					findLongestPath(mat, row, column, temp);
				}
				maxLength = Math.max(maxLength, temp[row][column]);
			}
		}
		
		return maxLength;
	}

	private static int findLongestPath(int[][] mat, int row, int column, int[][] temp) {
		if(row < mat.length - 1 && mat[row][column] + 1 == mat[row+1][column]) {
			return temp[row][column] = 1 + findLongestPath(mat, row + 1, column, temp);
		}
		if(row > 0 && mat[row][column] + 1 == mat[row-1][column]) {
			return temp[row][column] = 1 + findLongestPath(mat, row - 1, column, temp);
		}
		if(column < mat[row].length - 1 && mat[row][column] + 1 == mat[row][column + 1]) {
			return temp[row][column] = 1 + findLongestPath(mat, row, column + 1, temp);
		}
		if(column > 0 && mat[row][column] + 1 == mat[row][column] - 1) {
			return temp[row][column] = 1 + findLongestPath(mat, row, column - 1, temp);
		}
		
		return temp[row][column] = 1;
	}

	private static int[][] buildTempResultArray(int rows, int columns) {
		int temp[][] = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				temp[i][j] = -1;
			}
		}
		return temp;
	}

}
