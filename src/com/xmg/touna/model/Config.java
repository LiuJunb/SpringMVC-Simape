package com.xmg.touna.model;

public class Config {

	private Long id;
	private Integer port;
	private Integer time;
	
	private String data;
	private String ip;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Config() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "config [id=" + id + ", port=" + port + ", time=" + time + ", data=" + data + ", ip=" + ip + "]";
	}
	
	
}
