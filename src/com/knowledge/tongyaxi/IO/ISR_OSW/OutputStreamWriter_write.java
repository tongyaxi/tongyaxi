package com.knowledge.tongyaxi.IO.ISR_OSW;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 字符流：Reader,Writer
 * 字符流是以字符(char)为单位读写数据的；
 * 转换流本身就是字符流;
 * @author tarena
 *
 */
public class OutputStreamWriter_write {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("地表最强2.txt");

		OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");//按照指定的字符编码

		osw.write("不用麻烦了，不用麻烦了。。。");
		osw.write("正义呼唤我，美女需要我，牛仔很忙的。");

		System.out.println("写出完毕");
		osw.close();

	}
}
