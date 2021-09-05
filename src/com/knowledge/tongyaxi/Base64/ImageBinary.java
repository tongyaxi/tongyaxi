package com.knowledge.tongyaxi.Base64;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream; 
import java.io.ByteArrayOutputStream; 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.imageio.ImageIO;


//import sun.misc.BASE64Decoder; 
//import sun.misc.BASE64Encoder; 
   
public class ImageBinary { 
//    static BASE64Encoder encoder = new sun.misc.BASE64Encoder(); 
//    static BASE64Decoder decoder = new sun.misc.BASE64Decoder(); 
    
    static Base64.Encoder encoder = Base64.getEncoder();
    static Base64.Decoder decoder = Base64.getDecoder();
   /**
     * 将图片转换成base64
     * 
     * @return
     */
    public static String getImageBinary(String imagePath) {
    	
    	File file = new File(imagePath); 
    	System.out.println(file.exists());
    	
    	BufferedImage bi = null; 
        try { 
        	bi = ImageIO.read(file);
        	
            ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
            ImageIO.write(bi, "jpg", baos);   
            byte[] bytes = baos.toByteArray(); 
   
//          return encoder.encodeBuffer(bytes).trim(); 
            return encoder.encodeToString(bytes);
        	
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
        
        return null; 
    } 
    
    /**
     * 将图片转换成base64
     * 
     * @return
     */
    public static byte[] getImageBinary2(String imagePath) {
    	
    	imagePath = "./resource/images/coordinatestylecslide0.jpg";
    	byte[] data = null;
    	InputStream in = null;
    	
    	try { 
    		in = new FileInputStream(imagePath);
        	data = new byte[in.available()];
        	
        	in.read(data);
        	in.close();
        	
    	}catch (IOException e) { 
            e.printStackTrace(); 
        } 
//    	BASE64Encoder encoder = new sun.misc.BASE64Encoder(); 
        return encoder.encode(data); 
    	
    }
   
    /**
     * 将base64转换为图片
     * 
     * @param base64String
     */
    static void base64StringToImage(String base64String) { 
        try { 
            byte[] bytes1 = decoder.decode(base64String); 
   
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1); 
            BufferedImage bi1 = ImageIO.read(bais); 
            File w2 = new File("F:\\Java\\2007941381272_L.jpg"); 
            ImageIO.write(bi1, "jpg", w2); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
    } 
    
    @SuppressWarnings("unused")
	public static void main(String[] args) { 
    	String imagePath = "./src/com.fujitsu/business/service/images/coordinatestylecslide0.jpg";
    	String  ss = getImageBinary(imagePath); 
        System.out.println(ss);
        
        //获取当前项目路径
    	File directory = new File("");
    	String courseFile = null;
        try {
        	     courseFile = directory.getCanonicalPath();
        	     //System.out.println(courseFile);
        } catch (IOException e) {
        	     e.printStackTrace();
        }
    	
        //base64StringToImage(getImageBinary());
    } 
   
}

