package com.whereguesthome.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class md5jdkUtil {
    //将byte数组转化为16进制输出
	public static String converByteToHeString(byte[] bytes){
		String result="";
		for(int i=0;i<bytes.length;i++){
			int temp =bytes[i] & 0xff;
			String tempHex=Integer.toHexString(temp);
			if(tempHex.length()<2){
				result +="0" + tempHex;
			}else{
				result += tempHex;
			}
		}
		return result;
	}
	
	//使用jdk自带的md2操作
/*	public static String md2Jdk(String message){
		String temp="";		 
		try {
			MessageDigest md2Digest = MessageDigest.getInstance("MD2");
		byte[] encodeMd2Digest = md2Digest.digest(message.getBytes());
		temp=converByteToHeString(encodeMd2Digest );
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return temp;
	}*/
	//jdk自带的md5加密
	public static String getMd5(String message){
		
		String temp="";		 
		try {
			MessageDigest md5Digest = MessageDigest.getInstance("MD5");	
		byte[] encodeMd5Digest=md5Digest.digest(message.getBytes());
		temp=converByteToHeString(encodeMd5Digest);
		
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
   /* public static String getMd5(String plainText) {  
        try {  
            MessageDigest md = MessageDigest.getInstance("MD5");  
           
            md.update(plainText.getBytes());  
            byte b[] = md.digest();  

            int i;  

            StringBuffer buf = new StringBuffer("");  
            for (int offset = 0; offset < b.length; offset++) {  
                i = b[offset];  
                if (i < 0)  
                    i += 256;  
                if (i < 16)  
                    buf.append("0");  
                buf.append(Integer.toHexString(i));  
            }  
            //32位加密  
           return buf.toString();  
            // 16位的加密  
            //return buf.toString().substring(8, 24);  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
            return null;  
        }  

    }  */

/*	public static void main(String[] args) {
		
		//md2加密算法
		String md2Encode=md2Jdk("hello jdk md");
		System.out.println("MD2JDK加密后为："+md2Encode);
		System.out.println("MD2JDK加密后密文长度为："+md2Encode.length());
		//md5加密算法
		String md5Encode=md5Jdk("hello jdk md");
		System.out.println("MD2JDK加密后为："+md5Encode);
		System.out.println("MD2JDK加密后密文长度为："+md5Encode.length());
	}*/
	
}
