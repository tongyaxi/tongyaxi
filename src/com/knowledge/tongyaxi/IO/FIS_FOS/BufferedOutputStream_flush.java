package com.knowledge.tongyaxi.IO.FIS_FOS;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStream_flush {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("地表最强6.txt");

		BufferedOutputStream bos = new BufferedOutputStream(fos);

		byte[] data = "我轻轻地尝一口你说的爱我。".getBytes();
		//所有字节被存入缓冲区，等待一次性写出
		bos.write(data);
		bos.flush();  //清空缓冲区，将缓冲区中的数据强制写出。
		System.out.println("写出完毕");
		bos.close();

	}
}
