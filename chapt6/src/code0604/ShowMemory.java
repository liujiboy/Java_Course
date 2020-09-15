/**
 * 
 */
package code0604;

 /**
 * ShowMemory.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class ShowMemory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Runtime r=Runtime.getRuntime();
		System.out.println("Java虚拟机总内存："+r.totalMemory());
		r.gc();//回收内存
		System.out.println("空闲内存1:"+r.freeMemory());
		//创建10000个字符串对象
		String[] ss=new String[1000000];
		for(int i=0;i<ss.length;i++)
		{
			ss[i]=new String("Java程序设计");
		}
		System.out.println("空闲内存2:"+r.freeMemory());
		for(int i=0;i<ss.length;i++)
		{
			ss[i]=null;
		}
		r.gc();//回收内存
		System.out.println("空闲内存3:"+r.freeMemory());
	}

}
