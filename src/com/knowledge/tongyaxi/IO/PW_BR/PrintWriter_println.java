package com.knowledge.tongyaxi.IO.PW_BR;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * �����ַ�����BufferedWriter,BufferedReader
 *     ���ж�д��������
 *             PrintWriter��
 *             Ҳ�ǻ����ַ������߱��Զ�ˢ���й��ܣ��ڲ�����BufferedWriter������ʹ�ã�
 * @author tarena
 *
 */
public class PrintWriter_println {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter pw = new PrintWriter("�ر���ǿ3.txt");//Ҳ����ָ��String path,ָ��charSetName

		pw.println("Ϊ�㵯��Ф���ҹ������������ȥ�İ��顣");
		pw.println("����Ϊ���������������¹��µ��٣�");

		System.out.println("д�����");
		pw.close();

	}
}
