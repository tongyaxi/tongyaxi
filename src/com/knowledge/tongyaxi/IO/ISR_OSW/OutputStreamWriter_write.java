package com.knowledge.tongyaxi.IO.ISR_OSW;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * �ַ�����Reader,Writer
 * �ַ��������ַ�(char)Ϊ��λ��д���ݵģ�
 * ת������������ַ���;
 * @author tarena
 *
 */
public class OutputStreamWriter_write {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("�ر���ǿ2.txt");

		OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");//����ָ�����ַ�����

		osw.write("�����鷳�ˣ������鷳�ˡ�����");
		osw.write("��������ң���Ů��Ҫ�ң�ţ�к�æ�ġ�");

		System.out.println("д�����");
		osw.close();

	}
}
