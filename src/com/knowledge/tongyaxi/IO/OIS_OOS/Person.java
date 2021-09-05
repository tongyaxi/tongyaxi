package com.knowledge.tongyaxi.IO.OIS_OOS;

import java.util.List;

public class Person {
	private int age;
	private String name;
	private String gender;
	private transient List<String> otherInfo;

	public Person(){

	}

	public Person(int age, String name, String gender, List<String> otherInfo) {
		super();
		this.age = age;
		this.name = name;
		this.gender = gender;
		this.otherInfo = otherInfo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getOtherInfo() {
		return otherInfo;
	}

	public void setOtherIonfo(List<String> otherInfo) {
		this.otherInfo = otherInfo;
	}
	public String toString(){
		return name+","+age+","+gender+","+otherInfo+",";
	}
}