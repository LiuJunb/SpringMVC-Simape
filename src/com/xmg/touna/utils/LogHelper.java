package com.xmg.touna.utils;
import org.springframework.beans.factory.annotation.Autowired;



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
 * 创建日期： 2016年3月2日  上午11:56:02
 *
 * 描述：自定义日志打印 :OFF  ERROR  WARN INFO  DEBUG
 *
 * 全局接口公共部分：
 *
 * 修订历史：
 *
 *==========================================================
 *
 */
public class LogHelper {

	private static final int LEVEL_ERROR=1;
	private static final int LEVEL_WARN=2;
	private static final int LEVEL_INFO=3;
	private static final int LEVEL_DEBUG=4;
	private static  boolean IsDubug=true;
	//修改这个可以控制打印的输出：比如：CURRENT_LEVEL=4  可以输出 ERROR  WARN INFO  DEBUG ，CURRENT_LEVEL=0 关闭日志打印
	private static  int CURRENT_LEVEL=4;  
	
	
	
	public LogHelper() {
		super();
	}
	public static void ON(){
		CURRENT_LEVEL=4;
	}
	public static void OFF(){
		CURRENT_LEVEL=0;
	}

	public static boolean isIsDubug() {
		return IsDubug;
	}
	public static void setIsDubug(boolean isDubug) {
		IsDubug = isDubug;
	}
	
	
	public static void errer(Object object){
		if(CURRENT_LEVEL>=LEVEL_ERROR&&IsDubug){
			System.out.println("=================================ERROR:");
		}
	}
	
	public static void warn(Object object){
		if(CURRENT_LEVEL>=LEVEL_WARN&&IsDubug){
			System.out.println("=================================WARN:");
		}
	}
	public static void info(Object object){
		if(CURRENT_LEVEL>=LEVEL_INFO&&IsDubug){
			System.out.println("=================================INFO:");
		}
	}
	public static void debug(Object object){
		if(CURRENT_LEVEL>=LEVEL_DEBUG&&IsDubug){
			System.out.println("=================================DEBUG:");
		}
	}
}
