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

}
