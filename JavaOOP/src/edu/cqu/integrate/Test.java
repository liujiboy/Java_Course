package edu.cqu.integrate;

public class Test {
	public static void main(String args[])
	{
		Function f1=new Function() {
			@Override
			public double value(double x) {
				return x*x;
			}	
		};
		Function f2=new Function() {
			@Override
			public double value(double x) {
				return 2*x+1;
			}
			
		};
		System.out.println(Integrate.doIntegrate(f1, 0, 1));
		System.out.println(Integrate.doIntegrate(f2, 0, 1));
		System.out.println(Integrate.doIntegrate((x)->Math.exp(x), 0, 1));
	}
}
