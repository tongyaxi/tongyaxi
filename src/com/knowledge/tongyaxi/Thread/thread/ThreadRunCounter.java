package com.knowledge.tongyaxi.Thread.thread;

/**
 * 市它件正奈及��毛悵厥允月弁仿旦
 * showAndCountUp丟末永玉匹﹜市它件正奈毛袚樓仄化﹜
 * 袚樓仄凶市它件正奈及��毛殿�握馱諢�
 */
public class ThreadRunCounter {

	public static int counter = 0;
	
	synchronized public static int showAndCountUp() {
		counter = counter + 1;
		return counter;
	}
}
