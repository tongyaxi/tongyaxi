package com.knowledge.tongyaxi.Thread;



public class Thread_Demo {
	public static void main(String[] args) {
		Thread thread = new Mythread();//ʵ�����߳�
	    thread.start();//�����߳�
	    /**
	     * ע�������߳�ʱ�����̵߳�start()��������ֱ�ӵ���run()������
	     * start()�����Ὣ��ǰ�߳������̵߳��ȣ�ʹ��ǰ�߳̿��Կ�ʼ��
	     * �����С����̻߳�ȡʱ��Ƭ�κ���Զ���ʼִ��run�����е��߼���
	     */
	    System.out.println(Thread.currentThread().getName());//��������ʱĬ�ϵ����߳�
	}
}
class Mythread extends Thread{//ͨ���̳�Thread���������߳���
	public void run(){  //��дRun������run()�ķ���������߳�ִ����
		                  // ���Ǹ��߳�������ɵ�����
		for(int i=0;i<100;i++){
			System.out.println("������!��������ů");
		}
	}
}
