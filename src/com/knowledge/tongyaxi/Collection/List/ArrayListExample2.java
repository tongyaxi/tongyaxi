package com.knowledge.tongyaxi.Collection.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * List删除重复数据之Set
 * @author tongyaxi
 *
 */
public class ArrayListExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> numbersList = new ArrayList<>(Arrays.asList("1", "1", "2", "3", "3", "3", "4", "5", "6", "6", "6", "7", "8"));
		System.out.println(numbersList);
		removeDuplicate(numbersList);
		System.out.println(numbersList);
	}
	
	private static void removeDuplicate(List<String> list) {
		
	    HashSet<String> set = new HashSet<String>(list.size());
	    List<String> result = new ArrayList<String>(list.size());
	    for (String str : list) {
	        if (set.add(str)) {
	            result.add(str);
	        }
	    }
	    list.clear();
	    list.addAll(result);
	}

}
