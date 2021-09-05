package com.knowledge.tongyaxi.IO.FIS_FOS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class FIS_FOS {
	public static void main(String[] args) throws Exception {
        File file = new File("FileOutputStream.txt");  //创建File对象
        try{  //捕捉异常
       	 FileOutputStream fos = new FileOutputStream(file);  //创建FileOutputStream对象
       	 byte[] data = "我了解，离开树的叶；".getBytes();//创建byte型数组
       	 fos.write(data);//将数组中信息写入到文件中
       	 fos.close(); //将流关闭
        }catch(Exception e){  //处理异常信息
       	 e.printStackTrace();//输出异常信息
        }

        try{
       	 FileInputStream fis = new FileInputStream(file);//创建FileInputStream
       	 byte[] data = new byte[1024*10];//创建byte数组
       	 int len = fis.read(data);//从文件中读取信息
       	 String str = new String(data,0,len);
       	 System.out.println(str);//将文件中的信息输出
       	 fis.close();
        }catch(Exception e){
       	 e.printStackTrace();
        }
}
}
