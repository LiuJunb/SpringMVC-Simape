package com.xmg.touna.utils;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;

public class IdHelper {
	@Autowired
	private IdWorker idWorker;
	@Autowired
	private OrderNoWorker orderNoWorker;

	// 生成单个Id
	public long createID() {
		return idWorker.nextId();
	}

	// 生成批量Id
	public List<Long> createBatchID(int idCount) {
		List<Long> idList = Collections.synchronizedList(new ArrayList<Long>());
		for (int i = 0; i < idCount; i++) {
			idList.add(createID());
		}
		return idList;
	}

	// 生成单个订单号
	public String createOrderNo(String areaCode) {
		return areaCode+String.valueOf(orderNoWorker.nextOrderNo())  ;
	}

	// 生成批量订单号
	public List<String> createBatchOrderNo(String areaCode,int idCount) {
		List<String> idList = Collections.synchronizedList(new ArrayList<String>());
		for (int i = 0; i < idCount; i++) {
			idList.add(createOrderNo(areaCode));
		}
		return idList;
	}
}
