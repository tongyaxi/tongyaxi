package com.knowledge.tongyaxi.Thread;


public class SyncDemo4 {
	public static void main(String[] args) {

		Thread t1 = new Thread(){
			public void run(){
				Boo.go();//����ֱ����������
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
	public synchronized static void go(){//��̬�������ʹ��synchronized���÷���һ������ͬ��Ч�����������޹ء�
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+"ִ��go����");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

		}
		System.out.println(t.getName()+"go����ִ�����");
	}
}
