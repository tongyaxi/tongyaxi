package com.knowledge.tongyaxi.IO.RAF;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFile_write_String {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("raf.txt","rw");

		byte[] data = "总是一副弱不禁风孬种的样子；".getBytes("GBK");//也可以按照指定的字符集

		raf.write(data);
		System.out.println("写出完毕");
		raf.close();

	}
}
