package com.knowledge.tongyaxi.Thread;


public class SyncDemo4 {
	public static void main(String[] args) {

		Thread t1 = new Thread(){
			public void run(){
				Boo.go();//可以直接用类名调
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				Boo.go();
			}
		};
		t1.start();
		t2.start();
	}

}
class Boo{
	public synchronized static void go(){//静态方法如果使用synchronized，该方法一定具有同步效果，跟对象无关。
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+"执行go方法");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

		}
		System.out.println(t.getName()+"go方法执行完毕");
	}
}
