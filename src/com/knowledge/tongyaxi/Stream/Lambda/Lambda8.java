package com.knowledge.tongyaxi.Stream.Lambda;

import java.util.stream.IntStream;

public class Lambda8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
        .filter(n -> n % 2 != 0)
        .forEach(System.out::println);
	}

}
