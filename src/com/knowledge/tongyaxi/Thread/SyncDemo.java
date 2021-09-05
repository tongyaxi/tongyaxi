package com.knowledge.tongyaxi.Thread;




public class SyncDemo {
	public static void main(String[] args) {
		final Table table = new Table();
		Thread t1 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}

			}
		};
		Thread t2 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}

			}
		};
		t1.start();
		t2.start();
	}
}
class Table{
	private int beans = 20;
	public synchronized int getBean(){
		if(beans==0){
			throw new RuntimeException("¶¹×ÓÃ»ÁË");
		}
		Thread.yield();
		return beans--;
	}
}
