package com.knowledge.tongyaxi.common;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class CommonUtil {

	private static HashMap<String, String> numMap = new HashMap<String, String>(){
		private static final long serialVersionUID = 1L;

		{put("1", "イチ");
		put("2", "ニ");
		put("3", "サン");
		put("4", "シ");
		put("5", "ゴ");
		put("6", "ロク");
		put("7", "シチ");
		put("8", "ハチ");
		put("9", "キュウ");
		put("0", "ゼロ");}};
		
	private static HashMap<String, String> alphabetMap = new HashMap<String, String>(){
		private static final long serialVersionUID = 1L;
		
		{put("a", "エイ");put("b", "ビー");put("c", "シー");put("d", "ディー");put("e", "イー");put("f", "エフ");put("g", "ジー");put("h", "エイチ");
		put("i", "アイ");put("j", "ジェー");put("k", "ケー");put("l", "エル");put("m", "エム");put("n", "エヌ");put("o", "オー");put("p", "ピー");
		put("q", "キュー");put("r", "アール");put("s", "エス");put("t", "ティー");put("u", "ユー");put("v", "ブイ");put("w", "ダブリュー");put("x", "エックス");
		put("y", "ワイ");put("z", "ゼット");put("A", "エイ");put("B", "ビー");put("C", "シー");put("D", "ディー");put("E", "イー");put("F", "エフ");
		put("G", "ジー");put("H", "エイチ");put("I", "アイ");put("J", "ジェー");put("K", "ケー");put("L", "エル");put("M", "エム");put("N", "エヌ");
		put("O", "オー");put("P", "ピー");put("Q", "キュー");put("R", "アール");put("S", "エス");put("T", "ティー");put("U", "ユー");put("V", "ブイ");
		put("W", "ダブリュー");put("X", "エックス");put("Y", "ワイ");put("Z", "ゼット");
		}
	};

	/**
	 * 指定された String が null または空文字列かどうかを返します。
	 *
	 * @param value
	 *            チェックする String
	 * @return null または空文字列かどうか。null または空文字列なら true 、それ以外なら false 。
	 */
	public static boolean isEmpty(String value) {

		if (value == null || value.length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 指定されたフォーマットで日付を文字列に変換。
	 *
	 * @param date
	 *            変換される日付
	 * @return 指定されたフォーマットで変換したの日付。
	 */
	public static String strDate(Date date) {
		String str = new SimpleDateFormat("yyyyMMdd").format(date);
		return str;
	}

	/**
	 * 指定桁数で先頭0埋め変換,。
	 *
	 * @param string
	 *            変換される文字列
	 * @param digits
	 *            指定桁数
	 * @return 変換したの文字列。
	 */
	public static String digitsFormat(String str, int digits) {
		String paddingStr = String.format("%" + digits + "s", str).replace(" ",
				"0");
		return paddingStr;
	}

	// セルに設定されている値を文字列で抽出
	/**
	 * セルに設定されている値を文字列で抽出
	 *
	 * @param sheet
	 *            データを抽出されるシート
	 * @param rowIndex
	 *            行インデクスを指定
	 * @param columnIndex
	 *            列インデクスを指定
	 * @return 取得データ。
	 */
	public static String getCellValue(XSSFSheet sheet, int rowIndex,
			int columnIndex) {
		Row row = sheet.getRow(rowIndex);
		if (row == null) {
			return null;
		}
		Cell cell = row.getCell(columnIndex);
		if (cell == null) {
			return null;
		}

		// 必ずString型で返す
		// 設定値
		String setupval = "";

		switch (cell.getCellType()) {
		case STRING:
			setupval = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				setupval = CommonUtil.strDate(cell.getDateCellValue());
			} else if(cell.getNumericCellValue() < 1){
				setupval = String.valueOf(cell.getNumericCellValue());
				}else{
					setupval = String.valueOf((int)cell.getNumericCellValue());

			}
			break;
		 case BOOLEAN:
		 // たぶん使わない
		 setupval = String.valueOf(cell.getBooleanCellValue());
		 break;
		case FORMULA:
			// たぶん使わない
			setupval = cell.getCellFormula();
			break;
		case ERROR:
			setupval = "Error";
			break;
		case BLANK:
			setupval = "";
			break;
		default:
			break;
		}
		return setupval;
	}

	/**
	 * オブジェクト全てのタイプを取得する
	 *
	 * @param obj
	 * @return　List<String>
	 */
	public static List<String> getFieldType(Object obj) {
		Field[] fields = obj.getClass().getDeclaredFields();
		List<String> list = new ArrayList<String>();

		for (int i = 0; i < fields.length; i++) {
			list.add(fields[i].getType().toString());
		}
		return list;
	}

	/**
	 * リストを文字列に変更する。
	 *
	 * @param list
	 * @return
	 */
	public static String convertListToString(List<String> list) {

		StringBuilder stringBuilder = new StringBuilder("");

		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				stringBuilder.append(list.get(i));
			} else if (list.get(i) != null && list.get(i) != "") {
				stringBuilder.append(list.get(i)).append(",");
			}
		}

		return stringBuilder.toString();

	}

	/**
	 * 文字列をリスとに変更する、","付け。
	 *
	 * @param string
	 * @return
	 */
	public static List<String> converStringToList(String string) {

		List<String> list = new ArrayList<String>();

		for (int i = 0; i < 6; i++) {
			list.add("");
		}
		String[] strings = string.split(",");
		for (int i = 0; i < strings.length; i++) {
			list.set(i, strings[i]);
		}

		return list;

	}

	/**
	 * YYYYMMDDフォーマットの日付をYYYY/MM/DDフォーマットの日付に変更する。
	 * @param data
	 * @return
	 */
	public static String changeStringDateFormat(String data) {

		StringBuilder stringBuilder = new StringBuilder("");

		if(!isEmpty(data)){
			stringBuilder = stringBuilder.append(data.substring(0, 4)).append("/")
					.append(data.subSequence(4, 6)).append("/")
					.append(data.subSequence(6, 8));
		}

		return stringBuilder.toString();

	}

	/**
	 * YYYY/MM/DDフォーマットの日付をYYYYMMDDフォーマットの日付に変更する。
	 * @param data
	 * @return
	 */
	public static String changeDateToYYYYMMDD(String data) {

		StringBuilder stringBuilder = new StringBuilder("");

		if(!isEmpty(data)){
			stringBuilder = stringBuilder.append(data.substring(0, 4))
					.append(data.subSequence(5, 7))
					.append(data.substring(8));
		}

		return stringBuilder.toString();

	}

	/**
	 * BigDecimal 型のデータを%付ける文字列に変更する。
	 * @param decimal
	 * @return
	 */
	public static String changeDecimalToPercentString(BigDecimal decimal){

		Double data = decimal.doubleValue() * 100;

		String string = data.toString()+"%";

		return string;

	}

	/**
	 * 数字とアルファベットを含める文字列を全部全角カタカナに変換するメソッド
	 * @param string
	 * @return
	 */
	public static String convertToFullWidth(String string){
		string = Normalizer.normalize(string, Normalizer.Form.NFKC);
		StringBuffer stringBuffer = new StringBuffer();
		if(string.matches(".*\\d.*") || string.matches(".*[a-zA-Z].*")){

			for(int i = 0 ; i < string.length() ; i ++){
				char c = string.charAt(i);
				if((c>='0' && c <='9')){
					stringBuffer.append(numMap.get(String.valueOf(c)));
				}else if((c>='a' && c<='z') || (c>='A' && c<='Z')){
					stringBuffer.append(alphabetMap.get(String.valueOf(c)));
				}else{
					stringBuffer.append(String.valueOf(c));
				}
			}
			return stringBuffer.toString();
		}else{
			return string;
		}
	}


	/**
	 *
	 * @param string
	 * @return
	 */
	public static String alphabetConvert(String string){

		char[] charArr = string.toCharArray();
		char temp;
		int t =0;
		for(int i = 0 ; i < charArr.length ; i ++){

			if((charArr[i]>='a' && charArr[i] <='z')||(charArr[i]>='A' && charArr[i] <='Z')){

				for(int j = charArr.length -1 - t ; j > i ; j --){

					if((charArr[j]>='a' && charArr[j] <= 'z') || (charArr[j] >='A' && charArr[j] <= 'Z')){

						temp = charArr[i];
						charArr[i] = charArr[j];
						charArr[j] = temp;
						t++;

						break;
					}else{
						t++;
					}
				}
			}

		}
		return String.valueOf(charArr);
	}

	/**
	 * 指定桁数で先頭0埋め変換(２桁）,。
	 *
	 * @param string
	 *            変換される文字列
	 * @return 変換したの文字列。
	 */
	public static String changeFormat(int num) {
		String paddingStr = String.format("%2s", num).replace(" ","0");
		return paddingStr;
	}

	public static void main(String[] args) {

		String string = "ABCDEFGHIIJKLM";
		System.out.println(alphabetConvert(string));

	}

}
