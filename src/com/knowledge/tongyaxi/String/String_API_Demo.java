package com.knowledge.tongyaxi.String;


public class String_API_Demo {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		/*
		 * String[] split(String regex)
		 * ���ո�����������ʽ����ƥ��Ĳ��ֲ�֣��𿪺�
		 * �������ַ�������һ�����鲢����
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
		//����ͼƬ������
		String name = "2017.jpg";
		String[] strr = name.split("\\.");
		//System.out.println(strr.length);   //2
		name = System.currentTimeMillis()+"."+strr[1];
		System.out.println(name);

		/*
		 * boolean matches(String regex)
		 * ʹ�ø�����������ʽ��ƥ�䵱ǰ�ַ����Ƿ���ϸ�ʽҪ��
		 */
		String email = "1114609657@qq.com";
		String regex = "[a-zA-Z0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
		boolean matches = email.matches(regex);
		if(true){
			System.out.println("�������ַ");
		}else{
			System.out.println("���������ַ");
		}
		/**
		 * String replaceAll(String regex,String str)
		 * ����ǰ�ַ���������������ʽ�Ĳ����滻Ϊ�����ַ���
		 */
		String str1 = "123abch45";
		line = str1.replaceAll("[0-9]", "*");
		System.out.println(line);   //***abch**

		String msg = "SB����";
		String reg = "SB";
		msg = msg.replace(reg,"*");
		System.out.println(msg);   //*����

		/**
		 * parsexxx(String str)
		 * ���ַ�������Ϊ��Ӧ�Ļ�����������
		 * (���ַ�������ȷ��ʾ��������ֵ)
		 */
		String str2 = "45687";
		int i = Integer.parseInt(str2);
		System.out.println(i);   //45687

		double d = Integer.parseInt(str2);
		System.out.println(d);   //45687.0

		/**
		 * ��������û�м̳й�ϵ������Object���ࡣ
		 * Ŀ�ģ���8�ֻ��������Զ�������Ǵ��ڣ�
		 *
		 */
		//�����������װ��ת��
		//1.��������--����װ��  (new)������ʹ��
		int a = 12;
		Integer aa = new Integer(a);

		double dd = 123.23;
		Double ddd = new Double(dd);

		long l = 123L;
		Long ll = new Long(l);

		Integer i1 = Integer.valueOf(123);  //����ʹ�þ�̬����valueOf
		Integer i2 = Integer.valueOf(123);
		System.out.println(i1==i2);   //true
		System.out.println(i1.equals(i2));   //true

		Double d1 = Double.valueOf(123.23);
		Double d2 = Double.valueOf(123.23);
		System.out.println(d1==d2);   //flase
		System.out.println(d1.equals(d2));   //true
		//2.��װ��--����������
		a = aa.intValue();
		dd = ddd.doubleValue();
		l = ll.longValue();

		byte b = aa.byteValue();
		System.out.println(b);   //12

		/**
		 * �������͵İ�װ�඼�����������ֱ��ʾ���Ӧ�Ļ������͵����ֵ
		 * ����Сֵ
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
		 * JDK1.5�汾֮�����ͨ���Զ���װ����ʵ�ֻ����������װ��֮��
		 * ��ת��
		 */
		int m = new Integer(1);//�Զ�����װ��ת��Ϊ��������
		//int m = mm.intValue();
		Integer n = 1;//�Զ�����������ת��Ϊ��װ��
		//Integer n = Integer.valueOf(1);

		/**
		 * Object:�������࣬����һ����Ĭ�ϼ̳�Object
		 * ��дtostring()  ����һ���ַ�����ԭ����һ���ַ�����������ǰ����
		 * ��������ǰ�����������Ϣ��
		 * ���ص��ַ���ʱ�ö���ľ������ַ��Ϣ��
		 */

		/**
		 * ��дboolean equals()
		 * 1.�κζ�����null�Ƚ϶�Ӧ����false
           2.������������ͬһ����ʱӦ����false
           3.ͬһ������equals�Ƚ�Ӧ�����Ϊtrue
		 */

		/**
		 * equals��"=="����
		 *
		 * "=="��ֵ�Ƚϣ������������ͱ������ԣ��ñ���������Ƕ���ĵ�ַ��
		 * ����ʹ��"=="�Ƚ�ʱ����˼Ϊ���������ĵ�ַ�Ƿ���ȣ����仰˵��
		 * �ǿ������������õ��Ƿ�Ϊͬһ������
		 * equals�����ݱȽϣ������������ñ������ԣ��ǱȽ���������������
		 * �Ķ��������Ƿ���ͬ��
           �ٸ����ӣ�	�ͺ���һ��˫��̥�����������������ĸ��壬��������
           ��������ô��"=="�Ƚ��� false��������Ϊ���ǡ�����һ��������
           ��equals�����Ƚ���true��
           ����Ҳ���Ա�������Ϊ:"=="���ж��Ƿ�Ϊͬһ������"equals"����
           ������
		 */
	}
}
