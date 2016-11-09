package com.xmg.touna.utils;

import java.security.MessageDigest;


/**
 * 
 *==========================================================
 *
 * 版权：
 *
 * 作者：liujun  1552752505@qq.com
 *
 * 版本：1.0
 *
 * 创建日期： 2016年3月1日  上午11:49:27
 *
 * 描述：MD5加密算法
 *
 * 全局接口公共部分：
 *
 * 修订历史：
 *
 *==========================================================
 *
 */
public class MD5Util {

	/***
	 * MD5加码 生成32位md5码
	 */
	private static String string2MD5(String inStr){
		MessageDigest md5 = null;
		try{
			md5 = MessageDigest.getInstance("MD5");
		}catch (Exception e){
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++){
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();

	}

	/**
	 * 加密解密算法 执行一次加密，两次解密
	 */ 
	private static String convertMD5(String inStr){

		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++){
			a[i] = (char) (a[i] ^ 't');
		}
		String s = new String(a);
		return s;

	}

	/**
	 * md5 加密
	 * @param string
	 * @return  加密后的值
	 */
	public static String encryption(String string){
		String string2md5 = string2MD5(string);
		return string2md5;
	}
	
	
	/**
	 * 比较密码是否相同
	 * @param string     用户提交的密码（没有加密）
	 * @param stringMd5      数据库读取出来的MD5加密的密码
	 * @return
	 */
	public static boolean comparisonPassword(String string,String stringMd5){
		String clientPassword = string2MD5(string);
		if(stringMd5.equals(clientPassword)){
			return true;
		}
		return false;
	}
	
	
	// 测试主函数
//	 public static void main(String[] args) {
//		String s = new String("123123");
//		String encryption = encryption("123123");
//		System.out.println("加密后的密码："+encryption);//4297f44b13955235245b2497399d7a93
//		System.out.println("密码是否相等："+comparisonPassword("123123","4297f44b13955235245b2497399d7a93"));
//		
//	}
}
