package com.knowledge.tongyaxi.Log4J;

import org.apache.log4j.Logger;
import org.junit.Test;

public class test01 {
	
	private static Logger logger = Logger.getLogger(test01.class);
	
	@Test
	public void test1() {
		
		// ��¼debug�������Ϣ  
        logger.debug("This is debug message.");  
        // ��¼info�������Ϣ  
        logger.info("This is info message.");  
        // ��¼error�������Ϣ  
        logger.error("This is error message.");
	}

}
