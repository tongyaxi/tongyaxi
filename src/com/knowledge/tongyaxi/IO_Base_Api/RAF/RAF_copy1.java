package com.knowledge.tongyaxi.IO_Base_Api.RAF;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RAF_copy1 {//单字节复制
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("我爱的人.mp3","r");
		RandomAccessFile fdf = new RandomAccessFile("我爱的人_副本.mp3","rw");


		int len = -1;
		while((len = raf.read())!=-1){
			fdf.write(len);

		}
		System.out.println("复制完毕");
		raf.close();
		fdf.close();

	}
}
