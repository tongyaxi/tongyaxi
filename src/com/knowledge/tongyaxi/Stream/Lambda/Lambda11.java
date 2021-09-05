package com.knowledge.tongyaxi.Stream.Lambda;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class Lambda11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<Long> s1 = Stream.generate(new NatualSupplier2());
        Stream<Long> s2 = s1.map(n -> n * n);
        Stream<Long> s3 = s2.map(n -> n - 1);
        System.out.println(s3); // java.util.stream.ReferencePipeline$3@49476842
	}

}

class NatualSupplier2 implements Supplier<Long> {
    long n = 0;
    public Long get() {
        n++;
        return n;
    }
}
