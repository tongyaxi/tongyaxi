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
            // ������ӡ�����,����Ϊ�Զ�ˢ��ģʽ(д�뻻�з����ֽ� '\n' ʱ����ˢ�����������)
            ps = new PrintStream(fos, true);
            if (ps != null) {// �ѱ�׼�����(����̨���)�ĳ��ļ�
                System.setOut(ps);
            }


            for (int i = 0; i <= 255; i++) { // ���ASCII�ַ�
                System.out.print((char) i);
                if (i % 50 == 0) { // ÿ50������һ��
                    System.out.println(); // ����
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
			fos = new FileOutputStream("�ر���ǿ4.txt");
			osw = new OutputStreamWriter(fos,"utf-8");
			pw = new PrintWriter(osw);
			
			for(int i=0;i<2;i++) {
				if(i==0) {
					pw.println("����̨���¸��������ԭ�ش�ת");
					pw.println("��һ������Ĵ���΢Ц���ֿ���........");
				} else {
					pw.println(",,,,,,,,");
				}
				System.out.println("д�����");
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
