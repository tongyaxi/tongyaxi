package com.knowledge.tongyaxi.Collection.List.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * ʹ��ArrayList��subList��ע������
 * @author tongyaxi
 *
 */
public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> bookList = new ArrayList<>();
		bookList.add("ңԶ�ľ�����");
		bookList.add("����");
		bookList.add("��Ļ�쳾");
		bookList.add("����");
		bookList.add("ƽ��������");

		List<String> luyaoBookList = bookList.subList(3, 5);

		System.out.println(bookList);
		System.out.println(luyaoBookList);
		
		// 1.�޸�ԭ���ϵ�ֵ����Ӱ���Ӽ���
//		bookList.set(3, "���");
//		
//		System.out.println(bookList);
//		System.out.println(luyaoBookList);
		
		// 2.�޸�ԭ���ϵĽṹ��������ConcurrentModificationException�쳣
//		bookList.add("����");
//		System.out.println(bookList);
//		System.out.println(luyaoBookList);
		
		// 3.�޸��Ӽ��ϵ�ֵ����Ӱ��ԭ���ϡ�
//		luyaoBookList.set(1, "�޸���");
//		System.out.println(bookList);
//		System.out.println(luyaoBookList);
		
		// 4.�޸����Ӽ��ϵĽṹ����Ӱ��ԭ����
		luyaoBookList.add("����");
		System.out.println(bookList);
		System.out.println(luyaoBookList);
	}

}
