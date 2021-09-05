package com.knowledge.tongyaxi.IO;

import java.io.*;

import org.junit.Test;

public class InputStreamReaderTest {
	
	@Test
	public void InputStreamReaderTest01(){
		
		FileInputStream fis = null;
		InputStreamReader isr = null;
		try {
			fis = new FileInputStream(new File("hello.txt"));
			// 不填写utf-8，是使用系统默认的字符集
			isr = new InputStreamReader(fis,"utf-8");
			
			char[] data = new char[20];
			int len;
			while((len = isr.read(data)) != -1) {
				String str = new String(data,0,len);
				System.out.print(str);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(isr != null)
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	@Test
	public void OutputStreamWriterTest02(){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		
		try {
			fis = new FileInputStream(new File("hello.txt"));
			fos = new FileOutputStream(new File("hello2.txt"));
			
			isr = new InputStreamReader(fis,"utf-8");
			osw = new OutputStreamWriter(fos,"gbk"); // gbk输出乱码
			
			char[] data = new char[1024];
			int len;
			while((len = isr.read(data)) != -1) {
				osw.write(data, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
