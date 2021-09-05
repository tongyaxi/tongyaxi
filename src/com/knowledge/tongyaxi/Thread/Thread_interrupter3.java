package com.knowledge.tongyaxi.Thread;

public class Thread_interrupter3 {

	public static void main(String[] args) throws InterruptedException{
		HelloThreadT1 t = new HelloThreadT1();
        t.start();
        Thread.sleep(1);
        t.running = false; // 标志位置为false

	}

}

class HelloThreadT1 extends Thread {
    public volatile boolean running = true;
    public void run() {
        int n = 0;
        while (running) {
            n ++;
            System.out.println(n + " hello!");
        }
        System.out.println("end!");
    }
}
