package com.knowledge.tongyaxi.Thread;


public class Thread_join {
	public static boolean isFinish = false;
	public static void main(String[] args) {

		final Thread download = new Thread(){
			public void run(){
				System.out.println("down:"+"��ʼ����ͼƬ");
				for(int i=1;i<101;i++){
					System.out.println("�����أ�"+i+"%");
					try {
						Thread.sleep(50);


					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
				System.out.println("down:"+"�������");
				isFinish = true;
			}
		};
		Thread show = new Thread(){
			public void run(){
				System.out.println("show"+"׼����ʾͼƬ");
				try {
					download.join();

				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				if(!isFinish){
					System.out.println("show"+"ͼƬ��ʾʧ��");
				}
				System.out.println("show"+"ͼƬ��ʾ���");
			}
		};

		download.start();
		show.start();

	}

}
