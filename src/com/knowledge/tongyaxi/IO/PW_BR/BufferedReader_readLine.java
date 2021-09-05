package com.knowledge.tongyaxi.IO.PW_BR;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReader_readLine {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("地表最强4.txt");

		InputStreamReader isr = new InputStreamReader(fis);

		BufferedReader br = new BufferedReader(isr);

		String line =null;//将所有的字符以一个字符串形式返回
		while((line = br.readLine())!=null){//直到读取到换行符为止，读取到文件末尾返回值为null
			System.out.println(line);
		}
		br.close();

	}
}
