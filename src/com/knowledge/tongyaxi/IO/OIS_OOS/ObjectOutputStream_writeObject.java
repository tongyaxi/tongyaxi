package com.knowledge.tongyaxi.IO.OIS_OOS;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectOutputStream_writeObject {
	public static void main(String[] args) throws IOException {
		Person p = new Person();
		p.setName("地表最强");
		p.setAge(18);
		p.setGender("男");

		List<String> otherInfo = new ArrayList<String>();
		otherInfo.add("想去的城市重庆");
		otherInfo.add("想去的国家日本");
		p.setOtherIonfo(otherInfo);

		FileOutputStream fos = new FileOutputStream("地表最强.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(p);
		System.out.println("对象写出完毕");
		oos.close();

	}
}
