package com.knowledge.tongyaxi.Stream.Lambda;

import java.util.stream.Stream;
/**
 * ��������-Stream.of
 * @author tongyaxi
 *
 */
public class Lambda5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<String> stream = Stream.of("A", "B", "C", "D");
        // forEach()�����൱���ڲ�ѭ�����ã�
        // �ɴ������Consumer�ӿڵ�void accept(T t)�ķ������ã�
        stream.forEach(System.out::println);

	}

}
