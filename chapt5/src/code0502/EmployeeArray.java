/**
 * 
 */
package code0502;

/**
 * EmployeeArray.java Copyright (c) 2016 ChongQing University All rights
 * reserved.
 */
public class EmployeeArray {
	public static void main(String[] args) {
		NewEmployee[] staff = new NewEmployee[3];
		NewManager boss = new NewManager("Carl", 80000, 1987, 12, 15);
		boss.setBonus(5000);
		staff[0] = boss;
		staff[1] = new NewEmployee("Harry", 50000, 1989, 10, 1);
		staff[2] = new NewEmployee("Tommy", 40000, 1990, 3, 15);
		for (NewEmployee e : staff)
			System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
	}

}
