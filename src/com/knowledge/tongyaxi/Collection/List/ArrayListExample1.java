package com.knowledge.tongyaxi.Collection.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * List删除重复数据之LinkedHashSet
 * @author tongyaxi
 *
 */
public class ArrayListExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));
		 
        System.out.println(numbersList);
 
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(numbersList);
 
        ArrayList<Integer> listWithoutDuplicates = new ArrayList<>(hashSet);
 
        System.out.println(listWithoutDuplicates);
	}

}
