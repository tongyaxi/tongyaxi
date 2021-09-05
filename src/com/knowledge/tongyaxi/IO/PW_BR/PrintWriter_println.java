package com.knowledge.tongyaxi.IO.PW_BR;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 缓冲字符流：BufferedWriter,BufferedReader
 *     按行读写；！！！
 *             PrintWriter：
 *             也是缓冲字符流，具备自动刷新行功能；内部包含BufferedWriter，代替使用；
 * @author tarena
 *
 */
public class PrintWriter_println {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter pw = new PrintWriter("地表最强3.txt");//也可以指定String path,指定charSetName

		pw.println("为你弹奏肖邦的夜曲，纪念我死去的爱情。");
		pw.println("而我为你隐形埋名，在月光下弹琴；");

		System.out.println("写出完毕");
		pw.close();

	}
}
