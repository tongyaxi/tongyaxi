package com.knowledge.tongyaxi.IO.ISR_OSW;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReader_read {//��ȡ�ַ�--�ַ�������

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("�ر���ǿ2.txt");

		InputStreamReader isr = new InputStreamReader(fis,"GBK");//����ָ���ַ������ȡ�ַ�

		int d = -1;
		while((d = isr.read())!=-1){
			System.out.print((char)d);
		}
		isr.close();

	}
}
