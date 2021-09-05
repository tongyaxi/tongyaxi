package com.knowledge.tongyaxi.Stream.Lambda;

import java.util.Arrays;

public class Lambda3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] array = new String[]{"A","C","K","B"};
		Arrays.sort(array, String :: compareTo);
		System.out.println(String.join(",", array));

	}

}
