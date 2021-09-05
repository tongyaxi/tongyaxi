package com.knowledge.tongyaxi.Log4J;

import org.apache.log4j.Logger;
import org.junit.Test;

public class test01 {
	
	private static Logger logger = Logger.getLogger(test01.class);
	
	@Test
	public void test1() {
		
		// 记录debug级别的信息  
        logger.debug("This is debug message.");  
        // 记录info级别的信息  
        logger.info("This is info message.");  
        // 记录error级别的信息  
        logger.error("This is error message.");
	}

}
