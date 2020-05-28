package com.knowledge.tongyaxi.IO_Base_Api.PW_BR;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 缓冲流在流连接中的作用
 * @author tarena
 *
 */
public class PrintWriter_println2 {

	public static void main(String[] args) throws FileNotFoundException {
		FileOutputStream fos = new FileOutputStream("地表最强4.txt");

		OutputStreamWriter osw = new OutputStreamWriter(fos);//(需在转换流)也可以指定Stirng charSetName

		PrintWriter pw = new PrintWriter(osw);

		pw.println("从天台向下俯瞰，暴力在原地打转");
		pw.println("上一代解决的答案是微笑不抵抗。");
		System.out.println("写出完毕");
		pw.close();

	}
}
