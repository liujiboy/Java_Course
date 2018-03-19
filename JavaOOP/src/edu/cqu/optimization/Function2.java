package edu.cqu.optimization;

public class Function2 implements Function {

	@Override
	public double value(double[] x, double[] parameters) {
		double a=parameters[0];
		double b=parameters[1];
		return a*x[0]*x[0]+b*x[1]*x[1];
	}

	@Override
	public double[] gradient(double[] x, double[] parameters) {

		double[] ret=new double[2];
		ret[0]=x[0]*x[0];
		ret[1]=x[1]*x[1];
		return ret;
	}

	@Override
	public double[] initialGuess() {
		// TODO Auto-generated method stub
		return new double[]{1,1};
	}

}
