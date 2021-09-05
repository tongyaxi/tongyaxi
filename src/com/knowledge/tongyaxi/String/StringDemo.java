package com.knowledge.tongyaxi.String;


public class StringDemo {
	public static void main(String[] args) {
		String s2 = "123abc";

		String str = "123";
		String s4 = str+"abc";
		System.out.println(s4);   //123abc
		System.out.println(s2==s4);   //false

		/*
		 * 编译器自动引入java.lang.StringBuilder类，创建StringBuilder对象，用以
		 * 构造最终的String,并未每个字符串调用一次StringBuilder的append();
		 */
		//StringBuilder

		//append(String str)
		String line = "地表最强";
		StringBuilder builder = new StringBuilder(line);
		builder.append("仝亚西");
		System.out.println(builder.toString());   //地表最强仝亚西

		//delete(int start,int end)
		builder.delete(0, 4);
		System.out.println(builder.toString());   //仝亚西

		//replace(int s,int e,String str) 将指定范围的字符串替换为给定字符串
		builder.replace(0, 2, "宇宙");
		System.out.println(builder.toString());   //宇宙西

		//insert(int index,String str)  指定位置插入
		builder.insert(2, "吊");
		System.out.println(builder.toString());   //宇宙吊西

		//char charAt(int index) 指定下标对应的字符
		String msg = "hahahahahaha";
		char c = msg.charAt(2);
		System.out.println(c);   //h

		//int indexOf(String str) 返回给定字符串在当前字符串中的位置
		String str1 = "i love you";
		int i = str1.indexOf("v");
		System.out.println(i);   //4

		int n = str1.indexOf("v", 5);   //从指定下标位置开始
		System.out.println(n);   //-1 不包含，返回-1

		int t = str1.lastIndexOf("o");   //从后向前搜索
		System.out.println(t);   //8

		//int length()
		String str2 = "fuck you";
		System.out.println(str2.length());   //8

		//boolean startsWith(String str)
		//boolean endsWith(String str)
		String str3 = "your mother fucker";
		boolean starts = str3.startsWith("your");   //是否以此参数起始
		boolean ends = str3.endsWith("er");   //此参数是否为该字符串的后缀
		System.out.println(starts);
		System.out.println(ends);

		//String substring(int start,int end);  返回参数指定的子字符串
		String str4 = "fuck beach";
		String sub = str4.substring(5, 9);   //beac
		System.out.println(sub);

		sub = str4.substring(5);
		System.out.println(sub);   //beach  返回参数指定位置开始至结束

		//String trim();去除字符串两边空白字符
		String str5 = "  yes  ";
		String trim = str5.trim();
		System.out.println(trim);   //yes

		//static String valueOf();  //返回一个参数内容的String
		int ii = 123;
		String str6 = String.valueOf(ii);
		System.out.println(str6+4);   //1234

		double d = 2.32;
		String str7 = String.valueOf(d);
		System.out.println(str7+3);   //2.323

		//String toLowerCase()
		//String toUpperCase()  转换大小写
		String str8 = "fuck you man";
		String lower = str8.toLowerCase();
		String upper = str8.toUpperCase();
		System.out.println(lower);
		System.out.printf(upper);    //FUCK YOU MAN
	}
}
