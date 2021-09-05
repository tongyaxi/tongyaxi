package com.knowledge.tongyaxi.CSV;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.knowledge.tongyaxi.common.DateUtil;

public class CSV_Write {



	public static void main(String[] args) {

		System.out.println("CSV作成処理開始");

		int status = 0;
		
		List<Integer> results = new ArrayList<Integer>();
		results = getData();

		// ローカル環境ファイル出力場所
		String fileDir = "C:/tongyaxi/csvWrite/";

		// ファイル名を取得する
		String fileName = "csvTest";

        // 出力先を設定
		String filePath = fileDir + "TONG_"+ fileName +"_" + DateUtil.getSysTime() + ".csv";

		status = writeCsvinfoData(results,filePath);

		if(status == 1){
			// log出力
			System.out.println("ファイル書き込み処理失敗");
		}else{
			System.out.println("ファイル書き込み処理成功");
		}
	}

	/**
	 * データ抽出処理
	 */
	public static List<Integer> getData(){
		List<Integer> dataList = new ArrayList<Integer>();

		Random random = new Random(1);

		for(int i = 0;i<155;i++){
			int ran = random.nextInt(100);
			dataList.add(ran);
		}
		return dataList;
	}

	/**
	 * データ出力処理
	 * @param results
	 * @param filePath
	 * @param headerTime
	 * @return
	 */
	@SuppressWarnings("unused")
	private static int writeCsvinfoData(List<Integer> results, String filePath) {


        try {

        	// 1.ファイルオープン
            File outputFile = new File(filePath);
			FileOutputStream fos = new FileOutputStream(outputFile,true);
			OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
			PrintWriter pw = new PrintWriter(osw);

			List<String> csvData = new ArrayList<String>();

			// 2.ヘッダー書き込み処理
			StringBuilder headSpace = new StringBuilder("");
            StringBuilder headComma = new StringBuilder(",");
            StringBuilder head = new StringBuilder("");

            for (String data : CSV_Write.Test_CSV) {
            	head = head.append(headSpace).append(data);
            	headSpace = headComma;
                }
            csvData.add(head.toString());


            //最新データ編集
            StringBuilder comma = new StringBuilder(",");

            for (Integer id : results) {
            	StringBuilder result = new StringBuilder("");
            	result = result.append("").append(id);
            	csvData.add(result.toString());
            }

            for (String data : csvData) {
            	pw.println(data);
            }

            //3.終了処理
            pw.close();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			//異常終了
        	return 1;
		}
        //正常終了
		return 0;
	}

	public final static String[] Test_CSV = {
		"担当者ID"
	};

}