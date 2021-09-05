package com.knowledge.tongyaxi.Thread;

public class Thread_join2 {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(() -> {
            System.out.println("hello");
        });
        System.out.println("start");
        t.start();
        t.join();
        System.out.println("end");

	}

}
