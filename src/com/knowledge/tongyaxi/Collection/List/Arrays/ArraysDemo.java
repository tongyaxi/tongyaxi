package com.knowledge.tongyaxi.Collection.List.Arrays;

import java.util.Arrays;
import java.util.List;

/**
 * 使用Arrays.asList的注意事项
 * @author tongyaxi
 *
 */
public class ArraysDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1,2);
		
		System.out.println(list);
		System.out.println(list.contains(1));
		System.out.println(list.contains(3));
		
		list.add(3);
		System.out.println(list);
	}

}
