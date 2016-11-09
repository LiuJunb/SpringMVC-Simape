package com.xmg.touna.model;

public class Ad {

	private Long id;
	private Integer doNotDisturb;
	
	private Integer sequence;
	private Integer status;
	private Integer type;
	private String imgUrl;
	private String title;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getDoNotDisturb() {
		return doNotDisturb;
	}
	public void setDoNotDisturb(Integer doNotDisturb) {
		this.doNotDisturb = doNotDisturb;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Ad() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ad(Long id, Integer doNotDisturb, Integer sequence, Integer status, Integer type, String imgUrl,
			String title) {
		super();
		this.id = id;
		this.doNotDisturb = doNotDisturb;
		this.sequence = sequence;
		this.status = status;
		this.type = type;
		this.imgUrl = imgUrl;
		this.title = title;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", doNotDisturb=" + doNotDisturb + ", sequence=" + sequence + ", status=" + status
				+ ", type=" + type + ", imgUrl=" + imgUrl + ", title=" + title + "]";
	}

	
}
