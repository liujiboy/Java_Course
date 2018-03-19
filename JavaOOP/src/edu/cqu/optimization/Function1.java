package edu.cqu.optimization;

public class Function1 implements Function {

	@Override
	public double value(double[] x, double[] parameters) {
		double k=parameters[0];
		double b=parameters[1];
		return k*x[0]+b;
	}

	@Override
	public double[] gradient(double[] x, double[] parameters) {
		double[] ret=new double[2];
		ret[0]=x[0];
		ret[1]=1;
		return ret;
	}

	@Override
	public double[] initialGuess() {
		
		return new double[] {2,2};
	}

}
