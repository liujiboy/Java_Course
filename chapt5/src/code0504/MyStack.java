/**
 * 
 */
package code0504;

/**
 * MyStack.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */

class MyStack extends Access { //定义栈类
	private LinkedList bottom=new LinkedList();
	private LinkedList top=bottom; //初始化栈顶与栈底

	/** 实现接口Access的put()方法，该方法向栈存一个字符 */
	public void put(char c){ 
		top.forward=new LinkedList();
		top.forward.data=c;
		top.forward.back=top;
		top=top.forward;
	}

	/** 实现接口Access的get()方法，该方法从栈中取一个字符 */
	public char get(){ 
		if(top!=bottom){ //如果栈不为空则取数
		  char ch=top.data;
		  top.back.forward=null;
		  top=top.back;
		  return ch;
		}
		else{ 
		  System.out.println("The stack is empty!");
		  return '\0';
		}
	}
}

