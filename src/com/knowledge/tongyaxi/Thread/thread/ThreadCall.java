package com.knowledge.tongyaxi.Thread.thread;

/**
 * メインメソッドを持つクラス
 * Thread6Runクラスからスレッドを起動
 * 自身もメインメソッド内で、ThreadRun6Counter.shouAndCountUpを繰り返し実行する
 * @author tongyaxi
 *
 */
public class ThreadCall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//　ThreadRunをインスタンス化
		ThreadRun thread = new ThreadRun();
		
		// ThreadRunのインスタンスをstart()、スレッド開始
		thread.start();
		
		for(int i=0; i<10; i++){

            //ThreadRun6Counterのカウントを加算して、結果を出力。
            int cnt = ThreadRunCounter.showAndCountUp();
            System.out.println("Main:   " + i + "回目の実行。 カウンターは、  " + cnt + "です。");

            try{
                // スリープ1秒待つ
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
	}

}
