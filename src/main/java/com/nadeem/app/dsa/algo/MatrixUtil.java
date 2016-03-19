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

	public static <T> void printMatrixInSpiralOrder(T[][] matrix) {

		int top = 0;
		int left = 0;
		int down = matrix.length - 1;
		int right = matrix[1].length - 1;

		while (true) {
			// print top
			for (int j = left; j <= right; j++) {
				System.out.print( String.format("%d ", matrix[top][j]));
			}
			top++;
			if (top > down || left > right) {
				return;
			}
			// print right
			for (int j = top; j <= down; j++) {
				System.out.print(String.format("%d ",matrix[j][right]));
			}
			right--;
			if (top > down || left > right) {
				return;
			}
			// print down
			for (int j = right; j >= left; j--) {
				System.out.print(String.format("%d ",matrix[down][j]));
			}
			down--;
			if (top > down || left > right) {
				return;
			}
			// print left
			for (int j = down; j >= top; j--) {
				System.out.print(String.format("%d ",matrix[j][left]));
			}
			left++;
			if (top > down || left > right) {
				return;
			}
		}
	}
	//Refer http://stackoverflow.com/questions/42519/how-do-you-rotate-a-two-dimensional-array for more detail
	public static<T> void roateMatrixBy90Degrees(T[][] matrix) {
		int layers = matrix.length/2;
		int length = matrix.length;
		for (int layer = 0; layer < layers; layer++) {
			for (int j = layer; j < length - layer - 1; j++) {
				//Save top first;
				T temp = matrix[layer][j];
				//Move left to top
				matrix[layer][j] = matrix[length - j -1][layer];
				//bottom to left
				matrix[length-1-j][layer]= matrix[length - layer-1][length - j -1];
				//right to bottom
				matrix[length - layer - 1][length - j-1] = matrix[j][length - layer-1];
				// top to right
				matrix[j][length -layer-1]= temp;
			}
		}
	}

	public static int countNegativesInSortedMatrix(Integer[][] matrix) {
		int row = 0;
		int column =  matrix[row].length - 1;
		int count = 0;
		 while (row < matrix.length && column >= 0) {
			 if (matrix[row][column] < 0) {
				count = count + column + 1;
				row ++;
			} else {
				column --;
			}
		 }
	
		return count;
	}

	
}
