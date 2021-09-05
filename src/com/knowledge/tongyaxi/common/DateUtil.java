package com.knowledge.tongyaxi.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
	/**
	 * システム日付取得処理(yyyyMMdd)
	 *
	 * @return
	 */
	public static String getSysDate() {

		String rtn = "";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		rtn = sdf.format(cal.getTime());

		return rtn;
	}

	/**
	 * システム日付取得処理(yyyy年MM月dd日)
	 *
	 * @return
	 */
	public static String getSysDate年月日() {

		String rtn = "";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		rtn = sdf.format(cal.getTime());

		return rtn;
	}

	/**
	 * 翌日取得処理(yyyyMMdd)
	 *
	 * @return
	 */
	public static String getNextSysDate() {

		String rtn = "";
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		rtn = sdf.format(cal.getTime());

		return rtn;
	}

	/**
	 * システム日付取得処理(yyyyMMddHHmmss)
	 *
	 * @return
	 */
	public static String getSysTime() {

		String rtn = "";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		rtn = sdf.format(cal.getTime());

		return rtn;
	}

	/**
	 * システム日付取得処理(yyyyMMddHHmmssSSS)
	 *
	 * @return
	 */
	public static String getMiniSysTime() {

		String rtn = "";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		rtn = sdf.format(cal.getTime());

		return rtn;
	}

	/**
	 * システム日付取得処理(yyyy-MM-dd HH:mm:ss)
	 *
	 * @return
	 */
	public static String getLogDateTime() {

		String rtn = "";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		rtn = sdf.format(cal.getTime());

		return rtn;
	}

	/**
	 * システム日付取得処理(年)
	 *
	 * @return 年（yyyy）
	 */
	public static String getYear() {

		String rtn = "";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		rtn = sdf.format(cal.getTime());

		return rtn;
	}

	/**
	 * システム日付取得処理(月)
	 *
	 * @return 月（MM）
	 */
	public static String getMonth() {

		String rtn = "";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		rtn = sdf.format(cal.getTime());

		return rtn;
	}

	/**
	 * システム日付取得処理(日)
	 *
	 * @return 日（dd）
	 */
	public static String getDay() {

		String rtn = "";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		rtn = sdf.format(cal.getTime());

		return rtn;
	}

	public static void main(String[] args) {

//		System.out.println(getSysDate年月日());

//		System.out.println(Integer.valueOf("-FF"));
	}

}
