/**
 * 
 */
package code0502;

/**
 * NewManager.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
class NewManager extends NewEmployee {
	private double bonus;
	public NewManager(String n, double s, int year, int month, int day) {
		super(n, s, year, month, day);
		bonus = 0;
	}

	public double getSalary() {
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}

	public void setBonus(double b) {
		bonus = b;
	}

}
