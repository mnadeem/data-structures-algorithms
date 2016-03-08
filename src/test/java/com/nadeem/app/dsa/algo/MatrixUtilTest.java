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

}
