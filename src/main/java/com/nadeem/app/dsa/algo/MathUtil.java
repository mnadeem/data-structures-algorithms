package com.nadeem.app.dsa.algo;

public class MathUtil {

	public static int iGCD(int a, int b) {
		int first = a > b ? a : b;
		int second = b < a ? b : a;
		int remainder = second;
		
		while (first%second != 0) {
			remainder = first%second;
			first = second;
			second = remainder;			
		}
		return remainder;
	}

	public static int rGCD(int first, int second) {
		if (first%second==0) {
			return second;
		} else {
			return rGCD(second, first%second);
		}
	}

}
