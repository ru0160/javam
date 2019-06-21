package com.javamentor.calculate.servise;

import static org.apache.commons.lang3.StringUtils.SPACE;

public class ConvertNumbers {
	private static final String EXCEPTION_MESSAGE_ROMAN_OR_ARABIC = "Both numbers must be Arabic or Roman";
	private static final String EXCEPTION_MESSAGE_WRONG_INPUT_NUMBER = "Both numbers must be between 1 and 10";
	private static final String EXCEPTION_MESSAGE_NULL = "Null is not supported!";
	private static final String EXCEPTION_MESSAGE_WRONG_FORMAT = "Wrong input format";
	Ñalculation calculation = new Ñalculation();
	ConvertorRomeDigit convertorRomeDigit = new ConvertorRomeDigit();

	public String inputToChar(String input) {
		if (input == null) {
			throw new IllegalArgumentException(EXCEPTION_MESSAGE_NULL);
		}
		String[] inputExpressionStringArray = input.split(SPACE);
		if (inputExpressionStringArray.length != 3) {
			throw new IllegalArgumentException(EXCEPTION_MESSAGE_WRONG_FORMAT);
		}
		char[] firstNumberChar = inputExpressionStringArray[0].toCharArray();
		char[] secondNumberChar = inputExpressionStringArray[2].toCharArray();
		String action = inputExpressionStringArray[1];
		String tempFirst = new String();
		boolean firstNumberRoman = false;
		for (int i = 0; i < firstNumberChar.length; i++) {
			if (Character.isDigit(firstNumberChar[i])) {
				tempFirst = tempFirst + String.valueOf(firstNumberChar[i]);
			} else {
				tempFirst = convertorRomeDigit.convert(firstNumberChar);
				firstNumberRoman = true;
			}
		}
		int firstNumberInt = Integer.parseInt(tempFirst);
		String tempSecond = new String();
		boolean secondNumberRoman = false;
		for (int i = 0; i < secondNumberChar.length; i++) {
			if (Character.isDigit(secondNumberChar[i])) {
				tempSecond = tempSecond + String.valueOf(secondNumberChar[i]);
			} else {
				tempSecond = convertorRomeDigit.convert(secondNumberChar);
				secondNumberRoman = true;
			}
		}
		if (firstNumberRoman != secondNumberRoman) {
			throw new IllegalArgumentException(EXCEPTION_MESSAGE_ROMAN_OR_ARABIC);
		}
		int secondNumberInt = Integer.parseInt(tempSecond);
		if (firstNumberInt < 1 || firstNumberInt > 10 || secondNumberInt < 1 || secondNumberInt > 10) {
			throw new IllegalArgumentException(EXCEPTION_MESSAGE_WRONG_INPUT_NUMBER);
		}
		int result = calculation.calculateExpressions(firstNumberInt, secondNumberInt, action);
		return String.valueOf(result);
	}

}
