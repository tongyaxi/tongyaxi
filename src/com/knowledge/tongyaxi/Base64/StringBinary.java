package com.knowledge.tongyaxi.Base64;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
/**
 * 1.toBase64
 * 2.fromBase64
 * @author tongyaxi
 *
 */
public class StringBinary {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		final Base64.Decoder decoder = Base64.getDecoder();
		final Base64.Encoder encoder = Base64.getEncoder();
		final String text = "日本語";
		final byte[] textByte = text.getBytes("UTF-8");
		//编码
		final String encodedText = encoder.encodeToString(textByte);
		System.out.println(encodedText);

		//解码
		System.out.println(new String(decoder.decode(encodedText), "UTF-8"));




		String[] string = {"72960","001","PVA","サービス概要中国語","54m154mb5pif","0","1600784"};
		List<String> list = new ArrayList<String>();

		for(int i = 0; i < string.length; i++){
			if (isBase64(string[i])) {
				String newStr = new String(decoder.decode(string[i]), "UTF-8");
				list.add(newStr);
			}else {
				list.add(string[i]);
			}

		}

		System.out.println(list.toString());


	}


	private static boolean isBase64(String str) {
	    if (str == null || str.trim().length() == 0) {
	        return false;
	    } else {

	        if (str.length() % 4 != 0) {
	            return false;
	        }

	        char[] strChars = str.toCharArray();
	        for (char c:strChars) {
	            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')
	                || c == '+' || c == '/' || c == '=') {
	                continue;
	            } else {
	                return false;
	            }
	        }
	        return true;
	    }
	}

}
