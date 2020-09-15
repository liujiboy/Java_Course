/**
 * 
 */
package code0206;

/**
 * IfElseDemo.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class IfElseDemo {
	public static void main(String args[]) {
		int month = 9; // Sept
		String season;
		if (month == 12 || month == 1 || month == 2)
			season = "Winter";
		else if (month == 3 || month == 4 || month == 5)
			season = "Spring";
		else if (month == 6 || month == 7 || month == 8)
			season = "Summer";
		else if (month == 9 || month == 10 || month == 11)
			season = "Autumn";
		else
			season = "It is a wrong number!";
		System.out.println("Sept. is in the " + season + ".");
	}

}
