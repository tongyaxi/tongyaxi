package com.knowledge.tongyaxi.Thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock.condition
 * @author tongyaxi
 *
 */
public class Thread_Sync8 {
	
	private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Queue<String> queue = new LinkedList<>();

    public void addTask(String s) {
        lock.lock();
        try {
            queue.add(s);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String getTask() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
            return queue.remove();
        } finally {
            lock.unlock();
        }
    }
	
}
