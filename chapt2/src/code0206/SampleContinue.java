/**
 * 
 */
package code0206;

 /**
 * SampleContinue.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class SampleContinue {
	 public static void main(String args[])
	    {
	        for (int i = 1; i < 20; i++) {
	            System.out.print(i + " ");
	            if (i % 5 != 0)
	                continue;
	            System.out.println("");
	        }
	    }

}
