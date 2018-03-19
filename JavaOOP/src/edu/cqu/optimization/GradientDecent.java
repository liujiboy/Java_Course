package edu.cqu.optimization;

import java.util.Arrays;

public class GradientDecent {

	public double[] minmize(Function f, TrainingData[] datas) {
		double[] parameters = f.initialGuess();
		int loop=0;
		double lambda = 1;
		while (true) {
			boolean flag=true;
			System.out.printf("开始第%d轮梯度下降尝试...\n",loop);
			double totalError = totalError(f, datas, parameters);
			double[] totalErrorGradient = totalErrorGradient(f, datas, parameters);
			for (int iter = 0; iter < 20; iter++) {
				System.out.printf("第%d轮第%d次梯度下降，lambda为：%.10f\n",loop,iter,lambda);
				double[] newParameters = new double[parameters.length];
				Arrays.fill(newParameters, 0);
				for (int i = 0; i < parameters.length; i++) {
					newParameters[i] = parameters[i] - lambda * totalErrorGradient[i];
				}
				double newTotalError = totalError(f, datas, newParameters);
				System.out.printf("梯度下降前误差为：%.32f，下降后误差为：%.32f\n", totalError,newTotalError);
				if (newTotalError <totalError-1e-32 ) {
					parameters = newParameters;
					flag=false;
					System.out.printf("梯度下降成功，模型参数为:");
					for(double p:newParameters)
					{
						System.out.printf("%.32f,",p);
					}
					System.out.printf("\n");
					lambda *=2;
					break;
				} else {
					lambda *= 0.5;
					System.out.printf("梯度下降失败，lambda降为：%.32f\n", lambda);
				}
			}
			if(flag)
				break;
			loop++;
		}
		return parameters;
	}

	private double[] totalErrorGradient(Function f, TrainingData[] datas, double[] parameters) {
		double[] totalErrorGradient = new double[parameters.length];
		Arrays.fill(totalErrorGradient, 0);
		for (TrainingData data : datas) {
			double y = f.value(data.x, parameters);
			double[] gradient = f.gradient(data.x, parameters);
			for (int i = 0; i < gradient.length; i++) {
				totalErrorGradient[i] += (y-data.y) * gradient[i];
			}
		}
		return totalErrorGradient;
	}

	private double totalError(Function f, TrainingData[] datas, double[] parameters) {
		double totalError = 0;
		for (TrainingData data : datas) {
			double y = f.value(data.x, parameters);
			totalError += 0.5 * (y-data.y) * (y-data.y);
		}
		return totalError;
	}
}
