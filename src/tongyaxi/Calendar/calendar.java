package tongyaxi.Calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class calendar {

	public static void main(String[] args) {
		System.out.println(Calendar.getInstance());
		System.out.println(getSysTime());
	}

	public static String getSysTime() {

		String rtn = "";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		rtn = sdf.format(cal.getTime());

		return rtn;
	}

}
