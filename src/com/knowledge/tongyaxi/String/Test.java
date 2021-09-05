package com.knowledge.tongyaxi.String;

/**
 * 占位符
 * @author tongyaxi
 *
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "我叫%s,今年%s";
		String name = "仝亚西";
		String age = "25";
		url = String.format(url, name, age);
		
		System.out.println(url);
	}

}
