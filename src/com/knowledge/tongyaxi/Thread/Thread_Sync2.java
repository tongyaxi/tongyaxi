package com.knowledge.tongyaxi.Thread;

public class Thread_Sync2 {

	public static void main(String[] args) throws Exception {
        Thread add = new AddThreadT1();
        Thread dec = new DecThreadT1();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);
    }

}

class CounterT1 {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();
    public static int count = 0;
}

class AddThreadT1 extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(CounterT1.lock1) {
                Counter.count += 1;
            }
        }
    }
}

class DecThreadT1 extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(CounterT1.lock2) {
                Counter.count -= 1;
            }
        }
    }
}
