package com.knowledge.tongyaxi.Thread.thread;

/**
 * メインメソッドを隔つクラス
 * Thread6Runクラスからスレッドを軟��
 * 徭附もメインメソッド坪で、ThreadRun6Counter.shouAndCountUpを�Rり卦し�g佩する
 * @author tongyaxi
 *
 */
public class ThreadCall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//　ThreadRunをインスタンス晒
		ThreadRun thread = new ThreadRun();
		
		// ThreadRunのインスタンスをstart()、スレッド�_兵
		thread.start();
		
		for(int i=0; i<10; i++){

            //ThreadRun6Counterのカウントを紗麻して、�Y惚を竃薦。
            int cnt = ThreadRunCounter.showAndCountUp();
            System.out.println("Main:   " + i + "指朕の�g佩。 カウンタ�`は、  " + cnt + "です。");

            try{
                // スリ�`プ1昼棋つ
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
	}

}
