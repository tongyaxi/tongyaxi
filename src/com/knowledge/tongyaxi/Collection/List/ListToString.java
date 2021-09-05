package com.knowledge.tongyaxi.Collection.List;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * ×Ö·û´®×ªlist
 * list×ªString
 * @author tongyaxi
 *
 */
public class ListToString {
	
	@Test
	public void test() {
	    //×Ö·û´®×ªlist<String>
	    String str = "asdfghjkl";
	    List<String> lis = Arrays.asList(str.split(""));
	    
	    for (String string : lis) {
	        System.out.println(string);
	    }
	    //list<String>×ª×Ö·û´®
	    System.out.println(String.join("", lis));
	}

}
