package com.knowledge.tongyaxi.Thread;
/**
 * ¿ÉÖØÈëËø
 * @author tongyaxi
 *
 */
public class Thread_Sync5 {
	
	@SuppressWarnings("unused")
	private int count = 0;

    public synchronized void add(int n) {
        if (n < 0) {
            dec(-n);
        } else {
            count += n;
        }
    }

    public synchronized void dec(int n) {
        count += n;
    }
}
