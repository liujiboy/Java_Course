package edu.cqu;


public class Triangle {
	private Point a;
	private Point b;
	private Point c;
	private double ab;
	private double ac;
	private double bc;
	public Point getA() {
		return a;
	}
	public void setA(Point a) {
		this.a = a;
		计算三边长度();
	}
	private void 计算三边长度() {
		ab=this.a.distance(this.b);
		ac=this.a.distance(this.c);
		bc=this.b.distance(this.c);
	}
	public Point getB() {
		return b;
	}
	public void setB(Point b) {
		this.b = b;
		计算三边长度();
	}
	public Point getC() {
		return c;
	}
	public void setC(Point c) {
		this.c = c;
		计算三边长度();
	}
	public double getLength(){
		return ab+ac+bc;
	}
	
	public double getArea(){
		
		double p=getLength()/2;
		double s=Math.sqrt(p*(p-ab)*(p-ac)*(p-bc));
		return s;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((b == null) ? 0 : b.hashCode());
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (b == null) {
			if (other.b != null)
				return false;
		} else if (!b.equals(other.b))
			return false;
		if (c == null) {
			if (other.c != null)
				return false;
		} else if (!c.equals(other.c))
			return false;
		return true;
	}
	public Triangle(Point a, Point b, Point c)throws Exception {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		计算三边长度();
		if(ab+bc>ac&&ab+ac>bc&&ac+bc>ab)
		{
			
		}else
		{
			
				throw new Exception("不是三角形");
			
		}
	}
	
	public static void main(String args[])
	{
		
		try{
			Point p1=new Point(0.0,0.0,0.0);
			Point p2=new Point(1.0,0.0,0.0);
			Point p3=new Point(2.0,0.0,0.0);
			Triangle t = new Triangle(p1,p2,p3);
			System.out.println(t.getArea());
			System.out.println(t.getLength());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
}
