package com.knowledge.tongyaxi.Stream.Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class Lambda4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = new ArrayList<String>();
		names.add("Bob");
		names.add("Alice");
		names.add("TYX");
		
        List<Person> persons = names.stream().map(Person::new).collect(Collectors.toList());
        System.out.println(persons);
	}

}

class Person {
	public String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Person:" + this.name;
	}
}