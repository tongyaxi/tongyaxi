package com.knowledge.tongyaxi.String;


public class StringDemo {
	public static void main(String[] args) {
		String s2 = "123abc";

		String str = "123";
		String s4 = str+"abc";
		System.out.println(s4);   //123abc
		System.out.println(s2==s4);   //false

		/*
		 * �������Զ�����java.lang.StringBuilder�࣬����StringBuilder��������
		 * �������յ�String,��δÿ���ַ�������һ��StringBuilder��append();
		 */
		//StringBuilder

		//append(String str)
		String line = "�ر���ǿ";
		StringBuilder builder = new StringBuilder(line);
		builder.append("������");
		System.out.println(builder.toString());   //�ر���ǿ������

		//delete(int start,int end)
		builder.delete(0, 4);
		System.out.println(builder.toString());   //������

		//replace(int s,int e,String str) ��ָ����Χ���ַ����滻Ϊ�����ַ���
		builder.replace(0, 2, "����");
		System.out.println(builder.toString());   //������

		//insert(int index,String str)  ָ��λ�ò���
		builder.insert(2, "��");
		System.out.println(builder.toString());   //�������

		//char charAt(int index) ָ���±��Ӧ���ַ�
		String msg = "hahahahahaha";
		char c = msg.charAt(2);
		System.out.println(c);   //h

		//int indexOf(String str) ���ظ����ַ����ڵ�ǰ�ַ����е�λ��
		String str1 = "i love you";
		int i = str1.indexOf("v");
		System.out.println(i);   //4

		int n = str1.indexOf("v", 5);   //��ָ���±�λ�ÿ�ʼ
		System.out.println(n);   //-1 ������������-1

		int t = str1.lastIndexOf("o");   //�Ӻ���ǰ����
		System.out.println(t);   //8

		//int length()
		String str2 = "fuck you";
		System.out.println(str2.length());   //8

		//boolean startsWith(String str)
		//boolean endsWith(String str)
		String str3 = "your mother fucker";
		boolean starts = str3.startsWith("your");   //�Ƿ��Դ˲�����ʼ
		boolean ends = str3.endsWith("er");   //�˲����Ƿ�Ϊ���ַ����ĺ�׺
		System.out.println(starts);
		System.out.println(ends);

		//String substring(int start,int end);  ���ز���ָ�������ַ���
		String str4 = "fuck beach";
		String sub = str4.substring(5, 9);   //beac
		System.out.println(sub);

		sub = str4.substring(5);
		System.out.println(sub);   //beach  ���ز���ָ��λ�ÿ�ʼ������

		//String trim();ȥ���ַ������߿հ��ַ�
		String str5 = "  yes  ";
		String trim = str5.trim();
		System.out.println(trim);   //yes

		//static String valueOf();  //����һ���������ݵ�String
		int ii = 123;
		String str6 = String.valueOf(ii);
		System.out.println(str6+4);   //1234

		double d = 2.32;
		String str7 = String.valueOf(d);
		System.out.println(str7+3);   //2.323

		//String toLowerCase()
		//String toUpperCase()  ת����Сд
		String str8 = "fuck you man";
		String lower = str8.toLowerCase();
		String upper = str8.toUpperCase();
		System.out.println(lower);
		System.out.printf(upper);    //FUCK YOU MAN
	}
}
