package com.xmg.touna.model;

public class Product {

	private Integer amount;
	private Double apr;
	private Integer beginTime;
	private Integer buyerSum;
	private Integer expected_time;
	private Long id;
	private Integer minTender;
	private Integer sbAmt;
	private Integer status;
	private Integer subscribe;
	private String  url;
	
	private String desc;
	private String key;
	private String name;
	private String period;
	private String tags;
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Double getApr() {
		return apr;
	}
	public void setApr(Double apr) {
		this.apr = apr;
	}
	public Integer getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Integer beginTime) {
		this.beginTime = beginTime;
	}
	public Integer getBuyerSum() {
		return buyerSum;
	}
	public void setBuyerSum(Integer buyerSum) {
		this.buyerSum = buyerSum;
	}
	public Integer getExpected_time() {
		return expected_time;
	}
	public void setExpected_time(Integer expected_time) {
		this.expected_time = expected_time;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getMinTender() {
		return minTender;
	}
	public void setMinTender(Integer minTender) {
		this.minTender = minTender;
	}
	public Integer getSbAmt() {
		return sbAmt;
	}
	public void setSbAmt(Integer sbAmt) {
		this.sbAmt = sbAmt;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(Integer subscribe) {
		this.subscribe = subscribe;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [amount=" + amount + ", apr=" + apr + ", beginTime=" + beginTime + ", buyerSum=" + buyerSum
				+ ", expected_time=" + expected_time + ", id=" + id + ", minTender=" + minTender + ", sbAmt=" + sbAmt
				+ ", status=" + status + ", subscribe=" + subscribe + ", url=" + url + ", desc=" + desc + ", key=" + key
				+ ", name=" + name + ", period=" + period + ", tags=" + tags + "]";
	}
	
	

}
