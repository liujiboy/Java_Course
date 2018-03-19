package edu.cqu.optimization;

import java.util.Random;

public class TestFunction2 {

	public static void main(String[] args) {
		TrainingData[] datas=new TrainingData[10];
		Function f=new Function2();
		double[] parameters= {2,1};
		Random r=new Random();
		//准备训练数据
		for(int i=0;i<datas.length;i++)
		{
			double[] x= {r.nextDouble(),r.nextDouble()};
			double y=f.value(x, parameters);
			datas[i]=new TrainingData(x,y);
		}
		GradientDecent gd=new GradientDecent();
		double[] trainedParameters=gd.minmize(f, datas);
		for(double p:trainedParameters)
		{
			System.out.printf("%.32f,",p);
		}

	}

}
