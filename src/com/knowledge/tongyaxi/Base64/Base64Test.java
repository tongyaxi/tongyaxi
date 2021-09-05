package com.knowledge.tongyaxi.Base64;

/**
 * toBase64
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Base64Test {

	public static void main(String[] args) throws UnsupportedEncodingException {
		Base64.Encoder encoder = Base64.getEncoder();
		List<String> csvData = new ArrayList<String>();

		csvData.add("\""+"MID"+"\""+","+"\""+"SID"+"\""+","+"\""+"›QœgÊÖ¶ÎID"+"\""+","+"\""+"›Qœg™CévID"+"\"");
		csvData.add("\""+"28241"+"\""+","+"\""+"021"+"\""+","+"\""+"101"+"\""+","+"\""+"10035"+"\"");

		StringBuilder stringBuilder = new StringBuilder();
		for (String data : csvData) {
			stringBuilder.append(data).append("\r\n");
        }

		byte[] textByte = stringBuilder.toString().getBytes("UTF-8");
		String encodedText = encoder.encodeToString(textByte);


		try {
			File outputFile = new File("C:\\Users\\ytong\\Desktop\\base64_test.csv");
			FileOutputStream fos = new FileOutputStream(outputFile,true);
			OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
	        PrintWriter pw = new PrintWriter(osw);

	        pw.println(encodedText);

	        pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


	}
}
