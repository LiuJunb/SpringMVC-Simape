package com.xmg.touna.utils;

import java.io.UnsupportedEncodingException;

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
 * 创建日期： 2016年3月31日  下午5:28:36
 *
 * 描述：
 *                 		String msg = "中国abc";  
 *                 
                		System.out.println(msg);  
                		int len = msg.getBytes().length;//按操作系统默认编码来编码  
                        System.out.println("def "+len);  
                        len = msg.getBytes("GB2312").length;//输出7  
                        System.out.println("GB2312: "+len);  
                        len = msg.getBytes("GBK").length;//输出7  
                        System.out.println("GBK: "+len);  
                        len = msg.getBytes("GB18030").length;//输出7, 2*2+3,一个汉字占2字节,一个英文字母一个字节  
                        System.out.println("GB18030: "+len);  
                        len = msg.getBytes("UTF-8").length;//输出9, 2*3+3=9,一个汉字占3字节,一个英文字母一个字节.  
                        System.out.println("UTF-8: "+len);  
                        len = msg.getBytes("UTF-16").length;//输出12  
                        System.out.println("UTF-16: "+len);  
                        len = msg.getBytes("UTF-32").length;//输出20  
                        System.out.println("UTF-32: "+len);  
                        len = msg.getBytes("Unicode").length;//输出12  
                        System.out.println("Unicode: "+len);
 *
 * 全局接口公共部分：
 *
 * 修订历史：
 *
 *==========================================================
 *
 */
public class StringHelper {

	public static String UTF_8="UTF-8";
	public static String GBK="GBK";
	
	/**
	 * 获取字符窜的字节数长度
	 * @param string
	 * @return
	 */
	public static int getStringLength(String string,String charSet){
		int length;
		try {
			length = string.getBytes(charSet).length;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			length=0;
		}
		return length;
	}
	
	/**
	 * 获取字符窜的字节数长度
	 * @param string
	 * @return
	 */
	public static int getUTF_8StringLength(String string){
		int length;
		try {
			length = string.getBytes(UTF_8).length;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			length=0;
		}
		return length;
	}
}
