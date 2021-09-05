package com.knowledge.tongyaxi.Stream.Lambda;

import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.*;

/**
 * 
 * @author tongyaxi
 *
 */
public class Lambda6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<Integer> natual = Stream.generate(new NatualSupplier());
        // ע�⣺�������б����ȱ�����������ٴ�ӡ:
        natual.limit(20).forEach(System.out::println);
        
        
        Pattern p = Pattern.compile("\\s+");
        Stream<String> s = p.splitAsStream("The quick brown fox jumps over the lazy dog");
        s.forEach(System.out::println);
	}

}

class NatualSupplier implements Supplier<Integer> {
    int n = 0;
    public Integer get() {
        n++;
        return n;
    }
}
