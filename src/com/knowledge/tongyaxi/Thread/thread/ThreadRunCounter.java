package com.knowledge.tongyaxi.Thread.thread;

/**
 * カウンターの値を保持するクラス
 * showAndCountUpメソッドで、カウンターを追加して、
 * 追加したカウンターの値を返却する。
 */
public class ThreadRunCounter {

	public static int counter = 0;
	
	synchronized public static int showAndCountUp() {
		counter = counter + 1;
		return counter;
	}
}
