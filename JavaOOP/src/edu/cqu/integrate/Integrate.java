package edu.cqu.integrate;

public class Integrate {
	public static double doIntegrate(Function f, double a, double b) {
		double dx = (b - a) / 10000.0;
		double ret = 0.0;
		for (int i = 0; i < 10000; i++) {
			double x = a + i * dx;
			ret += f.value(x) * dx;
		}
		ret += f.value(b) * dx;
		return ret;
	}
}
