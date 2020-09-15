/**
 * 
 */
package code0406;
/**
 * EmployeeDirectory.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class EmployeeDirectory {

	    public static void main(String[] args) {
	    	Employee [] dir=new Employee[4];	    	
	        Employee e1 = new Employee();    //通过构造方法1先生成对象
	        e1.setName("zhangshan");         //再通过set方法赋值
	        e1.setSalary(100);
	        dir[0]=e1;
	        dir[1]=new Employee();           //通过构造方法1完成对象初始化
	        for(int i=2; i<=3;i++){
	        	dir[i]= new Employee("user"+i,200);	//通过构造方法2完成对象初始化        	
	        }
	        for(int j=0; j<=3;j++){
	        	 System.out.println("员工的姓名：" + dir[j].getName());
	 	         System.out.println("员工的工资：" + dir[j].getSalary());   	
	        }
	       
	
	    }
	}

