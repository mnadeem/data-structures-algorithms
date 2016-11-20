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

	//https://en.wikipedia.org/wiki/Exponentiation_by_squaring
	public static double rXPowerYInLogN(int a, int n) {
		if (n ==  0) {
			return 1;
		}
		double result = rXPowerYInLogN(a, n/2);
		if (n % 2 == 0) {
			return result*result;
		} else {
			return a*result*result;
		}
	}

	public static double iXPowerYInLogN(int a, int n) {
		double result = 1;
		while(n > 0) {
			if (n % 2 == 1) {
				result = result * a;
			}
			a = a * a;
			n = n >> 1;
		}
		
		return result;
	}
}
