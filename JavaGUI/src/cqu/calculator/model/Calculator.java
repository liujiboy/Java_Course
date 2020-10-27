package cqu.calculator.model;

import java.util.Arrays;

public class Calculator {
	private static final char operators[] = {'*', '+', '-', '/' };
	private String state = "S1";
	private Double result = 0.0;
	private char operator;
	private String input = "";

	public Double readInput(char c) {

		switch (state) {
		case "S1":
			return s1(c);
		case "S2":
			return s2(c);
		case "S3":
			return s3(c);
		case "S4":
			return s4(c);
		case "S5":
			return s5(c);
		}
		return null;
	}

	private Double s5(char c) {
		if (c == 'C') {
			state = "S1";
			result = 0.0;
			input = "";
			return 0.0;
		} else if (Character.isDigit(c) || c == '.') {
			state = "S3";
			input += c;
			return Double.parseDouble(input);
		} else if (c == '=') {
			state = "S4";
			switch (operator) {
			case '+':
				result += Double.parseDouble(input);
				break;
			case '-':
				result -= Double.parseDouble(input);
				break;
			case '*':
				result *= Double.parseDouble(input);
				break;
			case '/':
				result /= Double.parseDouble(input);
				break;
			}
			input = "";
			return result;
		} else if (Arrays.binarySearch(operators, c) >= 0) {
			state = "S5";
			switch (operator) {
			case '+':
				result += Double.parseDouble(input);
				break;
			case '-':
				result -= Double.parseDouble(input);
				break;
			case '*':
				result *= Double.parseDouble(input);
				break;
			case '/':
				result /= Double.parseDouble(input);
				break;
			}
			input = "";
			operator = c;
			return result;
		}
		return result;
	}
	//输出结果
	private Double s4(char c) {
		if (c == 'C') {
			state = "S1";
			result = 0.0;
			input = "";
			return 0.0;
		} else if (Character.isDigit(c) || c == '.') {
			state="S2";
			result = 0.0;
			input = "";
			input += c;
			return Double.parseDouble(input);
		} else if (c == '=') {
			state="S4";
		} else if (Arrays.binarySearch(operators, c) >= 0) {
			state="S3";
			input = "";
			operator = c;
			return 0.0;
		}
		return result;

	}

	private Double s3(char c) {
		if (c == 'C') {
			state = "S1";
			result = 0.0;
			input = "";
			return 0.0;
		} else if (Character.isDigit(c) || c == '.') {
			state = "S3";
			if (c == '.' && input.indexOf(".") == -1)
				input += c;
			else if (c != '.')
				input += c;
			return Double.parseDouble(input);
		} else if (c == '=') {
			state = "S4";
			switch (operator) {
			case '+':
				result += Double.parseDouble(input);
				break;
			case '-':
				result -= Double.parseDouble(input);
				break;
			case '*':
				result *= Double.parseDouble(input);
				break;
			case '/':
				result /= Double.parseDouble(input);
				break;
			}
			input = "";
			return result;
		} else if (Arrays.binarySearch(operators, c) >= 0) {
			state = "S5";
			switch (operator) {
			case '+':
				result += Double.parseDouble(input);
				break;
			case '-':
				result -= Double.parseDouble(input);
				break;
			case '*':
				result *= Double.parseDouble(input);
				break;
			case '/':
				result /= Double.parseDouble(input);
				break;
			}
			input = "";
			operator = c;
			return result;
		}
		return 0.0;
	}

	private Double s2(char c) {
		if (c == 'C') {
			state = "S1";
			result = 0.0;
			input = "";
			return 0.0;
		} else if (Character.isDigit(c) || c == '.') {
			state = "S2";
			if (c == '.' && input.indexOf(".") == -1)
				input += c;
			else if (c != '.')
				input += c;
			return Double.parseDouble(input);
		} else if (c == '=') {
			state = "S4";
			result = Double.parseDouble(input);
			return result;

		} else if (Arrays.binarySearch(operators, c) >= 0) {
			state = "S3";
			result = Double.parseDouble(input);
			input = "";
			operator = c;
			return result;
		}
		return 0.0;

	}

	private Double s1(char c) {
		if (c == 'C' || c == '=') {
			state = "S1";
			return 0.0;
		} else if (Character.isDigit(c) || c == '.') {
			state = "S2";
			input += c;
			return Double.parseDouble(input);
		} else if (Arrays.binarySearch(operators, c) >= 0) {
			state = "S3";
			operator = c;
			return 0.0;
		}
		return 0.0;
	}
}
