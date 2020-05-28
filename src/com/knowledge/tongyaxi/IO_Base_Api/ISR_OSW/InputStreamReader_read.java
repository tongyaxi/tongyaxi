package com.knowledge.tongyaxi.IO_Base_Api.ISR_OSW;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReader_read {//读取字符--字符输入流

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("地表最强2.txt");

		InputStreamReader isr = new InputStreamReader(fis,"GBK");//按照指定字符编码读取字符

		int d = -1;
		while((d = isr.read())!=-1){
			System.out.print((char)d);
		}
		isr.close();

	}
}
