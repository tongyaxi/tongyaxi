package com.knowledge.tongyaxi.IO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Test;

public class FileReaderWriterTest {
	
	Logger logger = Logger.getLogger(FileReaderWriterTest.class);

	@Test
	public void testFileReader01() {
		
		FileReader fr = null;
		try {
			
			File file = new File("hello.txt");
			fr = new FileReader(file);
			
			int data;
			while((data = fr.read()) != -1) { // 返回读入的一个字符，读到文件末尾，返回-1。
				System.out.print((char)data);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fr != null)
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	@Test
	public void testFileReader02() {
		
		FileReader fr = null;
		try {
			
			File file = new File("hello.txt");
			fr = new FileReader(file);
			
			char[] cbuffer = new char[3];
			int len;
			// read(char[] cbuf):返回每次读入cbuf数组中的字符的个数。如果达到文件末尾，返回-1
			while((len = fr.read(cbuffer)) != -1) {
//				for(int i = 0; i < len; i++) {
//					System.out.print(cbuffer[i]);
//				}
				// 方式二：
				String str = new String(cbuffer,0,len);
				System.out.print(str);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fr != null)
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	@Test
	public void testFileWriter03() {
		
		FileWriter fw = null;
		try {
			
			File file = new File("hello1.txt");
			fw = new FileWriter(file, true);
			
			fw.write("hello1\n");
			fw.write("hello2");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	@Test
	public void testFileReaderFileWriter04() {
		
		FileReader fr = null;
		FileWriter fw = null;
		try {
			
			File fileRead = new File("kcg.png");
			File fileWrite = new File("kcg1.png");
			
			fr = new FileReader(fileRead);
			fw = new FileWriter(fileWrite, true);
			
			char[] cBuffer = new char[3];
			int len; // 记录每次读入到cBuffer数组中的字符的个数
			while((len = fr.read(cBuffer)) != -1) {
				fw.write(cBuffer,0,len); // 每次写出len个字符
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(fr != null)
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
