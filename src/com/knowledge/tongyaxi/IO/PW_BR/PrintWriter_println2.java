package com.knowledge.tongyaxi.IO.PW_BR;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * ���������������е�����
 * @author tarena
 *
 */
public class PrintWriter_println2 {

	public static void main(String[] args) throws FileNotFoundException {
		
		FileOutputStream fos = null;

		OutputStreamWriter osw = null;
		
		PrintWriter pw = null;
		try {
			fos = new FileOutputStream("�ر���ǿ4.txt");
			osw = new OutputStreamWriter(fos,"utf-8");
			pw = new PrintWriter(osw);
			
			pw.println("����̨���¸��������ԭ�ش�ת");
			pw.println("��һ������Ĵ���΢Ц���ֿ���");
			System.out.println("д�����");
			
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
