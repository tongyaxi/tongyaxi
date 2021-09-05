package com.knowledge.tongyaxi.IO.NIO2;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.util.Iterator;

/**
 * Files�������ʹ�ã������ļ���Ŀ¼�Ĺ�����
 * @author shkstart
 * @create 2019 ���� 2:44
 */
public class FilesTest {

	@Test
	public void test1() throws IOException{
		Path path1 = Paths.get("d:\\nio", "hello.txt");
		Path path2 = Paths.get("atguigu.txt");
		
//		Path copy(Path src, Path dest, CopyOption �� how) : �ļ��ĸ���
		//Ҫ�븴�Ƴɹ���Ҫ��path1��Ӧ�������ϵ��ļ����ڡ�path1��Ӧ���ļ�û��Ҫ��
//		Files.copy(path1, path2, StandardCopyOption.REPLACE_EXISTING);
		
//		Path createDirectory(Path path, FileAttribute<?> �� attr) : ����һ��Ŀ¼
		//Ҫ��ִ�гɹ���Ҫ��path��Ӧ�������ϵ��ļ�Ŀ¼�����ڡ�һ�����ڣ��׳��쳣��
		Path path3 = Paths.get("d:\\nio\\nio1");
//		Files.createDirectory(path3);
		
//		Path createFile(Path path, FileAttribute<?> �� arr) : ����һ���ļ�
		//Ҫ��ִ�гɹ���Ҫ��path��Ӧ�������ϵ��ļ������ڡ�һ�����ڣ��׳��쳣��
		Path path4 = Paths.get("d:\\nio\\hi.txt");
//		Files.createFile(path4);
		
//		void delete(Path path) : ɾ��һ���ļ�/Ŀ¼����������ڣ�ִ�б���
//		Files.delete(path4);
		
//		void deleteIfExists(Path path) : Path��Ӧ���ļ�/Ŀ¼������ڣ�ִ��ɾ��.��������ڣ�����ִ�н���
		Files.deleteIfExists(path3);
		
//		Path move(Path src, Path dest, CopyOption��how) : �� src �ƶ��� dest λ��
		//Ҫ��ִ�гɹ���src��Ӧ�������ϵ��ļ���Ҫ���ڣ�dest��Ӧ���ļ�û��Ҫ��
//		Files.move(path1, path2, StandardCopyOption.ATOMIC_MOVE);
		
//		long size(Path path) : ���� path ָ���ļ��Ĵ�С
		long size = Files.size(path2);
		System.out.println(size);

	}

	@Test
	public void test2() throws IOException{
		Path path1 = Paths.get("d:\\nio", "hello.txt");
		Path path2 = Paths.get("atguigu.txt");
//		boolean exists(Path path, LinkOption �� opts) : �ж��ļ��Ƿ����
		System.out.println(Files.exists(path2, LinkOption.NOFOLLOW_LINKS));

//		boolean isDirectory(Path path, LinkOption �� opts) : �ж��Ƿ���Ŀ¼
		//��Ҫ���path��Ӧ�������ļ����ڡ�
		System.out.println(Files.isDirectory(path1, LinkOption.NOFOLLOW_LINKS));

//		boolean isRegularFile(Path path, LinkOption �� opts) : �ж��Ƿ����ļ�

//		boolean isHidden(Path path) : �ж��Ƿ��������ļ�
		//Ҫ���path��Ӧ�������ϵ��ļ���Ҫ���ڡ��ſ��ж��Ƿ����ء��������쳣��
//		System.out.println(Files.isHidden(path1));

//		boolean isReadable(Path path) : �ж��ļ��Ƿ�ɶ�
		System.out.println(Files.isReadable(path1));
//		boolean isWritable(Path path) : �ж��ļ��Ƿ��д
		System.out.println(Files.isWritable(path1));
//		boolean notExists(Path path, LinkOption �� opts) : �ж��ļ��Ƿ񲻴���
		System.out.println(Files.notExists(path1, LinkOption.NOFOLLOW_LINKS));
	}

	/**
	 * StandardOpenOption.READ:��ʾ��Ӧ��Channel�ǿɶ��ġ�
	 * StandardOpenOption.WRITE����ʾ��Ӧ��Channel�ǿ�д�ġ�
	 * StandardOpenOption.CREATE�����Ҫд�����ļ������ڣ��򴴽���������ڣ�����
	 * StandardOpenOption.CREATE_NEW�����Ҫд�����ļ������ڣ��򴴽���������ڣ����쳣
	 *
	 * @author shkstart ���䣺shkstart@126.com
	 * @throws IOException
	 */
	@Test
	public void test3() throws IOException{
		Path path1 = Paths.get("d:\\nio", "hello.txt");

//		InputStream newInputStream(Path path, OpenOption��how):��ȡ InputStream ����
		InputStream inputStream = Files.newInputStream(path1, StandardOpenOption.READ);

//		OutputStream newOutputStream(Path path, OpenOption��how) : ��ȡ OutputStream ����
		OutputStream outputStream = Files.newOutputStream(path1, StandardOpenOption.WRITE,StandardOpenOption.CREATE);


//		SeekableByteChannel newByteChannel(Path path, OpenOption��how) : ��ȡ��ָ���ļ������ӣ�how ָ���򿪷�ʽ��
		SeekableByteChannel channel = Files.newByteChannel(path1, StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);

//		DirectoryStream<Path>  newDirectoryStream(Path path) : �� path ָ����Ŀ¼
		Path path2 = Paths.get("e:\\teach");
		DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path2);
		Iterator<Path> iterator = directoryStream.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}


	}
}
