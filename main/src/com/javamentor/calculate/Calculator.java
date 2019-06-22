package com.javamentor.calculate;

import com.javamentor.calculate.io.ConsoleReader;
import com.javamentor.calculate.servise.Calculation;

public class Calculator {
	private static final String MENU_TITLE_CHOISE = "Make a choice :";
	private static final String MENU_ITEM_CALCULATOR = "1 - Calculator";
	private static final String MENU_ITEM_EXIT = "2 - exit";
	private static final String GOODBYE = "Goodbye";
	private static final String MESSAGE_INPUT = "Input:";
	private static final String MESSAGE_OUTPUT = "Output";
	private ConsoleReader consoleReader;
	private Calculation calculation;

	private Calculator(ConsoleReader consoleReader, Calculation calculation) {
		this.consoleReader = consoleReader;
		this.calculation = calculation;
	}

	public static void main(String[] args) {
		ConsoleReader consoleReader = new ConsoleReader();
		Calculation calculation = new Calculation();
		Calculator calculate = new Calculator(consoleReader, calculation);
		calculate.runMenu();
	}

	private void runMenu() {
		boolean exit = false;
		do {
			printMenu();
			String choice = consoleReader.readLine();
			switch (choice) {
			case "1":
				runCalculator();
				break;

			case "2":
				printLineToConsole(GOODBYE);
				exit = true;
				break;

			default:
				break;
			}
		} while (!exit);
	}

	private void runCalculator() {
		printLineToConsole(MESSAGE_INPUT);
		String input = consoleReader.readLine();
		printLineToConsole(MESSAGE_OUTPUT);
		String output = calculation.inputToChar(input);
		printLineToConsole(output);

	}

	private void printLineToConsole(String stringToPrint) {
		System.out.println(stringToPrint);
	}

	private void printMenu() {
		printLineToConsole(MENU_TITLE_CHOISE);
		printLineToConsole(MENU_ITEM_CALCULATOR);
		printLineToConsole(MENU_ITEM_EXIT);
	}
}
