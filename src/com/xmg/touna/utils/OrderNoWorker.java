package com.xmg.touna.utils;

public class OrderNoWorker {
	private long lastTimestamp = 0L;
	private long offset = 0L;
	private long maxNumPerTimestamp = 100000L;
	public OrderNoWorker() {
		// TODO Auto-generated constructor stub
	}
	public void setMaxNumPerTimestamp(long maxNumPerTimestamp){
		this.maxNumPerTimestamp = maxNumPerTimestamp;
	} 
	public synchronized long nextOrderNo(){
		long orderNo = 0L;
		long timestamp = getTimestamp();		 
        if (timestamp < lastTimestamp) {            
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }
        else if(timestamp == lastTimestamp){
        	offset++;
        	if(offset >= (maxNumPerTimestamp - 1)){
        		offset = 0;
        		timestamp = tilNextTimestamp(lastTimestamp);
        		orderNo = timestamp * maxNumPerTimestamp;
        	}
        	else{
        		orderNo = timestamp * maxNumPerTimestamp + offset; 
        	}
        }
        else {
			orderNo = timestamp * maxNumPerTimestamp;
			offset = 0L;
		}
        lastTimestamp = timestamp;
		return orderNo;
	}
	
	private long tilNextTimestamp(long lastTimestamp) {
        long timestamp = getTimestamp();
        while (timestamp <= lastTimestamp) {
            timestamp = getTimestamp();
        }
        return timestamp;
    }
 
	
	private long getTimestamp(){
		return (System.currentTimeMillis()/1000 - 1000000000);
	}
}
