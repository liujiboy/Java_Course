/**
 * 
 */
package code0206;

 /**
 * Fibonacci.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class Fibonacci {


	public static void main(String[] args) {
	   long f1,f2,f3,n=50;
	   f1=f2=1;
	   System.out.print(f1+" "+f2+" ");
	   for(int i=3;i<=n;i++)
	   {
		   f3=f1+f2;
		   f1=f2;
		   f2=f3;
		   System.out.print(f3+" ");
		   if(i%10==0)
		   {
			   System.out.println();
		   }
	   }
	}

}
