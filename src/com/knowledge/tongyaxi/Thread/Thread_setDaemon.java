package com.knowledge.tongyaxi.Thread;


public class Thread_setDaemon {

	public static void main(String[] args) {
		Thread rose = new Thread(){
			public void run(){
				for(int i=0;i<5;i++){
					System.out.println("rose:let me go");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
				System.out.println("°¡°¡°¡°¡°¡°¡°¡");
				System.out.println("¹ÒÁË");
			}
		};
		Thread jack = new Thread(){
			public void run(){

				while(true){
					System.out.println("jack:U jump,I jump");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
			}
		};
		rose.start();
		jack.setDaemon(true);
		jack.start();

	}

}
