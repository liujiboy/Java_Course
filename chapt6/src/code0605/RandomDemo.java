package code0605;

import java.util.Random;

public class RandomDemo {
	public static void main(String[] args) {
		Random r = new Random();// 实例化一个Random类
		System.out.println("随机产生一个整数:" + r.nextInt());
		System.out.println("随机产生一个大于等于0小于10的整数：  " + r.nextInt(10));
		System.out.println("随机产生一个布尔型的值：" + r.nextBoolean());
		System.out.println("随机产生一个双精度型的值：" + r.nextDouble());
		System.out.println("随机产生一个浮点型的值：" + r.nextFloat());
		System.out.println("随机产生一个概率密度为高斯分布的双精度值：  " + r.nextGaussian());
	}
}
