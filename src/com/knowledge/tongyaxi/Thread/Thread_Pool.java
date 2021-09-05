package com.knowledge.tongyaxi.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Thread_Pool
 * @author tongyaxi
 *
 */
public class Thread_Pool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����һ���̶���С���̳߳�:
        ExecutorService es = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 6; i++) {
            es.submit(new Task("" + i));
        }
        // �ر��̳߳�:
        es.shutdown();
	}

}

class Task implements Runnable {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("start task " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("end task " + name);
    }
}
