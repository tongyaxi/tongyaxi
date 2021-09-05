package com.knowledge.tongyaxi.Stream.Lambda;

import java.util.stream.Stream;
/**
 * 创建数组-Stream.of
 * @author tongyaxi
 *
 */
public class Lambda5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<String> stream = Stream.of("A", "B", "C", "D");
        // forEach()方法相当于内部循环调用，
        // 可传入符合Consumer接口的void accept(T t)的方法引用：
        stream.forEach(System.out::println);

	}

}
