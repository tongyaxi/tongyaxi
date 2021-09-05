package com.knowledge.tongyaxi.Stream.Lambda;

import java.util.Optional;
import java.util.stream.Stream;

public class Lambda10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(0, (acc, n) -> acc + n);
        System.out.println(sum); // 45
        
        Optional<Integer> opt = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce((acc, n) -> acc + n);
        if (opt.isPresent()) {
            System.out.println(opt.get());
        }
        
        int s = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(1, (acc, n) -> acc * n);
        System.out.println(s); // 362880
	}

}
