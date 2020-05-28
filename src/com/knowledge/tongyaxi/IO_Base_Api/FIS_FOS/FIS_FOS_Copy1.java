package com.knowledge.tongyaxi.IO_Base_Api.FIS_FOS;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FIS_FOS_Copy1 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("VID_20161015_212152.mp4");
		FileOutputStream fos = new FileOutputStream("VID_20161015_212152_副本.mp4");

		byte[] data = new byte[1024*10];
		int len = -1;
		while((len=fis.read(data))!=-1){
			fos.write(data,0,len);
		}
		System.out.println("写出完毕");
		fis.close();
		fos.close();

	}
}
