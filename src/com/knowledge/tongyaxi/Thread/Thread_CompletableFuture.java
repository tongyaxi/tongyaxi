package com.knowledge.tongyaxi.Thread;

import java.util.concurrent.CompletableFuture;
/**
 * Thread_CompletableFuture
 * @author tongyaxi
 *
 */
public class Thread_CompletableFuture {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// �����첽ִ������:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(Thread_CompletableFuture::fetchPrice);
        // ���ִ�гɹ�:
        cf.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // ���ִ���쳣:
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        // ���̲߳�Ҫ���̽���������CompletableFutureĬ��ʹ�õ��̳߳ػ����̹ر�:
        Thread.sleep(200);
	}
	
	static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }

}
