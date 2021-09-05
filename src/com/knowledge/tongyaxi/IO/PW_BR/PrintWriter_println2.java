package com.knowledge.tongyaxi.IO.PW_BR;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 缓冲流在流连接中的作用
 * @author tarena
 *
 */
public class PrintWriter_println2 {

	public static void main(String[] args) throws FileNotFoundException {
		
		FileOutputStream fos = null;

		OutputStreamWriter osw = null;
		
		PrintWriter pw = null;
		try {
			fos = new FileOutputStream("地表最强4.txt");
			osw = new OutputStreamWriter(fos,"utf-8");
			pw = new PrintWriter(osw);
			
			pw.println("从天台向下俯瞰，暴力在原地打转");
			pw.println("上一代解决的答案是微笑不抵抗。");
			System.out.println("写出完毕");
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pw!=null) {
				pw.close();
			}
		}

		

		
		

	}
}
