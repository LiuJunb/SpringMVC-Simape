package com.xmg.touna.utils;

public class NumHelper {

	/**
	 * 创建Customer Num 客户编号（2000001 区号+索引）
	 * 
	 * @param areaCode
	 * @param numIndex
	 * @return
	 */
	public static String createCustomerNum(String areaCode, String numIndex) {
		if (areaCode != null && numIndex != null) {
			numIndex=formatNum(numIndex, 4);
			return areaCode + numIndex;
		}
		return null;
	}

	/**
	 * 创建Supplier Num 编号（S2000001:S+区号+索引）
	 * 
	 * @param areaCode
	 * @param numIndex
	 * @return
	 */
	public static String createSupplierNum(String areaCode, String numIndex) {
		if (areaCode != null && numIndex != null)
			return "S" + areaCode + numIndex;
		return null;
	}

	/**
	 * 创建Employee Num 编号（E2000001：E+区号+索引）
	 * 
	 * @param areaCode
	 * @param numIndex
	 * @return
	 */
	public static String createEmployeeNum(String areaCode, String numIndex) {
		if (areaCode != null && numIndex != null) {
			numIndex = formatNum(numIndex, 4);
			return "E" + areaCode + numIndex;
		}
		return null;
	}

	/**
	 * 创建Goods Num 编号(0001:索引)
	 * 
	 * @param numIndex
	 * @return
	 */
	public static String createGoodsNum(String numIndex) {
		if (numIndex != null)
			return numIndex;
		return null;
	}

	/**
	 * 创建Orders Num 订单号（生成）
	 * 
	 * @param areaCode
	 * @return
	 */
	public static Long createOrdersNum(String areaCode) {
		IdHelper idHelper = new IdHelper();
		return Long.valueOf(idHelper.createOrderNo(areaCode));
	}

	/**
	 * 创建Summary Num S+索引+仓库编号
	 * 
	 * @param numIndex
	 * @param whcode
	 * @return
	 */
	public static String createSummaryNum(String numIndex, String whcode) {
		if (numIndex != null && whcode != null) {
			numIndex = formatNum(numIndex, 4);
			return "S" + numIndex + whcode;
		}
		return null;
	}

	/**
	 * 创建Refund Num 编号(T+订单号)
	 * 
	 * @param orderNum
	 * @return
	 */
	public static String createRefundNum(String orderNum) {
		IdHelper idHelper = new IdHelper();
		return "T" + orderNum;
	}

	/**
	 * 创建Warehouse Num 编号（W20005：W+区号+索引）
	 * 
	 * @param areaCode
	 * @param numIndex
	 * @return
	 */
	public static String createWarehouseNum(String areaCode, String numIndex) {
		if (areaCode != null && numIndex != null) {
			numIndex = formatNum(numIndex, 2);
			return "W" + areaCode + numIndex;
		}
		return null;
	}

	/**
	 * 创建Warehouse Num 货架编号（0001）（或手动输入）
	 * 
	 * @param numIndex
	 * @return
	 */
	public static String createWarehouseRackNum(String numIndex) {
		if (numIndex != null) {
			numIndex = formatNum(numIndex, 4);
			return numIndex;
		}
		return null;
	}

	/**
	 * 创建InWH Num IW200051（I+仓库编号+索引）
	 * 
	 * @param whCode
	 * @param numIndex
	 * @return
	 */
	public static String createInWHNum(String whCode, String numIndex) {
		if (whCode != null && numIndex != null)
			return "I" + whCode + numIndex;
		return null;
	}

	/**
	 * 创建OutWH Num OW200051（O+仓库编号+索引）
	 * 
	 * @param whCode
	 * @param numIndex
	 * @return
	 */
	public static String createOutWHNum(String whCode, String numIndex) {
		if (whCode != null && numIndex != null)
			return "O" + whCode + numIndex;
		return null;
	}

	/**
	 * OW200051（O+仓库编号+索引）
	 * 
	 * @param whcode
	 * @param numIndex
	 * @return
	 */
	public static String createPurchaseNum(String code, String numIndex) {
		if (code != null && numIndex != null)
			return "P" + code + numIndex;
		return null;
	}


	/**
	 * 获取num时拼接的参数
	 * 
	 * @param ds
	 * @param table
	 * @param field
	 * @return
	 */
	public static String getNumParamsString(String ds, String table, String field) {
		return "?ds=" + ds + "&table=" + table + "&field=" + field;
	}

	/**
	 * 格式化numIndex
	 * 
	 * @param numIndex
	 * @return 长度为nums的numIndex
	 */
	private static String formatNum(String numIndex, int nums) {
		String str = "00000000" + numIndex;
		int length = str.length();
		String substring = str.substring(length - nums, length);
		return substring;
	}
}
