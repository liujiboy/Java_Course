package edu.cqu;

import java.util.ArrayList;

public class Stack<E>  {
	private ArrayList<E> es=new ArrayList<E>();
	public void push(E e)
	{
		es.add(e);
	}
	public E pop()
	{
		
		E e=es.get(es.size()-1);
		es.remove(es.size()-1);
		return e;
	}
}
