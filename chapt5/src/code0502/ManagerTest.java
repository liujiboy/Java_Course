/**
 * 
 */
package code0502;

/**
 * ManagerTest.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class ManagerTest {
    public static void main(String[] args) {
    	NewEmployee e= new NewEmployee("Harry Hacker", 50000, 1989, 10, 1);
        e.getName();
        System.out.println(e.getName()+":"+e.getSalary());
    	NewManager boss = new NewManager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);
        System.out.println(boss.getName()+":"+boss.getSalary());
       
    }
}
        