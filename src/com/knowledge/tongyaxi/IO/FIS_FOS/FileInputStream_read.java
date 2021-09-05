package com.knowledge.tongyaxi.IO.FIS_FOS;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream_read {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("地表最强5.txt");

		byte[] data = new byte[200];

		int len = fis.read(data);//读取文件中的信息

		String str = new String(data,0,len);
		System.out.println(str);//将文件中的信息输出到控制台

		fis.close();

	}
}
