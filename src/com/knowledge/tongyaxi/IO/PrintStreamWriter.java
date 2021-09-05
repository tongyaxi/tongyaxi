package com.knowledge.tongyaxi.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

import org.junit.Test;

public class PrintStreamWriter {
	
	@Test
    public void test2() {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("text.txt"));
            // 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            ps = new PrintStream(fos, true);
            if (ps != null) {// 把标准输出流(控制台输出)改成文件
                System.setOut(ps);
            }


            for (int i = 0; i <= 255; i++) { // 输出ASCII字符
                System.out.print((char) i);
                if (i % 50 == 0) { // 每50个数据一行
                    System.out.println(); // 换行
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }

    }
	
	@Test
	public void test02() {
		FileOutputStream fos = null;

		OutputStreamWriter osw = null;
		
		PrintWriter pw = null;
		try {
			fos = new FileOutputStream("地表最强4.txt");
			osw = new OutputStreamWriter(fos,"utf-8");
			pw = new PrintWriter(osw);
			
			for(int i=0;i<2;i++) {
				if(i==0) {
					pw.println("从天台向下俯瞰，暴力在原地打转");
					pw.println("上一代解决的答案是微笑不抵抗。........");
				} else {
					pw.println(",,,,,,,,");
				}
				System.out.println("写出完毕");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally{
			if(pw != null) {
				pw.close();
			}
		}
	}

}
