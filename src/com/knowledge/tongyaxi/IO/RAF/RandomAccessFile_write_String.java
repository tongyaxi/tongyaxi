package com.knowledge.tongyaxi.IO.RAF;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFile_write_String {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("raf.txt","rw");

		byte[] data = "����һ����������ث�ֵ����ӣ�".getBytes("GBK");//Ҳ���԰���ָ�����ַ���

		raf.write(data);
		System.out.println("д�����");
		raf.close();

	}
}
