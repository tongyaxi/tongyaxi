package com.knowledge.tongyaxi.File;

import java.io.File;
import java.util.ArrayList;

public class TestDemo2 {

	public static void main(String[] args) {
		getAllFileName("/share/sfdc/batch/work/B041/",new ArrayList<String>());

	}

	@SuppressWarnings("unused")
	public static void getAllFileName(String path,ArrayList<String> fileNameList) {
        //ArrayList<String> files = new ArrayList<String>();
        boolean flag = false;
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
              System.out.println("文     件：" + tempList[i].getName());
                //fileNameList.add(tempList[i].toString());
                fileNameList.add(tempList[i].getName());
            }
//            if (tempList[i].isDirectory()) {
//              System.out.println("文件夹：" + tempList[i]);
//                //getAllFileName(tempList[i].getAbsolutePath(),fileNameList);
//            }
        }
        return;
    }

}
