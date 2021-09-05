package com.knowledge.tongyaxi.Thread;

public class Thread_Sync3 {

	public static void main(String[] args) throws Exception {
        Thread[] ts = new Thread[] { new AddStudentThread(), new DecStudentThread(), new AddTeacherThread(), new DecTeacherThread() };
        for (Thread t : ts) {
            t.start();
        }
        for (Thread t : ts) {
            t.join();
        }
        System.out.println(CounterT2.studentCount);
        System.out.println(CounterT2.teacherCount);
    }

}

class CounterT2 {
    public static final Object lock = new Object();
    public static int studentCount = 0;
    public static int teacherCount = 0;
}

class AddStudentThread extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(CounterT2.lock) {
                CounterT2.studentCount += 1;
            }
        }
    }
}

class DecStudentThread extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(CounterT2.lock) {
                CounterT2.studentCount -= 1;
            }
        }
    }
}

class AddTeacherThread extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(CounterT2.lock) {
                CounterT2.teacherCount += 1;
            }
        }
    }
}

class DecTeacherThread extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(CounterT2.lock) {
                CounterT2.teacherCount -= 1;
            }
        }
    }
}
