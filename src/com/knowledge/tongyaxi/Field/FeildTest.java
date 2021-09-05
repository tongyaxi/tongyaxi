package com.knowledge.tongyaxi.Field;

import java.lang.reflect.Field;


public class FeildTest {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		Person person = new Person();


		System.out.println("\n-----Class.getDeclaredField(String name)用法-------");
		//Class.getClass().getDeclaredField(String name)クラス/インターフェースに指定されたフィールドを取得する(包括私有成员)
		Field field1 = person.getClass().getDeclaredField("name");
		System.out.println(field1);

		System.out.println("\n-----Class.getDeclaredFields()用法-------");
		//通过Class.getDeclaredFields()获取类或接口的所声明的所有字段。(包括私有成员)
		Field []field2 = person.getClass().getDeclaredFields();
		for(Field fields:field2){
			System.out.println(fields);
		}

		System.out.println("\n-----Class.getField(String name)用法-------");
		//通过Class.getField(String name)返回一个类或接口的指定公共成员字段，私有成员报错。
		Field field3 = person.getClass().getField("name");
		System.out.println(field3);

		System.out.println("\n-----Class.getFields()用法-------");
		//通过Class.getField()，返回 Class 对象所表示的类或接口的所有可访问公共字段。
		Field []field4 = person.getClass().getFields();
		for(Field fields:field4){
			System.out.println(fields);
		}
	}

}
