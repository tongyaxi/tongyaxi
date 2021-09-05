package com.knowledge.tongyaxi.Thread;

public class Thread_setDaemon2 {

		public static void main(String[] args) {
			Thread t = new Thread1();
			// ���ע����һ�У��۲�Thread1��ִ�����:
			t.setDaemon(true);
			t.start();
			System.out.println("main: wait 3 sec...");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}
			System.out.println("main: end.");
		}

}

class Thread1 extends Thread {

	public void run() {
		for (;;) {
			System.out.println("Thread-1: running...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
}
