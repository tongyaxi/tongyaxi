package com.knowledge.tongyaxi.IO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

/**
 * 1.RandomAccessFileֱ�Ӽ̳���java.lang.Object�࣬ʵ����DataInput��DataOutput�ӿ�
 * 2.RandomAccessFile�ȿ�����Ϊһ�����������ֿ�����Ϊһ�������
 *
 * 3.���RandomAccessFile��Ϊ�����ʱ��д�������ļ���������ڣ�����ִ�й������Զ�������
 *   ���д�������ļ����ڣ�����ԭ���ļ����ݽ��и��ǡ���Ĭ������£���ͷ���ǣ�
 *
 * 4. ����ͨ����صĲ�����ʵ��RandomAccessFile�����롱���ݵ�Ч��
 *
 */
public class RandomAccessFileTest {

	@Test
    public void test1() {

        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("kcg.png"),"r");
            raf2 = new RandomAccessFile(new File("kcg1.png"),"rw");
            
            byte[] buffer = new byte[1024];
            int len;
            while((len = raf1.read(buffer)) != -1){
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(raf2 != null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
	
	@Test
    public void test2() throws IOException {

        RandomAccessFile raf1 = new RandomAccessFile("hello.txt","rw");

        raf1.seek(3);//��ָ������Ǳ�Ϊ3��λ��
        raf1.write("xyz".getBytes());//

        raf1.close();

    }
	
	/*
    ʹ��RandomAccessFileʵ�����ݵĲ���Ч��
     */
    @Test
    public void test3() throws IOException {

        RandomAccessFile raf1 = new RandomAccessFile("hello.txt","rw");

        raf1.seek(3);//��ָ������Ǳ�Ϊ3��λ��
        //����ָ��3������������ݵ�StringBuilder��
        StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while((len = raf1.read(buffer)) != -1){
            builder.append(new String(buffer,0,len)) ;
        }
        //����ָ�룬д�롰xyz��
        raf1.seek(3);
        raf1.write("xyz".getBytes());

        //��StringBuilder�е�����д�뵽�ļ���
        raf1.write(builder.toString().getBytes());

        raf1.close();

        //˼������StringBuilder�滻ΪByteArrayOutputStream
    }
}
