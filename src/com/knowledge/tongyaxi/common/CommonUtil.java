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

		{put("1", "����");
		put("2", "��");
		put("3", "����");
		put("4", "��");
		put("5", "��");
		put("6", "��");
		put("7", "����");
		put("8", "�ϥ�");
		put("9", "���奦");
		put("0", "����");}};
		
	private static HashMap<String, String> alphabetMap = new HashMap<String, String>(){
		private static final long serialVersionUID = 1L;
		
		{put("a", "����");put("b", "�ө`");put("c", "���`");put("d", "�ǥ��`");put("e", "���`");put("f", "����");put("g", "���`");put("h", "������");
		put("i", "����");put("j", "�����`");put("k", "���`");put("l", "����");put("m", "����");put("n", "����");put("o", "���`");put("p", "�ԩ`");
		put("q", "����`");put("r", "���`��");put("s", "����");put("t", "�ƥ��`");put("u", "��`");put("v", "�֥�");put("w", "���֥��`");put("x", "���å���");
		put("y", "�磻");put("z", "���å�");put("A", "����");put("B", "�ө`");put("C", "���`");put("D", "�ǥ��`");put("E", "���`");put("F", "����");
		put("G", "���`");put("H", "������");put("I", "����");put("J", "�����`");put("K", "���`");put("L", "����");put("M", "����");put("N", "����");
		put("O", "���`");put("P", "�ԩ`");put("Q", "����`");put("R", "���`��");put("S", "����");put("T", "�ƥ��`");put("U", "��`");put("V", "�֥�");
		put("W", "���֥��`");put("X", "���å���");put("Y", "�磻");put("Z", "���å�");
		}
	};

	/**
	 * ָ�����줿 String �� null �ޤ��Ͽ������Ф��ɤ����򷵤��ޤ���
	 *
	 * @param value
	 *            �����å����� String
	 * @return null �ޤ��Ͽ������Ф��ɤ�����null �ޤ��Ͽ������Фʤ� true ����������ʤ� false ��
	 */
	public static boolean isEmpty(String value) {

		if (value == null || value.length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ָ�����줿�ե��`�ޥåȤ��ո��������Фˉ�Q��
	 *
	 * @param date
	 *            ��Q������ո�
	 * @return ָ�����줿�ե��`�ޥåȤǉ�Q�������ո���
	 */
	public static String strDate(Date date) {
		String str = new SimpleDateFormat("yyyyMMdd").format(date);
		return str;
	}

	/**
	 * ָ�����������^0����Q,��
	 *
	 * @param string
	 *            ��Q�����������
	 * @param digits
	 *            ָ������
	 * @return ��Q�����������С�
	 */
	public static String digitsFormat(String str, int digits) {
		String paddingStr = String.format("%" + digits + "s", str).replace(" ",
				"0");
		return paddingStr;
	}

	// ������O������Ƥ��낎�������Фǳ��
	/**
	 * ������O������Ƥ��낎�������Фǳ��
	 *
	 * @param sheet
	 *            �ǩ`����������륷�`��
	 * @param rowIndex
	 *            �Х���ǥ�����ָ��
	 * @param columnIndex
	 *            �Х���ǥ�����ָ��
	 * @return ȡ�åǩ`����
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

		// �ؤ�String�ͤǷ���
		// �O����
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
		 // ���֤�ʹ��ʤ�
		 setupval = String.valueOf(cell.getBooleanCellValue());
		 break;
		case FORMULA:
			// ���֤�ʹ��ʤ�
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
	 * ���֥�������ȫ�ƤΥ����פ�ȡ�ä���
	 *
	 * @param obj
	 * @return��List<String>
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
	 * �ꥹ�Ȥ������Фˉ�����롣
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
	 * �����Ф�ꥹ�Ȥˉ�����롢","������
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
	 * YYYYMMDD�ե��`�ޥåȤ��ո���YYYY/MM/DD�ե��`�ޥåȤ��ո��ˉ�����롣
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
	 * YYYY/MM/DD�ե��`�ޥåȤ��ո���YYYYMMDD�ե��`�ޥåȤ��ո��ˉ�����롣
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
	 * BigDecimal �ͤΥǩ`����%�����������Фˉ�����롣
	 * @param decimal
	 * @return
	 */
	public static String changeDecimalToPercentString(BigDecimal decimal){

		Double data = decimal.doubleValue() * 100;

		String string = data.toString()+"%";

		return string;

	}

	/**
	 * ���֤ȥ���ե��٥åȤ򺬤�������Ф�ȫ��ȫ�ǥ������ʤˉ�Q����᥽�å�
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
	 * ָ�����������^0����Q(���죩,��
	 *
	 * @param string
	 *            ��Q�����������
	 * @return ��Q�����������С�
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
