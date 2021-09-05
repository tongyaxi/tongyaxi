package com.knowledge.tongyaxi.IO.RAF;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFile_read_String {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("raf.txt","r");

		byte[] data = new byte[200];

		int len = raf.read(data);
		String str = new String(data,0,len,"GBK");//按照指定字符集读取指定长度
		System.out.println(str);

	}
}
