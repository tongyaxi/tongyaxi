package com.knowledge.tongyaxi.IO.FIS_FOS;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStream_flush {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("�ر���ǿ6.txt");

		BufferedOutputStream bos = new BufferedOutputStream(fos);

		byte[] data = "������س�һ����˵�İ��ҡ�".getBytes();
		//�����ֽڱ����뻺�������ȴ�һ����д��
		bos.write(data);
		bos.flush();  //��ջ����������������е�����ǿ��д����
		System.out.println("д�����");
		bos.close();

	}
}
