package com.xmg.touna.utils;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

/**
 * 关于事务的操作封装
 * @author Administrator
 *
 */
public class AppTransaction{
	TransactionStatus status;
	PlatformTransactionManager tranMgr;
	public TransactionStatus getStatus() {
		return status;
	}
	public void setStatus(TransactionStatus status) {
		this.status = status;
	}
	public PlatformTransactionManager getTranMgr() {
		return tranMgr;
	}
	public void setTranMgr(PlatformTransactionManager tranMgr) {
		this.tranMgr = tranMgr;
	}
	/**
	 * 提交事务
	 */
	public void commit(){
		this.tranMgr.commit(this.status);
	}
	/**
	 * 回滚事务
	 */
	public void rollback(){
		this.tranMgr.rollback(this.status);
	}
	/**
	 * 创建存储点
	 * @return
	 */
	public Object createSavepoint(){
		return this.status.createSavepoint();
	}
	/**
	 * 回滚到存储点
	 * @param savePoint
	 */
	public void rollbackSavepoint(Object savePoint){
		this.status.rollbackToSavepoint(savePoint);
	}
	/**
	 * 判断事务是否完成
	 * @return
	 */
	public boolean isCompleted(){
		//logger.info("状态全名:" + this.status.getClass().getName());
		return this.status.isCompleted();
	}
}
