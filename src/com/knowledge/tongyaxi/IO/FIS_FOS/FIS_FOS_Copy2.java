package com.knowledge.tongyaxi.IO.FIS_FOS;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FIS_FOS_Copy2 {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("VID_20161015_212152.mp4");
		BufferedInputStream bis = new BufferedInputStream(fis);

		FileOutputStream fos = new FileOutputStream("VID_20161015_212152_����2.mp4");
		BufferedOutputStream bos = new BufferedOutputStream(fos);

		//byte[] data = new byte[1024*10];�Եö��һ��
	    int len = -1;

	    while((len = bis.read())!=-1){
	    	bos.write(len);
	    }
	    System.out.println("д�����");
	    bis.close();
	    bos.close();

	}
}
