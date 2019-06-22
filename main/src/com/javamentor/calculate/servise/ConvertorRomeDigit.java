package com.javamentor.calculate.servise;

public class ConvertorRomeDigit {
	private static final String EXCEPTION_MESSAGE = "Wrong input format";

	String convertRomeToArab(char[] numberChar) {
		String numberCharToString = new String(numberChar);
		String result = new String();
		if (numberCharToString.equals("I")) {
			result = "1";
		} else if (numberCharToString.equals("II")) {
			result = "2";
		} else if (numberCharToString.equals("III")) {
			result = "3";
		} else if (numberCharToString.equals("IV")) {
			result = "4";
		} else if (numberCharToString.equals("V")) {
			result = "5";
		} else if (numberCharToString.equals("VI")) {
			result = "6";
		} else if (numberCharToString.equals("VII")) {
			result = "7";
		} else if (numberCharToString.equals("VIII")) {
			result = "8";
		} else if (numberCharToString.equals("IX")) {
			result = "9";
		} else if (numberCharToString.equals("X")) {
			result = "10";
		} else {
			throw new IllegalArgumentException(EXCEPTION_MESSAGE);
		}
		return result;
	}

	String romanDigit(int n, String one, String five, String ten) {
		if (n >= 1) {
			if (n == 1) {
				return one;
			} else if (n == 2) {
				return one + one;
			} else if (n == 3) {
				return one + one + one;
			} else if (n == 4) {
				return one + five;
			} else if (n == 5) {
				return five;
			} else if (n == 6) {
				return five + one;
			} else if (n == 7) {
				return five + one + one;
			} else if (n == 8) {
				return five + one + one + one;
			} else if (n == 9) {
				return one + ten;
			}

		}
		return "";
	}

	public String convertArabToRome(int number) {
		String romanOnes = romanDigit(number % 10, "I", "V", "X");
		number /= 10;
		String romanTens = romanDigit(number % 10, "X", "L", "C");
		number /= 10;
		String romanHundreds = romanDigit(number % 10, "C", "D", "M");
		number /= 10;
		String result = romanHundreds + romanTens + romanOnes;
		return result;
	}
}
