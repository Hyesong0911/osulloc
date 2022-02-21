package org.osulloc.domain;

import java.util.ArrayList;

public class ProductReviewDTO {
	private int pno;
	private int prodnum;
	private String title;
	private String content;
	private String writer;
	private String regdate;
	private int good;
	private ArrayList<AttachFileDTO> attachList;
	
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getProdnum() {
		return prodnum;
	}
	public void setProdnum(int prodnum) {
		this.prodnum = prodnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}
	public ArrayList<AttachFileDTO> getAttachList() {
		return attachList;
	}
	public void setAttachList(ArrayList<AttachFileDTO> attachList) {
		this.attachList = attachList;
	}
	@Override
	public String toString() {
		return "ProductReviewDTO [pno=" + pno + ", prodnum=" + prodnum + ", title=" + title + ", content=" + content
				+ ", writer=" + writer + ", regdate=" + regdate + ", good=" + good + ", attachList=" + attachList + "]";
	}


	
}
