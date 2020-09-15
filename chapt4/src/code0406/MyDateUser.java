/**
 * 
 */
package code0406;

/**
 * MyDateUser.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class MyDateUser {
	public static void main(String args[]) {
		MyDate mydate = new MyDate ();
		//mydate.day = 21;                        //一旦将该行注释取消就会出现错误
		//System.out.println("day="+mydate.day)   //一旦将该行注释取消就会出现错误
		mydate.setDay(21);                        //正确
 }
}