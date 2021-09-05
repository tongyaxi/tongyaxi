package com.knowledge.tongyaxi.MD5Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test {
	/**
     * ����32λmd5��
     * @param password
     * @return
     */
    public static String md5Password(String password) {

        try {
        	// �õ�һ����ϢժҪ��
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password.getBytes());
            StringBuffer buffer = new StringBuffer();
            // ��ÿһ��byte ��һ�������� 0xff;
            for (byte b : result) {
                // ������
                int number = b & 0xff;// ����
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }

            // ��׼��md5���ܺ�Ľ��
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }

    }
    
    public static void main(String[] args) {
//    	System.out.println(new Test().md5Password("tongyaxi"));
	}
}