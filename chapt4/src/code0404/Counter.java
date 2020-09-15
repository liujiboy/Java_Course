/**
 * 
 */
package code0404;

/**
 * Counter.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class Counter {
    public static int num = 0;
     public Counter() {
         num ++;
         System.out.println("after new NO=" + num);
     }
    
     public static void delete(Counter o) {
        num --;
        System.out.println("after delete NO=" + num);
        o=null;
        System.gc();
     }
     public static void main(String [] args) {
    	 Counter [] objs = new Counter[5];
         for(Counter obj: objs) {
             obj = new Counter();
         }
         Counter.delete(objs[1]);
         Counter.delete(objs[0]);
     }
}