package com.knowledge.tongyaxi.Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//import java.util.stream.Collectors;

public class StreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Person> listPerson = new ArrayList<Person>();

		listPerson.add(new Person("leishen",18));
		listPerson.add(new Person("gangtiexia",28));
		listPerson.add(new Person("duizhang",38));
		listPerson.add(new Person("leishen",18));

		System.out.println(listPerson);
		/*
		 * 1.stream()  将集合转换为流
		 */
		System.out.println(listPerson.stream());

		/*
		 * 2.filter(T -> boolean)  保留boolean为true的元素 保留年龄为18的person元素
		 *  collect()可以把流转换为list类型
		 */
		System.out.println(listPerson.stream()
				                     .filter(Person -> Person.getAge() == 18)
				                     .collect(Collectors.toList()));

		/*
		 * 3.distinct()
		 * 去重，需通过类的equals方法来进行元素判断
		 */
		System.out.println(listPerson.stream()
				                     .distinct()
				                     .collect(Collectors.toList()));

		/*
		 * 4.sorted() / sorted((T, T) -> int)
		 * 若流中元素的类已经实现Comparable接口，可直接调用sorted方法对元素进行排序
		 * 反之，sorted((T, T) -> int)实现Comparator接口
		 */
		System.out.println(listPerson.stream()
		                             .sorted((p1, p2) -> p1.getAge() - p2.getAge())
		                             .collect(Collectors.toList()));
		System.out.println(listPerson.stream()
                                     .sorted(Comparator.comparingInt(Person::getAge))
                                     .collect(Collectors.toList()));

		/*
		 * 5.limit(long n)
		 * 返回前n个元素
		 */
		System.out.println(listPerson.stream()
				                     .limit(2)
				                     .collect(Collectors.toList()));

		/*
		 * 6.skip(long n)
		 * 去除前n个元素
		 */
		System.out.println(listPerson.stream()
                .skip(2)
                .collect(Collectors.toList()));

		/*
		 * 7.map(T -> R)
		 * 将流中的每一个元素T映射为R（类型转换）
		 */
		List<String> newList = listPerson.stream()
                                         .map(Person::getName)
                                         .collect(Collectors.toList());
		Set<String> newSet = listPerson.stream()
				                         .map(Person::getName)
				                         .collect(Collectors.toSet());
		System.out.println(newList);
		System.out.println(newSet);

	}

}
