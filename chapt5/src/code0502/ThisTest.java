/**
 * 
 */
package code0502;

/**
 * ThisTest.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class ThisTest {
    public static void main(String[] args) {
        Local aa = new Local();
    }   
}
class Local { 
    public int i = 1;                                           //这个i是成员变量
    Local(int i) {                                              //这个i是局部变量
        System.out.println("this.i ="+ this.i);              //this.i指的是对象本身的成员变量i
        System.out.println("i = "+i);                       //这里的i是局部变量i
    }  
    Local(){
    	this(6);                                           //
    }
}