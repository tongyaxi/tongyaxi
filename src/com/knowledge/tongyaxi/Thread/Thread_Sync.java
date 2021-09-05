package com.knowledge.tongyaxi.Thread;

public class Thread_Sync {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Thread add = new AddThread();
        Thread dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);
    }

}

class Counter {
	public static final Object lock = new Object();
    public static int count = 0;
}

class AddThread extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) { 
        	synchronized(Counter.lock){
        		Counter.count += 1; 
        	}
        }
    }
}

class DecThread extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
        	synchronized(Counter.lock){
        	     Counter.count -= 1; 
        	}
        }
    }
}
