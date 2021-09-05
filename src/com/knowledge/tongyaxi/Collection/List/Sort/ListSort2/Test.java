package com.knowledge.tongyaxi.Collection.List.Sort.ListSort2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * java list按照元素对象的指定多个字段属性进行排�?
 * @author ytong
 *
 */
public class Test {

	public static void main(String[] args) throws Exception {

		Test testObj = new Test();

		List<UserInfo> list = new ArrayList<UserInfo>();
		// public UserInfo(Integer userId, String username, Date birthDate,Integer age, float fRate, char ch)
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		UserInfo user1 = new UserInfo(3, "bbb", formater.parse("1980-12-01"), 1, 1.2f, 'a');
		UserInfo user2 = new UserInfo(0, "126", formater.parse("1900-10-11"), 03, -3.6f, 'c');
		UserInfo user3 = new UserInfo(12, "5", formater.parse("1973-08-21"), 15, 9.32f, 'f');
		UserInfo user4 = new UserInfo(465, "1567", formater.parse("2012-01-26"), 20, 12.56f, '0');
		UserInfo user5 = new UserInfo(2006, "&4m", formater.parse("2010-05-08"), 100, 165.32f, '5');
		UserInfo user6 = new UserInfo(5487, "hf67", formater.parse("2016-12-30"), 103, 56.32f, 'm');
		UserInfo user7 = new UserInfo(5487,"jigg", formater.parse("2000-10-16"), 103, 56.32f, 'm');
		UserInfo user8 = new UserInfo(5487, "jigg", formater.parse("1987-07-25"), 103, 56.32f, 'm');

		list.add(user1);
		list.add(user2);
		list.add(user3);
		list.add(user4);
		list.add(user5);
		list.add(user6);
		list.add(user7);
		list.add(user8);

		System.out.println("\n-------原来序列-------------------");
		testObj.printfUserInfoList(list);

		// 按userId升序、username降序、birthDate升序排序
		String [] sortNameArr = {"userId","username","birthDate"};
		boolean [] isAscArr = {true,false,true};
		ListUtils.sort(list,sortNameArr,isAscArr);
		System.out.println("\n--------按userId升序、username降序、birthDate升序排序（如果userId相同，则按照username降序,如果username相同，则按照birthDate升序�?------------------");
		testObj.printfUserInfoList(list);

		// 按userId、username、birthDate都升序排�?
		ListUtils.sort(list, true, "userId", "username","birthDate");
		System.out.println("\n--------按userId、username、birthDate排序（如果userId相同，则按照username升序,如果username相同，则按照birthDate升序�?------------------");
		testObj.printfUserInfoList(list);

		// 按userId、username都�?�序排序
		ListUtils.sort(list, false, "userId", "username");
		System.out.println("\n--------按userId和username倒序（如果userId相同，则按照username倒序�?------------------");
		testObj.printfUserInfoList(list);

		// 按username、birthDate都升序排�?
		ListUtils.sort(list, true, "username", "birthDate");
		System.out.println("\n---------按username、birthDate升序（如果username相同，则按照birthDate升序�?-----------------");
		testObj.printfUserInfoList(list);

		// 按birthDate倒序排序
		ListUtils.sort(list, false, "birthDate");
		System.out.println("\n---------按birthDate倒序-----------------");
		testObj.printfUserInfoList(list);

		// 按fRate升序排序
		ListUtils.sort(list, true, "fRate");
		System.out.println("\n---------按fRate升序-----------------");
		testObj.printfUserInfoList(list);

		// 按ch倒序排序
		ListUtils.sort(list, false, "ch");
		System.out.println("\n---------按ch倒序-----------------");
		testObj.printfUserInfoList(list);

	}

	private void printfUserInfoList(List<UserInfo> list) {
		for (UserInfo user : list) {
			System.out.println(user.toString());
		}
	}

}
