package com.knowledge.tongyaxi.String;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * �ַ����ж�
 * @author tongyaxi
 *
 */
public class StringTest {

	private static Logger logger = Logger.getLogger(StringTest.class);
	
	@Test
	public void test01() {
		if(isLetterDigitOrChinese("123����ASCabc")) {
			logger.info("�ַ����������ġ�");
		}
	}
	@Test
	public void test02() {
		if(isNumeric3("12378788")) {
			logger.info("�ַ������������֡�");
		}
	}
	@Test
	public void test03() {
		if(check("12378788")) {
			logger.info("�ַ������ַ�����ĸ��");
		}
	}
	@Test
	public void test04() {
		if(vd("����11Abc")) {
			logger.info("�ַ�����Ϊ���֡�");
		}
	}
	
	/**
	 * Java�ж��ַ����Ƿ�Ϊ�������Ļ����ֻ�Ӣ��
	 * @param str
	 * @return
	 */
	public static boolean isLetterDigitOrChinese(String str) {
	  
		String regex = "^[a-z0-9A-Z\u4e00-\u9fa5]+$";
	  
		return str.matches(regex);
	 }
	
	/**
	 * �ж��ַ����Ƿ��Ϊ����
	 * 1.��java�Դ�������ֻ��У�鲻�����ŵģ�
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
	 * �ж��ַ����Ƿ��Ϊ����
	 * 2.��������ʽ
	 * ������У�麬�и��ŵ�����
	 * "^-?[0-9]+"
	 * "-?[0-9]+.?[0-9]+"�ɼ����������֣�
	 * @param str
	 * @return
	 */
	public static boolean isNumeric2(String str){
		
	    Pattern pattern = Pattern.compile("^-?[0-9]+");
	    
	    return pattern.matcher(str).matches();   
	 }
	
	/**
	 * �ж��ַ����Ƿ��Ϊ����
	 * 3.��ascii�� 
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
	 * �ж�һ���ַ��������ַ��Ƿ�Ϊ��ĸ
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
	 * �ж��Ƿ�Ϊ����
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
