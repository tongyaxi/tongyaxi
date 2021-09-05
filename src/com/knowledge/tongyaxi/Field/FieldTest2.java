package com.knowledge.tongyaxi.Field;

import java.lang.reflect.Field;

public class FieldTest2 {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		Person person = new Person();

		person.setName("tongyaxi");
		person.setAge(24);
		person.setSex("男性");

		//通过Class.getDeclaredField(String name)获取类或接口的指定属性值。
		Field field = person.getClass().getDeclaredField("name");
		System.out.println("\n-----Class.getDeclaredField(String name)用法-------");
		Object name = field.get(person);
		System.out.println(name);

		System.out.println("\n-----Class.getDeclaredFields()用法-------");
		//通过Class.getDeclaredFields()获取类或接口的所有属性值。
		Field []field2 = person.getClass().getDeclaredFields();
		for(Field fields : field2){
			//获取私有属性的时候必须先设置Accessible为true
			fields.setAccessible(true);
			System.out.println(fields.get(person));
		}


		//修改属性值
		System.out.println("\n----修改name属性------");
		field.set(person, "yaxitong");

		//修改后再遍历各属性的值
        Field []field3=person.getClass().getDeclaredFields();
		for(Field fields : field3)
		{
			fields.setAccessible(true);
			System.out.println(fields.get(person));
		}



	}

}
