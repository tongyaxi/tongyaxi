package com.knowledge.tongyaxi.Stream.Lambda;

import java.util.Arrays;

public class Lambda2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] array = new String[]{"A","C","K","B"};
		Arrays.sort(array, Lambda2 :: cmp);
		System.out.println(String.join(",", array));

	}
	
	static int cmp(String s1, String s2) {
		return s1.compareTo(s2);
	}

}
