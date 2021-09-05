package com.knowledge.tongyaxi.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Date_Api_Demo {
	public static void main(String[] args) throws ParseException {
		//�ڲ�ά��һ��longֵ����ֵΪUTCʱ��
		Date date = new Date();
		System.out.println(date);

		long time = date.getTime();//��ȡ�ڲ�ά����longֵ
		time+=1000*60*60*24;
		date.setTime(time);//����longֵ
		System.out.println(date);

		 /**
		  * SimpleDateFormat
		  * ����ָ�����ڸ�ʽ��Date��String֮��ת��
		  */
		 //Date��ʽ��ΪString
		 Date now = new Date();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss a E");
		 String str = sdf.format(now);
		 System.out.println(str);

		 //String����ΪDate
		 String str1 = "1995-02-12 20:20:20";
		 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date1 = sdf1.parse(str1);
		 System.out.println(date1);

		 /**
		  * Calendar �䷽�����Զ�ʱ������������㡣
		  */
		 Calendar calendar = Calendar.getInstance();//��̬����--��ǰϵͳʱ��
		 System.out.println(calendar);//java.util.GregorianCalendar[time=1500105...
         //GregorianClender��Ϣ�ܶ࣬���ǲ���ֱ�ӷ�Ӧ����ʾ������

		 /**Date getTime()*/
		 //����ǰCalendar����ʾ��ʱ����һ��Dateʵ����ʽ����
		 Date date2 = calendar.getTime();
		 System.out.println(date2);   //Sat Jul 15 16:03:37 CST 2017

		 /**void setTime(Date date)*/
		 //�ǵ�ǰCalendar��ʾ������Date����ʾ������
		 calendar.setTime(date2);

		 //void set(int filed,int value)
		 //Ϊָ����ʱ���������ָ����ֵ
		 Calendar calendar1 = Calendar.getInstance();
		 calendar1.set(Calendar.YEAR,1995);
		 calendar1.set(Calendar.MONTH,1);//-1
		 calendar1.set(Calendar.DAY_OF_WEEK,3);//+1
		 calendar1.set(Calendar.HOUR_OF_DAY,5);
		 calendar1.set(Calendar.MINUTE,50);
		 calendar1.set(Calendar.SECOND,56);
		 System.out.println(calendar1.getTime());

		 //int get(int field)
		 //��ȡָ��ʱ���������Ӧ��ֵ,��ȡ����һ��intֵ��
		 Calendar calendar2 = Calendar.getInstance();
		 int year = calendar2.get(Calendar.YEAR);
		 int month = calendar2.get(Calendar.MONTH)+1;
		 int day = calendar2.get(Calendar.DAY_OF_MONTH);
		 int h = calendar2.get(Calendar.HOUR_OF_DAY);
		 int m = calendar2.get(Calendar.MINUTE);
		 int s = calendar2.get(Calendar.SECOND);
		 System.out.println(year+"-"+month+"-"+day+"-"+h+"-"+m+"-"+s);

		 String[] date3 = {"��","һ","��","��","��","��","��"};
		 int week =calendar2.get(Calendar.DAY_OF_WEEK)-1;
		 System.out.println("��"+date3[week]); //����

		 //��ȡ����ʱ���������������ֵ
		 int max = calendar2.getActualMaximum(Calendar.DAY_OF_MONTH);
		 System.out.println("����һ��"+max+"��");

		 //void add(int filed,int value)
		 //��ָ��ʱ������ۼ�ָ����ֵ����������ֵΪ���������Ǽ�ȥ
		 /*
		  * �鿴3����2����25���Ժ����ܵ����������죿
		  */
		 Calendar calendar3 = Calendar.getInstance();
		 calendar3.add(Calendar.YEAR, 3);
		 calendar3.add(Calendar.MONTH, 2);
		 calendar3.add(Calendar.DAY_OF_YEAR, 25);
		 calendar3.set(Calendar.DAY_OF_WEEK, 6);
		 System.out.println(calendar3.getTime());
	}
}
