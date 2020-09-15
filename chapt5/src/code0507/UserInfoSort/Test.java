/**
 * 
 */
package code0507.UserInfoSort;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;

/**
 * Test.java Copyright (c) 2016 ChongQing University All rights reserved.
 */
public class Test {
	public static void main(String[] args) throws Exception {
		List<UserInfo> list = new ArrayList<UserInfo>();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		list.add(new UserInfo(3, "Zhang", formater.parse("2016-12-01"), 11));
		list.add(new UserInfo(1, "Li", formater.parse("2016-10-01"), 30));
		list.add(new UserInfo(2, "Chen", formater.parse("2015-10-01"), 11));
		MySort<UserInfo> sortList = new MySort<UserInfo>();
		// 按userId排序
		sortList.Sort(list, "getUserId", "desc");
		System.out.println("--------按userId倒序------------------");
		for (UserInfo user : list) {
			System.out.println(user.toString());
		}
		// 按username排序
		sortList.Sort(list, "getUsername", null);
		System.out.println("---------按username排序-----------------");
		for (UserInfo user : list) {
			System.out.println(user.toString());
		}
		// 按birthDate排序
		sortList.Sort(list, "getBirthDatestr", null);
		System.out.println("---------按birthDate排序-----------------");
		for (UserInfo user : list) {
			System.out.println(user.toString());
		}
	}
}