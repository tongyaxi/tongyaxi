package com.knowledge.tongyaxi.File;

import java.io.File;

public class TestDemo{
	public static void main(String[] args){
		//#源文件路径
		File startFile=new File("/share/sfdc/batch/work/B041/CPAY_ENTRY_20191107.xlsx");

		//#目的目录路径
		File endDirection=new File("/share/sfdc/batch/work/B041/bk");
		//#如果目的目录路径不存在，则进行创建
		if(!endDirection.exists()) {
		   endDirection.mkdirs();
		}

		//#目的文件路径=目的目录路径+源文件名称
		File endFile=new File(endDirection+ File.separator+ startFile.getName());

		try {
			//#调用File类的核心方法renameTo
			if (startFile.renameTo(endFile)) {
			   System.out.println("文件移动成功！目标路径：{"+endFile.getAbsolutePath()+"}");
			} else {
			   System.out.println("文件移动失败！起始路径：{"+startFile.getAbsolutePath()+"}");
			}
		}catch(Exception e) {
			System.out.println("文件移动出现异常！起始路径：{"+startFile.getAbsolutePath()+"}");
		}
	}
}
