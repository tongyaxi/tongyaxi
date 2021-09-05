package com.knowledge.tongyaxi.IO.RAF;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFile_read {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("raf.dat","r");

		int i = raf.read();
		System.out.println(i);

		i = raf.read();
		System.out.println(i);//返回值为-1，表示读取到文件末尾

		raf.close();

	}
}
