package com.knowledge.tongyaxi.IO.NIO2;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2019 上午 11:58
 */
public class FileUtilsTest {

    public static void main(String[] args) {
        File srcFile = new File("day10\\爱情与友情.jpg");
        File destFile = new File("day10\\爱情与友情2.jpg");

        try {
            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
private static Logger logger = Logger.getLogger(FileUtilsTest.class);
	
	@Test
	public void test1() throws Exception{
		
		List<String> lines = FileUtils.readLines(new File("/Users/tongyaxi/eclipse-workspace/FileUtils_Test/FileUtils.txt"),"utf-8");
		logger.info(lines);
		
		List<String> writeLines = new ArrayList<String>();
        for(String line : lines) {
			logger.info(line);
			if(line.startsWith("凉介")) {
				continue;
			}
			String[] strArr = line.split("/t");
			for(String str : strArr) {
				writeLines.add(str);
			}
			
		}
        logger.info(writeLines);
        
        FileUtils.writeLines(new File("Users/tongyaxi/eclipse-workspace/FileUtils_Test/FileUtils2.txt"), writeLines);
	}
}
