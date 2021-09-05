package com.knowledge.tongyaxi.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

/**
 * ��������ʹ��
 * 1.ObjectInputStream �� ObjectOutputStream
 * 2.���ã����ڴ洢�Ͷ�ȡ���������������ݻ����Ĵ�����������ǿ��֮�����ǿ��԰�Java�еĶ���д�뵽����Դ�У�Ҳ�ܰѶ��������Դ�л�ԭ������
 *
 * 3.Ҫ��һ��java�����ǿ����л��ģ���Ҫ������Ӧ��Ҫ�󡣼�Person.java
 *
 * 4.���л����ƣ�
 * �������л�����������ڴ��е�Java����ת����ƽ̨�޹صĶ����������Ӷ����������
 * ���������־õر����ڴ����ϣ���ͨ�����罫���ֶ����������䵽��һ������ڵ㡣
 * �����������ȡ�����ֶ����������Ϳ��Իָ���ԭ����Java����.
 */
public class ObjectInputOutputStreamTest {
	
	/*
    ���л����̣����ڴ��е�java���󱣴浽�����л�ͨ�����紫���ȥ
    ʹ��ObjectOutputStreamʵ��
     */
    @Test
    public void testObjectOutputStream(){
        ObjectOutputStream oos = null;

        try {
            //1.
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            //2.
            oos.writeObject(new String("�Ұ������찲��"));
            oos.flush();//ˢ�²���

            oos.writeObject(new Person("����",23));
            oos.flush();

            oos.writeObject(new Person("��ѧ��",23,1001,new Account(5000)));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null){
                //3.
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }
    
    /*
    �����л����������ļ��еĶ���ԭΪ�ڴ��е�һ��java����
    ʹ��ObjectInputStream��ʵ��
     */
    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            Object obj = ois.readObject();
            String str = (String) obj;

            Person p = (Person) ois.readObject();
            Person p1 = (Person) ois.readObject();

            System.out.println(str);
            System.out.println(p);
            System.out.println(p1);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }



    }

}
