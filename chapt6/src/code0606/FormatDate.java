/**
 * 
 */
package code0606;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * FormatDate.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class FormatDate {

	public static void main(String[] args) throws ParseException {
		// 创建格式化器，年月日等使用特定字母作为占位符
		SimpleDateFormat myFmt = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		SimpleDateFormat myFmt1 = new SimpleDateFormat("yy/MM/dd HH:mm");
		SimpleDateFormat myFmt2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat myFmt3 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E ");
		SimpleDateFormat myFmt4 = new SimpleDateFormat("一年中的第 D 天 一年中第w个星期 一月中第W个星期 在一天中k时 z时区");
		Date now = new Date();
		System.out.println(now.toString());
		// 格式化输出
		String ds1 = myFmt.format(now);
		System.out.println(ds1);
		System.out.println(myFmt1.format(now));
		System.out.println(myFmt2.format(now));
		System.out.println(myFmt3.format(now));
		System.out.println(myFmt4.format(now));
		// 解析字符串为日期对象
		String ds2 = "2026年06月17日 10时38分52秒";
		Date d = myFmt.parse(ds2);
		//创建日历对象，日期计算
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.YEAR, 20);
		System.out.println(c.getTime());

	}

}
