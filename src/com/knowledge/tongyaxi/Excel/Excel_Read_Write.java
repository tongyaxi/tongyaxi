package com.knowledge.tongyaxi.Excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.knowledge.tongyaxi.common.CommonUtil;
import com.knowledge.tongyaxi.common.DateUtil;

public class Excel_Read_Write {

	public static void main(String[] args) {

		int status = 0;

		//エクセルファイルを置いているフォルダー
		final String INPUT_DIR = "C:/tongyaxi/excelRead/";
		final String fileName = "TONG_Excel_Test.xlsx";
		String inputFilePath = INPUT_DIR + fileName;

		//データを保存するリスト
		List<Person> listExcel = new ArrayList<Person>();

		status = getDataFromWorkBook(listExcel,inputFilePath);


		//ローカル環境ファイル出力場所
		String fileDir = "C:/tongyaxi/excelWrite/";

		//ファイル名を取得する
		String excelName = "TONG_Excel_Out";

		//出力先を設定
		String outPutfilePath = fileDir + excelName + "_" + DateUtil.getSysDate()
				+ "_01.xlsx";


		status = writeToExcel(listExcel,inputFilePath,outPutfilePath);

		if (status > 0) {
			System.out.println("異常");
		} else {
			System.out.println("正常");
		}
	}


	/**
	 * ワークブックからデータ抽出
	 * @param list
	 * @param filePath
	 * @return
	 */
	public static int getDataFromWorkBook(List<Person> listExcel, String filePath) {

		int status = 0;

		InputStream in = null;

		//workbookを閉じるために必要？
		OPCPackage pkg = null;

		//xlsx読み込みメソッド
		XSSFWorkbook wb = null;

		try {
			in = new FileInputStream(filePath);

			pkg = OPCPackage.open(in);

			wb = new XSSFWorkbook(pkg);

			//ワークブックの再計算を許可
			wb.setForceFormulaRecalculation(true);
		}catch (EncryptedDocumentException | IOException
				| InvalidFormatException e) {
			try {
				pkg.close();
			} catch (IOException e1) {
				e1.printStackTrace();
				// log出力
				System.out.println("データ読込失敗");
			}
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("データ読込失敗");
			}
		}

		//xlsxのシートを取得
		XSSFSheet sheet = wb.getSheetAt(0);
		//行の最大値を取得
		int maxRow = sheet.getLastRowNum();

		Row row = sheet.getRow(0);
		if (row == null) {
			System.out.println("データ無ため処理異常終了");
			status++;
		}

		//ワークブックを１行ずつ処理していく
		for (int i = 1; i < maxRow; i++) {
			Person person = new Person();

			//ワークブックから値を抽出
			//ID
			person.leaderId = CommonUtil.getCellValue(sheet, i, 0);
			//名前
			person.name = CommonUtil.getCellValue(sheet, i, 1);
			//年齢
			person.age = CommonUtil.getCellValue(sheet, i, 2);

			listExcel.add(person);
		}
		return status;

	}

	/**
	 * 取得したデータをExcelに出力する
	 */
	@SuppressWarnings("unused")
	private static int writeToExcel(List<Person> results, String inputFilePath, String outPutFilePath) {

		FileInputStream in = null;
		FileOutputStream out = null;
		XSSFWorkbook wbInput = null;
		XSSFWorkbook wbOutput = null;

		try {

			in = new FileInputStream(inputFilePath);
			wbInput = new XSSFWorkbook(in);
			out = new FileOutputStream(outPutFilePath);

			wbOutput = wbInput;

			//シートを作る
			XSSFSheet inSheet = wbInput.getSheetAt(0);
			XSSFSheet outSheet = wbOutput.getSheetAt(0);

			Set<String> set = new HashSet<String>();
			int num = 0;

			for (Person dto : results) {
				num++;
				Row dataRow = outSheet.createRow(0+num);

				dataRow.createCell(0).setCellValue(dto.leaderId);
				dataRow.createCell(1).setCellValue(dto.name);
				dataRow.createCell(2).setCellValue(dto.age);
			}

			wbOutput.write(out);
			in.close();
			out.close();
			wbOutput.close();
		}catch (Exception e) {
			e.getStackTrace();
			// 異常終了
			return 1;
		}
		return 0;
	}

}
