package com.knowledge.tongyaxi.Collection.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * List删除重复数据之Stream
 * @author tongyaxi
 *
 */
public class ArrayListExample3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));
		System.out.println(numbersList);
		
		List<Integer> listWithoutDuplicates = numbersList.stream().
				                              distinct().collect(Collectors.toList());
		 
        System.out.println(listWithoutDuplicates);
		
	}

}
