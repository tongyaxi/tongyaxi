package com.knowledge.tongyaxi.IO.RAF;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFile_write {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("raf.dat","rw");

		raf.write(6);//int ֵ��Ӧ2���ƵĵͰ�λ
		System.out.println("д�����");
		raf.close();

	}
}
