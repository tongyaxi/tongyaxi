package com.knowledge.tongyaxi.Collection.List;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * �ַ���תlist
 * listתString
 * @author tongyaxi
 *
 */
public class ListToString {
	
	@Test
	public void test() {
	    //�ַ���תlist<String>
	    String str = "asdfghjkl";
	    List<String> lis = Arrays.asList(str.split(""));
	    
	    for (String string : lis) {
	        System.out.println(string);
	    }
	    //list<String>ת�ַ���
	    System.out.println(String.join("", lis));
	}

}
