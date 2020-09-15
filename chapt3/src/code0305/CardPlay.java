/**
 * 
 */
package code0305;

/**
 * CardPlay.java
 * Copyright (c) 2016 ChongQing University All rights reserved.
 */
import java.util.*;
public class CardPlay{
	public static void main(String[] args){
		int[] total = new int[108];   //存储108张牌的数组, 定义方法参见3.2.1
		int[][] player = new int[4][25];   //存储四个玩家的牌，定义方法参见3.3.1
		int leftNum = 108;         //当前剩余牌的数量
		int ranNumber;
		Random random = new Random();  //生成Random对象，用以生成随机数
		for(int i = 0;i < total.length;i++){    //初始化一维数组
			total[i] = (i + 1) % 54;
			if(total[i] == 0){          //处理大小王编号
				total[i] = 54;
			}
		}
//循环发牌
		for(int i = 0;i < 25;i++){//为每个人发牌
			for(int j = 0;j < player.length;j++){ //生成随机下标
				ranNumber = random.nextInt(leftNum); // random.nextInt()方法生成随机数
				player[j][i] = total[ranNumber];        //发牌
				total[ranNumber] = total[leftNum - 1];   // 删除已经发过的牌
				leftNum--;
			}
		}
//循环输出玩家手中的牌
		for(int i = 0;i < player.length;i++){  //通过两层循环遍历二维数组，参见知识点3.3.2
			System.out.print("玩家" + i+ ":的牌");
			for(int j = 0;j < player[i].length;j++){
				System.out.print(" " + player[i][j]);
			}
			System.out.println();
		}	
//底牌
		System.out.print("底牌:");
		for(int i = 0;i < 8;i++){
			System.out.print(" " + total[i]);
		}
		System.out.println();
	}
}

