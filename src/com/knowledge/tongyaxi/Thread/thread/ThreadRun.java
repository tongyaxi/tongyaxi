package com.knowledge.tongyaxi.Thread.thread;

/**
 * 柵び竃されるスレッド。
 * ThreadRun6Counter.showAndCountUp()を�Rり卦し�g佩する。
 */
public class ThreadRun extends Thread{

	public void run() {
		
		for(int i = 0; i < 10; i++) {
			// カウントを紗麻して、�Y惚を竃薦
			int count = ThreadRunCounter.showAndCountUp();
			System.out.println("Thread: " + i + "指朕の�g佩。 カウンタ�`は、  " + count + "です。");
			
			// スリ�`プ匯昼を棋つ
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
