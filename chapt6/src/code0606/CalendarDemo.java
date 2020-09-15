package code0606;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarDemo {
	public static void main(String[] args) {
		// 获得日历对象
		Calendar c1 = Calendar.getInstance();
		// 设置一周的第一天为周一
		c1.setFirstDayOfWeek(Calendar.MONDAY);
		//输出日历
		System.out.println(c1.getTime().toString());
		// 显示当前的日期的各个分量
		display(c1);
		// 创建日历对象，时间为：2020年12月8日晚上8时8分8妙
		Calendar c2 = new GregorianCalendar(2020, 11, 8, 20, 8, 8);
		// 计算今天距离2010年12月8日还有多少天
		int days = c2.get(Calendar.DAY_OF_YEAR) - c1.get(Calendar.DAY_OF_YEAR);
		System.out.println("距离2020年12月8日还有：" + days + "天");
		// 设置日期和时间分量
		c1.set(2030, 11, 30);
		c1.set(Calendar.HOUR, 10);
		c1.set(Calendar.MINUTE, 29);
		c1.set(Calendar.SECOND, 22);
		System.out.println("更新后时间: ");
		display(c1);
		// 调整日期和时间
		c1.add(Calendar.DATE, 10);
		c1.add(Calendar.HOUR_OF_DAY, 10);
		System.out.println("调整后时间: ");
		display(c1);
	}

	static void display(Calendar c) {
		String months[] = { "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月" };
		String days[] = { "", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日" };
		System.out.print("日期: ");
		// 下面的代码打印各个分量的值
		System.out.print(c.get(Calendar.YEAR) + "年");
		System.out.print(months[c.get(Calendar.MONTH)]);
		System.out.print(c.get(Calendar.DATE) + "日 ");
		System.out.println(days[c.get(Calendar.DAY_OF_WEEK) - 1]);
		System.out.print("时间: ");
		System.out.print(c.get(Calendar.HOUR_OF_DAY) + ":");
		System.out.print(c.get(Calendar.MINUTE) + ":");
		System.out.println(c.get(Calendar.SECOND));
	}
}
