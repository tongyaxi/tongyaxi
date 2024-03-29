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
		
		{put("a", "エイ");put("b", "ビ�`");put("c", "シ�`");put("d", "ディ�`");put("e", "イ�`");put("f", "エフ");put("g", "ジ�`");put("h", "エイチ");
		put("i", "アイ");put("j", "ジェ�`");put("k", "ケ�`");put("l", "エル");put("m", "エム");put("n", "エヌ");put("o", "オ�`");put("p", "ピ�`");
		put("q", "キュ�`");put("r", "ア�`ル");put("s", "エス");put("t", "ティ�`");put("u", "ユ�`");put("v", "ブイ");put("w", "ダブリュ�`");put("x", "エックス");
		put("y", "ワイ");put("z", "ゼット");put("A", "エイ");put("B", "ビ�`");put("C", "シ�`");put("D", "ディ�`");put("E", "イ�`");put("F", "エフ");
		put("G", "ジ�`");put("H", "エイチ");put("I", "アイ");put("J", "ジェ�`");put("K", "ケ�`");put("L", "エル");put("M", "エム");put("N", "エヌ");
		put("O", "オ�`");put("P", "ピ�`");put("Q", "キュ�`");put("R", "ア�`ル");put("S", "エス");put("T", "ティ�`");put("U", "ユ�`");put("V", "ブイ");
		put("W", "ダブリュ�`");put("X", "エックス");put("Y", "ワイ");put("Z", "ゼット");
		}
	};

	/**
	 * 峺協された String が null または腎猟忖双かどうかを卦します。
	 *
	 * @param value
	 *            チェックする String
	 * @return null または腎猟忖双かどうか。null または腎猟忖双なら true 、それ參翌なら false 。
	 */
	public static boolean isEmpty(String value) {

		if (value == null || value.length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 峺協されたフォ�`マットで晩原を猟忖双に���Q。
	 *
	 * @param date
	 *            ���Qされる晩原
	 * @return 峺協されたフォ�`マットで���Qしたの晩原。
	 */
	public static String strDate(Date date) {
		String str = new SimpleDateFormat("yyyyMMdd").format(date);
		return str;
	}

	/**
	 * 峺協蓐方で枠�^0托め���Q,。
	 *
	 * @param string
	 *            ���Qされる猟忖双
	 * @param digits
	 *            峺協蓐方
	 * @return ���Qしたの猟忖双。
	 */
	public static String digitsFormat(String str, int digits) {
		String paddingStr = String.format("%" + digits + "s", str).replace(" ",
				"0");
		return paddingStr;
	}

	// セルに�O協されている�､鯲鍔崛个燃薐�
	/**
	 * セルに�O協されている�､鯲鍔崛个燃薐�
	 *
	 * @param sheet
	 *            デ�`タを渇竃されるシ�`ト
	 * @param rowIndex
	 *            佩インデクスを峺協
	 * @param columnIndex
	 *            双インデクスを峺協
	 * @return 函誼デ�`タ。
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

		// 駅ずString侏で卦す
		// �O協��
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
		 // たぶん聞わない
		 setupval = String.valueOf(cell.getBooleanCellValue());
		 break;
		case FORMULA:
			// たぶん聞わない
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
	 * オブジェクト畠てのタイプを函誼する
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
	 * リストを猟忖双に�筝�する。
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
	 * 猟忖双をリスとに�筝�する、","原け。
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
	 * YYYYMMDDフォ�`マットの晩原をYYYY/MM/DDフォ�`マットの晩原に�筝�する。
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
	 * YYYY/MM/DDフォ�`マットの晩原をYYYYMMDDフォ�`マットの晩原に�筝�する。
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
	 * BigDecimal 侏のデ�`タを%原ける猟忖双に�筝�する。
	 * @param decimal
	 * @return
	 */
	public static String changeDecimalToPercentString(BigDecimal decimal){

		Double data = decimal.doubleValue() * 100;

		String string = data.toString()+"%";

		return string;

	}

	/**
	 * 方忖とアルファベットを根める猟忖双を畠何畠叔カタカナに���Qするメソッド
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
	 * 峺協蓐方で枠�^0托め���Q(２蓐��,。
	 *
	 * @param string
	 *            ���Qされる猟忖双
	 * @return ���Qしたの猟忖双。
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
