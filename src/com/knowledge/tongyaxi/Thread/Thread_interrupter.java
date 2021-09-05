package com.knowledge.tongyaxi.Thread;

public class Thread_interrupter {

	public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThreadT1();
        t.start();
        Thread.sleep(1); // ��ͣ1����
        t.interrupt(); // �ж�t�߳�
        t.join(); // �ȴ�t�߳̽���
        System.out.println("end");
    }

}

class MyThreadT1 extends Thread {
    public void run() {
        int n = 0;
        while (! isInterrupted()) {
            n ++;
            System.out.println(n + " hello!");
        }
    }
}
