package com.knowledge.tongyaxi.IO.FIS_FOS;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream_read {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("�ر���ǿ5.txt");

		byte[] data = new byte[200];

		int len = fis.read(data);//��ȡ�ļ��е���Ϣ

		String str = new String(data,0,len);
		System.out.println(str);//���ļ��е���Ϣ���������̨

		fis.close();

	}
}
