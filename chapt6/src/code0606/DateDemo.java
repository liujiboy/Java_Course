package code0606;
import java.util.Date;
public class DateDemo
{
    public static void main(String[] args)
    {
        Date d1 = new Date();
        Date d2 = new Date(1140203030304L);
        System.out.println(d1);
        System.out.println(d2);
        if (d2.after(d1))
            System.out.println("d2晚于d1");
        System.out.println(d2.compareTo(d1));
        //改变的d2的值为d1
        d2.setTime(d1.getTime());
        System.out.println(d2);
    }
}
