package com.knowledge.tongyaxi.IO.RAF;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RAF_copy1 {//���ֽڸ���
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("�Ұ�����.mp3","r");
		RandomAccessFile fdf = new RandomAccessFile("�Ұ�����_����.mp3","rw");


		int len = -1;
		while((len = raf.read())!=-1){
			fdf.write(len);

		}
		System.out.println("�������");
		raf.close();
		fdf.close();

	}
}
