package com.knowledge.tongyaxi.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.junit.Test;

public class FileInputOutputStreamTest {
	// 使用字节流FileInputStream处理文本文件，可能出现乱码。
	@Test
	public void FileInputStreamTest01() {
		
		FileInputStream fis = null;
		
		try {
			File file = new File("hello.txt");
			
			fis	= new FileInputStream(file);
			
			byte[] buffer = new byte[3];
			int len; //记录每次读取字节的个数
			while ((len = fis.read(buffer)) != -1) {
				
				String string = new String(buffer,0,len);
				System.out.print(string);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	// 对图片进行复制
	@Test
	public void FileInputStreamTest02() {
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			
			File fileRead = new File("kcg.png");
			File fileWrite = new File("kcg1.png");
			
			fis = new FileInputStream(fileRead);
			fos = new FileOutputStream(fileWrite);
			
			byte[] buffer = new byte[5];
			int len;
			while((len = fis.read(buffer)) != -1) {
				fos.write(buffer,0,len);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
