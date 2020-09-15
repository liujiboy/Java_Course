/**
 * 
 */
package code0502;

import java.util.*;

/**
 * Employee.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
class NewEmployee {
	private String name;
	private double salary;
	private Date hireDay;

	public NewEmployee(String n, double s, int year, int month, int day) {
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		hireDay = calendar.getTime();
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public Date getHireDay() {
		return hireDay;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

}
