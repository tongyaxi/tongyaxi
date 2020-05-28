package com.knowledge.tongyaxi.List.ListBatchLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListBatch {

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
		if(dataList != null && dataList.size() > 0){
			int intLimit = 50;
			int size = dataList.size();

			if(intLimit < size){
				int part = size/intLimit;
				System.out.println("共："+ size + "個。" + "分けて"+ part + "回");
				for(int i = 0;i<part;i++){
					List<Integer> pageList = dataList.subList(0,intLimit);
					System.out.println("第"+ (i+1) + "回:" + "処理データ：" +pageList);
					dataList.subList(0,intLimit).clear();
				}
				if(!dataList.isEmpty()){
					System.out.println("最後のデータ：" + dataList);
				}
			}else{
				System.out.println("組み分けしない");
			}
		}else{
			System.out.println("データ無し");
		}
	}

}
