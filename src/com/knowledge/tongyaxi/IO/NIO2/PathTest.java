package com.knowledge.tongyaxi.IO.NIO2;

import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 1. jdk 7.0 ʱ�������� Path��Paths��Files�����ࡣ
 * 2.�������������ڣ�java.nio.file���¡�
 * 3.Path���Կ�����java.io.File��������汾��Ҳ���Ա�ʾ�ļ����ļ�Ŀ¼����ƽ̨�޹�
 * <p>
 * 4.���ʵ����Path:ʹ��Paths.
 * static Path get(String first, String �� more) : ���ڽ�����ַ���������·��
 * static Path get(URI uri): ����ָ��uri��Ӧ��Path·��
 *
 */
public class PathTest {

    //���ʹ��Pathsʵ����Path
    @Test
    public void test1() {
        Path path1 = Paths.get("d:\\nio\\hello.txt");//new File(String filepath)

        Path path2 = Paths.get("d:\\", "nio\\hello.txt");//new File(String parent,String filename);

        System.out.println(path1);
        System.out.println(path2);

        Path path3 = Paths.get("d:\\", "nio");
        System.out.println(path3);
    }

    //Path�еĳ��÷���
    @Test
    public void test2() {
        Path path1 = Paths.get("d:\\", "nio\\nio1\\nio2\\hello.txt");
        Path path2 = Paths.get("hello.txt");

//		String toString() �� ���ص��� Path ������ַ�����ʾ��ʽ
        System.out.println(path1);

//		boolean startsWith(String path) : �ж��Ƿ��� path ·����ʼ
        System.out.println(path1.startsWith("d:\\nio"));
//		boolean endsWith(String path) : �ж��Ƿ��� path ·������
        System.out.println(path1.endsWith("hello.txt"));
//		boolean isAbsolute() : �ж��Ƿ��Ǿ���·��
        System.out.println(path1.isAbsolute() + "~");
        System.out.println(path2.isAbsolute() + "~");
//		Path getParent() ������Path�����������·���������� Path ����ָ�����ļ�·��
        System.out.println(path1.getParent());
        System.out.println(path2.getParent());
//		Path getRoot() �����ص��� Path ����ĸ�·��
        System.out.println(path1.getRoot());
        System.out.println(path2.getRoot());
//		Path getFileName() : ��������� Path ����������ļ���
        System.out.println(path1.getFileName() + "~");
        System.out.println(path2.getFileName() + "~");
//		int getNameCount() : ����Path ��Ŀ¼����Ԫ�ص�����
//		Path getName(int idx) : ����ָ������λ�� idx ��·������
        for (int i = 0; i < path1.getNameCount(); i++) {
            System.out.println(path1.getName(i) + "*****");
        }

//		Path toAbsolutePath() : ��Ϊ����·�����ص��� Path ����
        System.out.println(path1.toAbsolutePath());
        System.out.println(path2.toAbsolutePath());
//		Path resolve(Path p) :�ϲ�����·�������غϲ����·����Ӧ��Path����
        Path path3 = Paths.get("d:\\", "nio");
        Path path4 = Paths.get("nioo\\hi.txt");
        path3 = path3.resolve(path4);
        System.out.println(path3);

//		File toFile(): ��Pathת��ΪFile��Ķ���
        File file = path1.toFile();//Path--->File��ת��

        Path newPath = file.toPath();//File--->Path��ת��

    }


}
