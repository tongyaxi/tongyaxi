package com.knowledge.tongyaxi.Collection.map;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Properties properties = new Properties();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("jdbc.properties");
			
			properties.load(fis);
			System.out.println(properties.get("name"));
			System.out.println(properties.get("password"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				
				if(fis!=null) {
					fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
