package com.knowledge.tongyaxi.IO.FIS_FOS;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutpurStream_write {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("�ر���ǿ5.txt");//Ҳ����String path
		/*
		 * Ҳ���Ժ��,boolean append,true��ʾ׷��ģʽ
		 */
		fos.write("����֣���㳵�����Ÿ裬���Ű��...".getBytes());
		fos.write("ϸ��������ĳ���".getBytes());

		fos.close();
		System.out.println("д�����");

	}
}
