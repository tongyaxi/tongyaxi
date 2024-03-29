package com.knowledge.tongyaxi.Thread;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLock
 * @author tongyaxi
 *
 */
public class Thread_Sync9 {
	
	private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private final Lock rlock = rwlock.readLock();
    private final Lock wlock = rwlock.writeLock();
    private int[] counts = new int[10];

    public void inc(int index) {
        wlock.lock(); // ��д��
        try {
            counts[index] += 1;
        } finally {
            wlock.unlock(); // �ͷ�д��
        }
    }

    public int[] get() {
        rlock.lock(); // �Ӷ���
        try {
            return Arrays.copyOf(counts, counts.length);
        } finally {
            rlock.unlock(); // �ͷŶ���
        }
    }
	
}
