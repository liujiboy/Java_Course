package edu.cqu.optimization;


 public interface Function {
	public double value(double[] x,double[] parameters);
	public double[] gradient(double[] x,double[] parameters);
	public double[] initialGuess();
}
