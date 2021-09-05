package com.knowledge.tongyaxi.Collection.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * List删除重复数据之contains
 * @author tongyaxi
 *
 */
public class ArrayListExample4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> numbersList = new ArrayList<>(Arrays.asList("1", "1", "2", "3", "3", "3", "4", "5", "6", "6", "6", "7", "8"));
		System.out.println(numbersList);
		removeDuplicate(numbersList);
		System.out.println(numbersList);
		
	}
	
     private static void removeDuplicate(List<String> list) {
		
    	 List<String> result = new ArrayList<String>(list.size());
    	    for (String str : list) {
    	        if (!result.contains(str)) {
    	            result.add(str);
    	        }
    	    }
    	    list.clear();
    	    list.addAll(result);
	}

}
