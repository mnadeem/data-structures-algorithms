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

	// http://codereview.stackexchange.com/questions/41707/count-the-one-islands-in-the-matrix
	public static int numberOfIslands(int[][] m) {
		int rows = m.length;
		int columns = m[0].length;
		boolean[][] visited = new boolean[rows][columns];
		int count = 0;

		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if (m[row][column] == 1 && !visited[row][column]) {
					dfs(m, row, column, visited);
					count++;
				}				
			}
		}

		return count;
	}
	
	private static void dfs(int[][] m, int row, int column, boolean[][] visited) {
		visited[row][column] = true;
		for (Direction direction : Direction.values()) {
			int newRow = row + direction.getRowDelta();
			int newColumn = column + direction.getColumnDelta();
			if (isValid(m, newRow, newColumn, visited)) {
				dfs(m, newRow, newColumn, visited);
			}
		}
	}

	private static boolean isValid(int[][] m, int row, int column, boolean[][] visited) {
		if (row >= 0 && row < m.length &&
				column >=0 && column < m[0].length &&
				m[row][column] == 1 &&
				!visited[row][column]) {
			return true;
		}
		return false;
	}

	private enum Direction {
		N(-1, 0),NE(-1, 1), E(0, 1),  SE(1,1), S(1, 0), SW(1, -1), W(0, -1), NW(-1, -1);
		
		private int rowDelta;
		private int columnDelta;

		private Direction(int rowDelta, int columnDelta) {
			this.rowDelta = rowDelta;
			this.columnDelta = columnDelta;
		}

		public int getRowDelta() {
			return rowDelta;
		}

		public int getColumnDelta() {
			return columnDelta;
		}

		@Override
		public String toString() {
			return String.format("%s(%d, %d)", this.name(), this.getRowDelta(), this.getColumnDelta());
		}
	}
}
