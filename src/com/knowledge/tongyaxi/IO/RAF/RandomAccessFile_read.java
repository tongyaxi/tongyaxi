package com.knowledge.tongyaxi.IO.RAF;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFile_read {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("raf.dat","r");

		int i = raf.read();
		System.out.println(i);

		i = raf.read();
		System.out.println(i);//����ֵΪ-1����ʾ��ȡ���ļ�ĩβ

		raf.close();

	}
}
