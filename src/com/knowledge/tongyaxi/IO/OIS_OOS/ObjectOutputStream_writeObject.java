package com.knowledge.tongyaxi.IO.OIS_OOS;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectOutputStream_writeObject {
	public static void main(String[] args) throws IOException {
		Person p = new Person();
		p.setName("�ر���ǿ");
		p.setAge(18);
		p.setGender("��");

		List<String> otherInfo = new ArrayList<String>();
		otherInfo.add("��ȥ�ĳ�������");
		otherInfo.add("��ȥ�Ĺ����ձ�");
		p.setOtherIonfo(otherInfo);

		FileOutputStream fos = new FileOutputStream("�ر���ǿ.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(p);
		System.out.println("����д�����");
		oos.close();

	}
}
