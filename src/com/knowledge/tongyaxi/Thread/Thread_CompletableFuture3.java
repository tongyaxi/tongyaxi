package com.knowledge.tongyaxi.Thread;

import java.util.concurrent.CompletableFuture;
/**
 * Thread_CompletableFuture
 * @author tongyaxi
 *
 */
public class Thread_CompletableFuture3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// ����CompletableFutureִ���첽��ѯ:
        CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(() -> {
            return queryCode("�й�ʯ��", "https://finance.sina.com.cn/code/");
        });
        CompletableFuture<String> cfQueryFrom163 = CompletableFuture.supplyAsync(() -> {
            return queryCode("�й�ʯ��", "https://money.163.com/code/");
        });

        // ��anyOf�ϲ�Ϊһ���µ�CompletableFuture:
        CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(cfQueryFromSina, cfQueryFrom163);

        // ����CompletableFutureִ���첽��ѯ:
        CompletableFuture<Double> cfFetchFromSina = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice((String) code, "https://finance.sina.com.cn/price/");
        });
        CompletableFuture<Double> cfFetchFrom163 = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice((String) code, "https://money.163.com/price/");
        });

        // ��anyOf�ϲ�Ϊһ���µ�CompletableFuture:
        CompletableFuture<Object> cfFetch = CompletableFuture.anyOf(cfFetchFromSina, cfFetchFrom163);

        // ���ս��:
        cfFetch.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // ���̲߳�Ҫ���̽���������CompletableFutureĬ��ʹ�õ��̳߳ػ����̹ر�:
        Thread.sleep(200);
	}
	
	static String queryCode(String name, String url) {
        System.out.println("query code from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code, String url) {
        System.out.println("query price from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }

}
