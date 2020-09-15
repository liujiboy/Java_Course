/**
 * 
 */
package code0406;

/**
 * Employee.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class Employee {
    
    private String name;		//员工的姓名
    private double salary;		//员工的工资
 
    Employee(){
    	name="unknown";
    	salary=0;    	
    }
    Employee(String n, double s){
    	name=n;
    	salary=s;   
    }
    public String getName() {		//获取员工的姓名
        return name;
    }
    
    public void setName(String name) {	//设置员工的姓名
        this.name = name;
    }
    
    public double getSalary() {		//获取员工的工资
        return salary;
    }
    
    public void setSalary(double salary) {	//设置员工的工资
        this.salary = salary;
    }   
    
}
