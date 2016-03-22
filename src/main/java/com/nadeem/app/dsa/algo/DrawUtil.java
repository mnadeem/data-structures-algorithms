package com.nadeem.app.dsa.algo;

public class DrawUtil {

	public static void drawPascalTriangle(int n) {
		for (int line = 1; line <= n; line++) {
			int C = 1;
			for (int i = 1; i <= line; i++) {
				System.out.print(String.format("%d ",  C));
				C = C * (line - i) / i;  
			}
			System.out.println();
		}
	}
}
