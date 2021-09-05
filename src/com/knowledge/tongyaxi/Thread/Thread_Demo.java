package com.knowledge.tongyaxi.Thread;



public class Thread_Demo {
	public static void main(String[] args) {
		Thread thread = new Mythread();//实例化线程
	    thread.start();//启动线程
	    /**
	     * 注：启动线程时调用线程的start()方法而非直接调用run()方法。
	     * start()方法会将当前线程纳入线程调度，使当前线程可以开始并
	     * 发运行。当线程获取时间片段后会自动开始执行run方法中的逻辑。
	     */
	    System.out.println(Thread.currentThread().getName());//程序运行时默认的主线程
	}
}
class Mythread extends Thread{//通过继承Thread类来创建线程类
	public void run(){  //重写Run方法，run()的方法体就是线程执行体
		                  // 就是该线程所需完成的任务。
		for(int i=0;i<100;i++){
			System.out.println("红卫兵!社区送温暖");
		}
	}
}
