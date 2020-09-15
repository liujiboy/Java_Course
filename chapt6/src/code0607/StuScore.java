/**
 * 
 */
package code0607;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * ScoreMgt.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */

public class StuScore implements Comparable<StuScore>{
	String name;
	Map  score=new HashMap<String,Integer>();
	int sum=0;
	@Override
	public String toString() {
		
		return "姓名："+score;
	}

	@Override
	public int compareTo(StuScore o) {
		// TODO Auto-generated method stub
		return this.sum-o.sum;
	}
	//计算总成绩
	public void sum()
	{
		
		Collection c=this.score.values();
		Iterator<Integer> itr = c.iterator();
		while (itr.hasNext())
		{
			sum+=itr.next();
		}	
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   int count=5;
       ArrayList<StuScore>  scores=new ArrayList<StuScore>();
       Random r=new Random();
       //随机初始化学生成绩
      for(int i=0;i<count;i++)
      {
    	  StuScore s=new StuScore();
    	  s.name="学生"+i;
    	  s.score.put("语文", r.nextInt(100));
    	  s.score.put("数学", r.nextInt(100));
    	  scores.add(s);
    	  s.sum();
      }
	  System.out.println(scores);
	  //使用工具集排序
	  Collections.sort(scores);
	  for(StuScore s:scores)
	  {
		  System.out.println(s.name+"  "+s.sum);
	  }

	}

}
