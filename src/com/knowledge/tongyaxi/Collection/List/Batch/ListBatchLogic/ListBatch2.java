package com.knowledge.tongyaxi.Collection.List.Batch.ListBatchLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListBatch2 {

	public static void main(String[] args) {
		Random random = new Random(1);

		List<Integer> intList = new ArrayList<>();
		for(int i = 0;i<155;i++){
			int ran = random.nextInt(100);
			intList.add(ran);
		}
		listExcute(intList);
	}

	private static void listExcute(List<Integer> dataList){
		int number = dataList.size()/50 + 1;
		int size = dataList.size();

		for(int n = 0; n<number; n++ ){
			List<Integer> list = new ArrayList<>();

			if(n!=number-1){
				list = dataList.subList(n*50, (n+1)*50);
			}else {
				list = dataList.subList(n*50, size-1);
				list.add(dataList.get(size-1));
			}

			System.out.println(list);
		}
	}

}
