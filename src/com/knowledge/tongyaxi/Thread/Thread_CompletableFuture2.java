package com.knowledge.tongyaxi.Thread;

import java.util.concurrent.CompletableFuture;
/**
 * Thread_CompletableFuture
 * @author tongyaxi
 *
 */
public class Thread_CompletableFuture2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// ��һ������:
        CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(() -> {
            return queryCode("�й�ʯ��");
        });
        // cfQuery�ɹ������ִ����һ������:
        CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice(code);
        });
        // cfFetch�ɹ����ӡ���:
        cfFetch.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // ���̲߳�Ҫ���̽���������CompletableFutureĬ��ʹ�õ��̳߳ػ����̹ر�:
        Thread.sleep(2000);
	}
	
	static String queryCode(String name) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }

}
