package com.knowledge.tongyaxi.Stream.Lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Lambda1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] array = new String[]{"A","C","K","B"};
		
		
		Arrays.sort(array, new Comparator<String>() {
		    public int compare(String s1, String s2) {
		        return s1.compareTo(s2);
		    }
		});
		
		System.out.println(String.join(",", array));
		
		Arrays.sort(array, (s1,s2) -> {
			return s1.compareTo(s2);
		});
		System.out.println(String.join(",", array));

	}

}
