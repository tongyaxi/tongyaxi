package com.knowledge.tongyaxi.IO.FIS_FOS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class FIS_FOS {
	public static void main(String[] args) throws Exception {
        File file = new File("FileOutputStream.txt");  //����File����
        try{  //��׽�쳣
       	 FileOutputStream fos = new FileOutputStream(file);  //����FileOutputStream����
       	 byte[] data = "���˽⣬�뿪����Ҷ��".getBytes();//����byte������
       	 fos.write(data);//����������Ϣд�뵽�ļ���
       	 fos.close(); //�����ر�
        }catch(Exception e){  //�����쳣��Ϣ
       	 e.printStackTrace();//����쳣��Ϣ
        }

        try{
       	 FileInputStream fis = new FileInputStream(file);//����FileInputStream
       	 byte[] data = new byte[1024*10];//����byte����
       	 int len = fis.read(data);//���ļ��ж�ȡ��Ϣ
       	 String str = new String(data,0,len);
       	 System.out.println(str);//���ļ��е���Ϣ���
       	 fis.close();
        }catch(Exception e){
       	 e.printStackTrace();
        }
}
}
