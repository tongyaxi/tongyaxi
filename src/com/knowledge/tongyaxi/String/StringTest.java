package com.knowledge.tongyaxi.String;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 字符串判断
 * @author tongyaxi
 *
 */
public class StringTest {

	private static Logger logger = Logger.getLogger(StringTest.class);
	
	@Test
	public void test01() {
		if(isLetterDigitOrChinese("123中文ASCabc")) {
			logger.info("字符串包含中文。");
		}
	}
	@Test
	public void test02() {
		if(isNumeric3("12378788")) {
			logger.info("字符串仅包含数字。");
		}
	}
	@Test
	public void test03() {
		if(check("12378788")) {
			logger.info("字符串首字符是字母。");
		}
	}
	@Test
	public void test04() {
		if(vd("汉字11Abc")) {
			logger.info("字符串是为汉字。");
		}
	}
	
	/**
	 * Java判断字符串是否为包含中文或数字或英文
	 * @param str
	 * @return
	 */
	public static boolean isLetterDigitOrChinese(String str) {
	  
		String regex = "^[a-z0-9A-Z\u4e00-\u9fa5]+$";
	  
		return str.matches(regex);
	 }
	
	/**
	 * 判断字符串是否仅为数字
	 * 1.用java自带函数（只能校验不含负号的）
	 * @param str
	 * @return
	 */
	public static boolean isNumeric1(String str){
		
		for(int i = str.length(); --i >= 0;) {
			if(!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断字符串是否仅为数字
	 * 2.用正则表达式
	 * （可以校验含有负号的数字
	 * "^-?[0-9]+"
	 * "-?[0-9]+.?[0-9]+"可检验所有数字）
	 * @param str
	 * @return
	 */
	public static boolean isNumeric2(String str){
		
	    Pattern pattern = Pattern.compile("^-?[0-9]+");
	    
	    return pattern.matcher(str).matches();   
	 }
	
	/**
	 * 判断字符串是否仅为数字
	 * 3.用ascii码 
	 */
	public static boolean isNumeric3(String str){
		for(int i=str.length();--i>=0;) {
			
			int chr=str.charAt(i); 
			
	           if(chr<48 || chr>57) 
	                return false;
		}
	    return true;
	}
	
	/**
	 * 判断一个字符串的首字符是否为字母
	 * @param s
	 * @return
	 */
	public static boolean test(String s){
		
		char c = s.charAt(0);   
		int i =(int)c;   
		if((i >= 65 && i <= 90) || (i >= 97 && i <= 122)){   
			return true;
		}else{   
			return false;
		}   
	}
	public static boolean check(String fstrData){
		
		char c = fstrData.charAt(0);   
	    if(((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))){   
	        return true;   
	    }else{
	    	return false;   
	    }   
	}
	
	/**
	 * 判断是否为汉字
	 * @param str
	 * @return
	 */
	public boolean vd(String str){
		  
	    char[] chars = str.toCharArray(); 
	    boolean isGB2312 = false; 
	    
	    for(int i = 0; i < chars.length; i++){
	    	byte[] bytes = ("" + chars[i]).getBytes(); 
	        if(bytes.length == 2){
	        	
	        	int[] ints = new int[2]; 
	            ints[0] = bytes[0]& 0xff; 
	            ints[1] = bytes[1]& 0xff;
	            
	            if(ints[0] >= 0x81 && ints[0] <= 0xFE && ints[1] >= 0x40 && ints[1] <= 0xFE){
	            	isGB2312=true; 
	                break; 
	            } 
	         } 
	    } 
	    return isGB2312; 
	}
}
