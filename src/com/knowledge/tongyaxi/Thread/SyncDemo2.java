package com.knowledge.tongyaxi.Thread;


public class SyncDemo2 {
	public static void main(String[] args) {
		final Shop shop = new Shop();
		Thread t1 = new Thread(){
			public void run(){
				shop.buy();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				shop.buy();
			}
		};
		t1.start();
		t2.start();
	}

}
class Shop{
	public void buy(){
		Thread t = Thread.currentThread();

		try {
			System.out.println(t.getName()+":正在挑衣服");
			Thread.sleep(5000);
			synchronized (this) {
				System.out.println(t.getName()+":正在试衣服");
				Thread.sleep(5000);
			}

			System.out.println(t.getName()+":结账走人");

		} catch (InterruptedException e) {

		}
	}
}
