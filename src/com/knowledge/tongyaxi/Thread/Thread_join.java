package com.knowledge.tongyaxi.Thread;


public class Thread_join {
	public static boolean isFinish = false;
	public static void main(String[] args) {

		final Thread download = new Thread(){
			public void run(){
				System.out.println("down:"+"开始下载图片");
				for(int i=1;i<101;i++){
					System.out.println("已下载："+i+"%");
					try {
						Thread.sleep(50);


					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
				System.out.println("down:"+"下载完毕");
				isFinish = true;
			}
		};
		Thread show = new Thread(){
			public void run(){
				System.out.println("show"+"准备显示图片");
				try {
					download.join();

				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				if(!isFinish){
					System.out.println("show"+"图片显示失败");
				}
				System.out.println("show"+"图片显示完毕");
			}
		};

		download.start();
		show.start();

	}

}
