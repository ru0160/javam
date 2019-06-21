package com.javamentor.calculate.servise;

public class ConvertorRomeDigit {
	private static final String EXCEPTION_MESSAGE = "Wrong input format";
	String convert(char[] numberChar) {
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
}
