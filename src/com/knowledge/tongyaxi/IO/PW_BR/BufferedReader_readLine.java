package com.knowledge.tongyaxi.IO.PW_BR;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReader_readLine {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("�ر���ǿ4.txt");

		InputStreamReader isr = new InputStreamReader(fis);

		BufferedReader br = new BufferedReader(isr);

		String line =null;//�����е��ַ���һ���ַ�����ʽ����
		while((line = br.readLine())!=null){//ֱ����ȡ�����з�Ϊֹ����ȡ���ļ�ĩβ����ֵΪnull
			System.out.println(line);
		}
		br.close();

	}
}
