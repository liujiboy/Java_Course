package code0605;
public class MathDemo
{
    public static void main(String[] args)
    {
        double radians = 2 * Math.PI;
        double d1 = 3.1415655678;
        System.out.println("ceil函数:" + Math.ceil(d1));
        System.out.println("Round函数:" + Math.round(d1));
        System.out.println("floor函数:" + Math.floor(d1));
        System.out.println("exp函数:" + Math.exp(d1));
        System.out.println("pow函数:" + Math.pow(Math.E, d1));
        System.out.println("sin函数:" + Math.sin(Math.PI / 6));
        System.out.println("asin函数:" + Math.asin(0.5));
        System.out.println("log函数:" + Math.log(Math.E));
        System.out.println("角度转弧度：" + Math.toDegrees(radians));
        System.out.println("random函数1:" + Math.random());
        System.out.println("random函数2:" + Math.random());
    }
}
