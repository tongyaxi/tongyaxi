package com.knowledge.tongyaxi.Thread.thread;

/**
 * ���ӳ�����륹��åɡ�
 * ThreadRun6Counter.showAndCountUp()���R�귵���g�Ф��롣
 */
public class ThreadRun extends Thread{

	public void run() {
		
		for(int i = 0; i < 10; i++) {
			// ������Ȥ���㤷�ơ��Y�������
			int count = ThreadRunCounter.showAndCountUp();
			System.out.println("Thread: " + i + "��Ŀ�Όg�С� �����󥿩`�ϡ�  " + count + "�Ǥ���");
			
			// ����`��һ������
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
