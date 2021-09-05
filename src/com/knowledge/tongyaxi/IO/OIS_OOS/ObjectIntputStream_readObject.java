package com.knowledge.tongyaxi.IO.OIS_OOS;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectIntputStream_readObject {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("地表最强.txt");

		ObjectInputStream ois = new ObjectInputStream(fis);

		Person p = (Person)ois.readObject();
		System.out.println(p);
		ois.close();


	}
}
