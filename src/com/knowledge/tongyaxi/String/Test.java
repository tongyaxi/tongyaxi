package com.knowledge.tongyaxi.String;

/**
 * ռλ��
 * @author tongyaxi
 *
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "�ҽ�%s,����%s";
		String name = "������";
		String age = "25";
		url = String.format(url, name, age);
		
		System.out.println(url);
	}

}
