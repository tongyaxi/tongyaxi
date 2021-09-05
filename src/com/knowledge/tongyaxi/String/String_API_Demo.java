package com.knowledge.tongyaxi.String;


public class String_API_Demo {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		/*
		 * String[] split(String regex)
		 * 按照给定的正则表达式可以匹配的部分拆分，拆开后
		 * 的若干字符串存入一个数组并返回
		 */
		String str = "abc123def456";
		String[] out = str.split("[0-9]+");
		System.out.println(out.length);   //2
		for(int i=0;i<out.length;i++){
			System.out.println(out[i]);   //abc def
		}

		String line = "100+200-200=100";
		String[] arr = line.split("[\\+\\-\\=]");
		System.out.println(arr.length);   //4
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);   //100 200 200 100
		}
		//用于图片重命名
		String name = "2017.jpg";
		String[] strr = name.split("\\.");
		//System.out.println(strr.length);   //2
		name = System.currentTimeMillis()+"."+strr[1];
		System.out.println(name);

		/*
		 * boolean matches(String regex)
		 * 使用给定的正则表达式来匹配当前字符串是否符合格式要求
		 */
		String email = "1114609657@qq.com";
		String regex = "[a-zA-Z0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
		boolean matches = email.matches(regex);
		if(true){
			System.out.println("是邮箱地址");
		}else{
			System.out.println("不是邮箱地址");
		}
		/**
		 * String replaceAll(String regex,String str)
		 * 将当前字符串中满足正则表达式的部分替换为给定字符串
		 */
		String str1 = "123abch45";
		line = str1.replaceAll("[0-9]", "*");
		System.out.println(line);   //***abch**

		String msg = "SB你妈";
		String reg = "SB";
		msg = msg.replace(reg,"*");
		System.out.println(msg);   //*你妈

		/**
		 * parsexxx(String str)
		 * 将字符串解析为对应的基本数据类型
		 * (该字符串能正确表示基本类型值)
		 */
		String str2 = "45687";
		int i = Integer.parseInt(str2);
		System.out.println(i);   //45687

		double d = Integer.parseInt(str2);
		System.out.println(d);   //45687.0

		/**
		 * 基本类型没有继承关系，不是Object子类。
		 * 目的：将8种基本类型以对象的总是存在；
		 *
		 */
		//基本类型与包装类转换
		//1.基本类型--》包装类  (new)不建议使用
		int a = 12;
		Integer aa = new Integer(a);

		double dd = 123.23;
		Double ddd = new Double(dd);

		long l = 123L;
		Long ll = new Long(l);

		Integer i1 = Integer.valueOf(123);  //建议使用静态方法valueOf
		Integer i2 = Integer.valueOf(123);
		System.out.println(i1==i2);   //true
		System.out.println(i1.equals(i2));   //true

		Double d1 = Double.valueOf(123.23);
		Double d2 = Double.valueOf(123.23);
		System.out.println(d1==d2);   //flase
		System.out.println(d1.equals(d2));   //true
		//2.包装类--》基本类型
		a = aa.intValue();
		dd = ddd.doubleValue();
		l = ll.longValue();

		byte b = aa.byteValue();
		System.out.println(b);   //12

		/**
		 * 数字类型的包装类都有两个常量分别表示其对应的基本类型的最大值
		 * 与最小值
		 */
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		System.out.println(max);   //2147483647
		System.out.println(min);   //-2147483648
		double dmax = Double.MAX_VALUE;
		double dmin = Double.MIN_VALUE;
		System.out.println(dmax);   //1.7976931348623157E308
		System.out.println(dmin);   //4.9E-324

		/**
		 * JDK1.5版本之后可以通过自动拆装箱来实现基本类型与包装类之间
		 * 的转换
		 */
		int m = new Integer(1);//自动将包装类转换为基本类型
		//int m = mm.intValue();
		Integer n = 1;//自动将基本类型转换为包装类
		//Integer n = Integer.valueOf(1);

		/**
		 * Object:顶级父类，定义一个类默认继承Object
		 * 重写tostring()  返回一个字符串，原则：用一个字符串来描述当前对象
		 * （包含当前对象的属性信息）
		 * 返回的字符串时该对象的句柄（地址信息）
		 */

		/**
		 * 重写boolean equals()
		 * 1.任何对象与null比较都应返回false
           2.两个对象不属于同一个类时应返回false
           3.同一个对象equals比较应当恒等为true
		 */

		/**
		 * equals与"=="区别
		 *
		 * "=="是值比较，对于引用类型变量而言，该变量保存的是对象的地址，
		 * 所以使用"=="比较时，意思为两个变量的地址是否相等，换句话说就
		 * 是看两个变量引用的是否为同一个对象
		 * equals是内容比较，对于两个引用变量而言，是比较两个变量所引用
		 * 的对象内容是否相同。
           举个例子，	就好像一对双胞胎，他们是两个独立的个体，是两个对
           象。所以那么用"=="比较是 false。但是因为他们“长得一样”，所
           以equals方法比较是true，
           我们也可以变相的理解为:"=="是判断是否为同一个，而"equals"是判
           断像不像。
		 */
	}
}
