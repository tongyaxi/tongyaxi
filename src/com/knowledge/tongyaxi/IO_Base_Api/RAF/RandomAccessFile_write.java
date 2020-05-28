package com.knowledge.tongyaxi.IO_Base_Api.RAF;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFile_write {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("raf.dat","rw");

		raf.write(6);//int 值对应2进制的低八位
		System.out.println("写出完毕");
		raf.close();

	}
}
