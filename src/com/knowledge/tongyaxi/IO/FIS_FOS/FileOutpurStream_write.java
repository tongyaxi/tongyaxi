package com.knowledge.tongyaxi.IO.FIS_FOS;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutpurStream_write {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("地表最强5.txt");//也可以String path
		/*
		 * 也可以后接,boolean append,true表示追加模式
		 */
		fos.write("伸出手，搭便车，唱着歌，弹着斑鸠...".getBytes());
		fos.write("细腻描述你的长发".getBytes());

		fos.close();
		System.out.println("写出完毕");

	}
}
