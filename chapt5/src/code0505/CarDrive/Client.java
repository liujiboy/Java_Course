/**
 * 
 */
package code0505.CarDrive;

/**
 * Client.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class Client {
	public static void main(String[] args) {
		IDriver zhangSan = new Driver(); 
		ICar benz = new Benz(); 
		//开奔驰车 
		zhangSan.drive(benz); 
		//开宝马车
		ICar bmw=new BMW();
		zhangSan.drive(bmw); 
		} 

}
