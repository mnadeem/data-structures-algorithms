package com.nadeem.app.dsa.algo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MatrixUtilTest {

	@Test
	public void longestPathTest() {
		int[][] mat = {{1, 2, 9},
				        {5, 3, 8},
				        {4, 6, 7}
				      };
		int longestPathLength = MatrixUtil.longestPath(mat);
		assertThat(longestPathLength, is(equalTo(4)));
	}
	
	@Test
	public void countIslandsTest() {
		int[][] m = { { 1, 1, 0, 0 },
					  { 0, 0, 0, 1 },
					  { 0, 0, 1, 1 }
					};
		int result = MatrixUtil.numberOfIslands(m);
		assertThat(result, equalTo(2));
		
		m = new int[][]{ {1, 1, 0, 0, 0},
				  {0, 1, 0, 0, 1},
				  {0, 0, 0, 1, 1},
				  {0, 0, 0, 0, 0},
				  {0, 0, 0, 0, 1}
				};
		result = MatrixUtil.numberOfIslands(m);
		assertThat(result, equalTo(3));
		
	}
	
	@Test
	public void printMatrixInSpiralOrderTest() {
		Integer[][] matrix = new Integer[][] { { 1, 2, 3 ,4}, 
										{ 5,6,7,8}, 
										{ 9,10,11,12 } };
										MatrixUtil.<Integer>printMatrixInSpiralOrder(matrix);
		
	}
	
	@Test
	public void rotateMatrixBy90DegreesTest() {
		Integer[][] matrix = new Integer[][] { { 1, 2, 3 }, 
												{ 4,5,6}, 
												{ 7,8,9} };
		Integer[][] result = new Integer[][] { { 7,4,1}, 
												{ 8,5,2}, 
												{ 9,6,3} };										
												
												MatrixUtil.<Integer>roateMatrixBy90Degrees(matrix);
		assertThat(matrix, equalTo(result));
	}

	@Test
	public void countNegativesInSortedMatrix() {
		Integer[][] matrix = new Integer[][] { { -2, -1, 3 ,4}, 
											   { -5,6,7,8}, 
											   { -9,-8,11,12 } };
											   
		int count = MatrixUtil.countNegativesInSortedMatrix(matrix);
		assertThat(count, equalTo(5));
	}

}
