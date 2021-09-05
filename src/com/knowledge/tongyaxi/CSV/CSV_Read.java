package com.knowledge.tongyaxi.CSV;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSV_Read {

	public static void main(String[] args) {

		final String INPUT_DIR = "C:/tongyaxi/csvRead/TONG_csvTest.csv";

		int status = 0;
		Reader reader;

		try {
			reader = Files.newBufferedReader(Paths.get(INPUT_DIR), Charset.forName("UTF-8"));
			@SuppressWarnings("resource")
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
			List<CSVRecord> recordList = csvParser.getRecords();

			List<String> dataList = new ArrayList<String>();
			for(int i = 0 ; i < recordList.size() ; i ++){
				String leaderId = recordList.get(i).get(0);
				dataList.add(leaderId);
			}

			for(String leaderId : dataList){
				System.out.println(leaderId);
			}

		}catch(IOException e){
			status++;
			e.printStackTrace();
		}
		if(status > 0){
			return ;
		}else{
			return ;
		}
	}
}
