package com.knowledge.tongyaxi.Thread;

public class Thread_Sync4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CounterT4 c1 = new CounterT4();
		CounterT4 c2 = new CounterT4();

		// 对c1进行操作的线程:
		new Thread(() -> {
		    c1.add(1);
		}).start();
		new Thread(() -> {
		    c1.dec(1);
		}).start();

		// 对c2进行操作的线程:
		new Thread(() -> {
		    c2.add(1);
		}).start();
		new Thread(() -> {
		    c2.dec(1);
		}).start();
	}

}


class CounterT4 {
    private int count = 0;

    public void add(int n) {
        synchronized(this) {
            count += n;
        }
    }

    public void dec(int n) {
        synchronized(this) {
            count -= n;
        }
    }

    public int get() {
        return count;
    }
}
