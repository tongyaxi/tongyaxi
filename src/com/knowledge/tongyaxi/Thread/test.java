package com.knowledge.tongyaxi.Thread;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Person> list = new ArrayList<Person>();
		Person p = new Person();
		p.name="qq";
		p.sex="ww";
		p.gender="rr";
		list.add(p);
		list = changeFlg(list);
		for(Person pp : list) {
			System.out.println(pp.gender);
			System.out.println(pp.name);
			System.out.println(pp.sex);
		}
		

	}
	private static ArrayList<Person> changeFlg(ArrayList<Person> list) {
		for(Person str : list) {
			str.name = "111";
			str.sex = "111";
			str.gender = "111";
			
		}
		return list;
	}

}
