/**
 * 
 */
package code0303;

/**
 * SumAll.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class SumAll{
	public static void main(String args[]){
	int total=0;
	int arr[][]=new int[3][4];
	for(int i=0;i<arr.length;i++){        //初始化并显示二维数组
		for(int j=0;j<arr[i].length;j++){
			arr[i][j]=i+j;
			System.out.print(" " + arr[i][j]);
		}
		System.out.println();
	}
	for(int i=0;i<arr.length;i++)        //求和
		for(int j=0;j<arr[i].length;j++){
			total = total +arr[i][j];			
		}
	System.out.println(" The Sum is:"+total);
 }
}
