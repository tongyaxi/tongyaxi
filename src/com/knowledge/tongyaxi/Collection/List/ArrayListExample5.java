package com.knowledge.tongyaxi.Collection.List;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * List删除重复数据之contains
 * @author tongyaxi
 *
 */
public class ArrayListExample5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> numbersList = new ArrayList<>(Arrays.asList("1", "1", "2", "3", "3", "3", "4", "5", "6", "6", "6", "7", "8"));
		System.out.println(numbersList);
		for (int i = 0; i < numbersList.size(); i++) { 
			for (int j = 0; j < numbersList.size(); j++) { 
			if(i!=j&&numbersList.get(i)==numbersList.get(j)) { 
				numbersList.remove(numbersList.get(j)); 
			 } 
			}
		System.out.println(numbersList);
		
	}
	}
}
