package com.knowledge.tongyaxi.IO.RAF;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFile_seek {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new 		RandomAccessFile("red.txt","rw");

		System.out.println("pos:"+raf.getFilePointer());

		raf.writeInt(1);//连续写四个字节
		System.out.println("pos:"+raf.getFilePointer());

		raf.writeDouble(2.32);
		System.out.println("pos:"+raf.getFilePointer());

		raf.writeLong(123L);
		System.out.println("pos:"+raf.getFilePointer());

		raf.seek(0);//将指针移动到指定位置
		System.out.println("pos:"+raf.getFilePointer());

		int i = raf.readInt();//连续读取四个字节
		System.out.println(i);
		System.out.println("pos:"+raf.getFilePointer());

		double d = raf.readDouble();
		System.out.println(d);
		System.out.println("pos:"+raf.getFilePointer());

		long l = raf.readLong();
		System.out.println(l);
		System.out.println("pos:"+raf.getFilePointer());


		raf.close();


	}
}
