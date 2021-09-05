package com.knowledge.tongyaxi.Collection.List.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用ArrayList的subList的注意事项
 * @author tongyaxi
 *
 */
public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> bookList = new ArrayList<>();
		bookList.add("遥远的救世主");
		bookList.add("背叛");
		bookList.add("天幕红尘");
		bookList.add("人生");
		bookList.add("平凡的世界");

		List<String> luyaoBookList = bookList.subList(3, 5);

		System.out.println(bookList);
		System.out.println(luyaoBookList);
		
		// 1.修改原集合的值，会影响子集合
//		bookList.set(3, "随便");
//		
//		System.out.println(bookList);
//		System.out.println(luyaoBookList);
		
		// 2.修改原集合的结构，会引起ConcurrentModificationException异常
//		bookList.add("周三");
//		System.out.println(bookList);
//		System.out.println(luyaoBookList);
		
		// 3.修改子集合的值，会影响原集合。
//		luyaoBookList.set(1, "修改了");
//		System.out.println(bookList);
//		System.out.println(luyaoBookList);
		
		// 4.修改了子集合的结构，会影响原集合
		luyaoBookList.add("晚上");
		System.out.println(bookList);
		System.out.println(luyaoBookList);
	}

}
