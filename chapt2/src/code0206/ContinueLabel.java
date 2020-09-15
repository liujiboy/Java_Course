/**
 * 
 */
package code0206;

 /**
 * ContinueLabel.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class ContinueLabel {
	  public static void main(String args[])
	    {
	        outer: for (int i = 1; i < 10; i++) {
	            for (int j = 1; j < 10; j++) {
	                if (j > i) {
	                    System.out.println();
	                    continue outer;
	                }
	                System.out.print(" " + (i * j));
	            }
	        }
	        System.out.println();
	    }

}
