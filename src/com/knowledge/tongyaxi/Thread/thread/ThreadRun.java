package com.knowledge.tongyaxi.Thread.thread;

/**
 * 呼び出されるスレッド。
 * ThreadRun6Counter.showAndCountUp()を繰り返し実行する。
 */
public class ThreadRun extends Thread{

	public void run() {
		
		for(int i = 0; i < 10; i++) {
			// カウントを加算して、結果を出力
			int count = ThreadRunCounter.showAndCountUp();
			System.out.println("Thread: " + i + "回目の実行。 カウンターは、  " + count + "です。");
			
			// スリープ一秒を待つ
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
