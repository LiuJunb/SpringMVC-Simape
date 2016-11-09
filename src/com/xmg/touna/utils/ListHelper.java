package com.xmg.touna.utils;

import java.util.ArrayList;
import java.util.List;

public class ListHelper {

	/**
	 * 数组转list集合
	 * 
	 * @param ts 数组
	 * @return list集合
	 */
	public static <T> List<T> getLists(T [] ts){
		List<T> list=new ArrayList<T>();
		for (T t : ts) {
			list.add(t);
		}
		return list;
	}
	
	/**
	 * List<String> --> String=1,2,3,4,5
	 * @param listString
	 * @return
	 */
	public static String getList2String(List<String> listString){
		StringBuilder stringBuilder=new StringBuilder();
		boolean isFirstTime=true;
		for (String string : listString) {
			if(!isFirstTime)
				stringBuilder.append(",");
			stringBuilder.append(string);
			isFirstTime=false;
		}
		return stringBuilder.toString();
	}
	
	
	/**
	 * List<Long> --> String=1,2,3,4
	 * @param listString
	 * @return
	 */
	public static String getList2StringLong(List<Long> listLong){
		StringBuilder stringBuilder=new StringBuilder();
		boolean isFirstTime=true;
		for (Long l : listLong) {
			if(!isFirstTime)
				stringBuilder.append(",");
			stringBuilder.append(l);
			isFirstTime=false;
		}
		return stringBuilder.toString();
	}
	
	
}
