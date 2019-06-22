package com.javamentor.calculate.servise;

public class MatematicOperationsNumber {
	private static final String EXCEPTION_MESSAGE = "Wrong input format";

	private int addition(int addendsOne, int addendsTwo) {
		int sum = addendsOne + addendsTwo;
		return sum;
	}

	private int subtraction(int minuend, int subtrahend) {
		int difference = minuend - subtrahend;
		return difference;
	}

	private int multiplication(int multiplicands, int multiplier) {
		int product = multiplicands * multiplier;
		return product;
	}

	private int division(int dividend, int divisor) {
		int quotient = dividend / divisor;
		return quotient;
	}

	int calculateExpressions(int firstNumberInt, int secondNumberInt, String action) {
		int result = 0;
		if (action.equals("+")) {
			result = addition(firstNumberInt, secondNumberInt);
		} else if (action.equals("-")) {
			result = subtraction(firstNumberInt, secondNumberInt);
		} else if (action.equals("*")) {
			result = multiplication(firstNumberInt, secondNumberInt);
		} else if (action.equals("/")) {
			result = division(firstNumberInt, secondNumberInt);
		} else {
			throw new IllegalArgumentException(EXCEPTION_MESSAGE);
		}
		return result;
	}
}
