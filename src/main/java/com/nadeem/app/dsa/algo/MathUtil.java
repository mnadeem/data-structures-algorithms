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
	
	public static int multiplyWithUsingAsteric(int a, int b) {
		return (int) Math.pow(10, (Math.log10(a) + Math.log10(b)));
	}
	
	public static double powerXPowerYInLogN(int x, int y) {
		if (y ==  0) {
			return 1;
		}
		double d = powerXPowerYInLogN(x, y/2);
		if (y % 2 == 0) {
			return d*d;
		} else {
			return x*d*d;
		}
	}
}
