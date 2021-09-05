package com.knowledge.tongyaxi.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Date_Api_Demo {
	public static void main(String[] args) throws ParseException {
		//内部维护一个long值，该值为UTC时间
		Date date = new Date();
		System.out.println(date);

		long time = date.getTime();//获取内部维护的long值
		time+=1000*60*60*24;
		date.setTime(time);//赋给long值
		System.out.println(date);

		 /**
		  * SimpleDateFormat
		  * 按照指定日期格式在Date与String之间转换
		  */
		 //Date格式化为String
		 Date now = new Date();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss a E");
		 String str = sdf.format(now);
		 System.out.println(str);

		 //String解析为Date
		 String str1 = "1995-02-12 20:20:20";
		 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date1 = sdf1.parse(str1);
		 System.out.println(date1);

		 /**
		  * Calendar 其方法可以对时间分量进行运算。
		  */
		 Calendar calendar = Calendar.getInstance();//静态方法--当前系统时间
		 System.out.println(calendar);//java.util.GregorianCalendar[time=1500105...
         //GregorianClender信息很多，但是不能直接反应出表示的日期

		 /**Date getTime()*/
		 //将当前Calendar所表示的时间以一个Date实例形式返回
		 Date date2 = calendar.getTime();
		 System.out.println(date2);   //Sat Jul 15 16:03:37 CST 2017

		 /**void setTime(Date date)*/
		 //是当前Calendar表示给定的Date所表示的日期
		 calendar.setTime(date2);

		 //void set(int filed,int value)
		 //为指定的时间分量设置指定的值
		 Calendar calendar1 = Calendar.getInstance();
		 calendar1.set(Calendar.YEAR,1995);
		 calendar1.set(Calendar.MONTH,1);//-1
		 calendar1.set(Calendar.DAY_OF_WEEK,3);//+1
		 calendar1.set(Calendar.HOUR_OF_DAY,5);
		 calendar1.set(Calendar.MINUTE,50);
		 calendar1.set(Calendar.SECOND,56);
		 System.out.println(calendar1.getTime());

		 //int get(int field)
		 //获取指定时间分量所对应的值,获取的是一个int值；
		 Calendar calendar2 = Calendar.getInstance();
		 int year = calendar2.get(Calendar.YEAR);
		 int month = calendar2.get(Calendar.MONTH)+1;
		 int day = calendar2.get(Calendar.DAY_OF_MONTH);
		 int h = calendar2.get(Calendar.HOUR_OF_DAY);
		 int m = calendar2.get(Calendar.MINUTE);
		 int s = calendar2.get(Calendar.SECOND);
		 System.out.println(year+"-"+month+"-"+day+"-"+h+"-"+m+"-"+s);

		 String[] date3 = {"日","一","二","三","四","五","六"};
		 int week =calendar2.get(Calendar.DAY_OF_WEEK)-1;
		 System.out.println("周"+date3[week]); //周六

		 //获取给定时间分量所允许的最大值
		 int max = calendar2.getActualMaximum(Calendar.DAY_OF_MONTH);
		 System.out.println("本月一共"+max+"天");

		 //void add(int filed,int value)
		 //对指定时间分量累加指定的值，若给定的值为负数，则是减去
		 /*
		  * 查看3年零2个月25天以后那周的周五是哪天？
		  */
		 Calendar calendar3 = Calendar.getInstance();
		 calendar3.add(Calendar.YEAR, 3);
		 calendar3.add(Calendar.MONTH, 2);
		 calendar3.add(Calendar.DAY_OF_YEAR, 25);
		 calendar3.set(Calendar.DAY_OF_WEEK, 6);
		 System.out.println(calendar3.getTime());
	}
}
