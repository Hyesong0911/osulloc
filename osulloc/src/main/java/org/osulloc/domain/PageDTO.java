package org.osulloc.domain;

public class PageDTO {

	//?? ??΄μ§? λ²νΈ
	private int startPage;
	//? ??΄μ§? λ²νΈ
	private int endPage;
	//?΄?  ??΄μ§? ? λ¬?
	private boolean prev;
	//?€? ??΄μ§? ? λ¬?
	private boolean next;
	//board??΄λΈμ μ΄? ?°?΄?° κ±΄μ
	private int total;
	//endPage??΄μ§?λ₯? κ³μ°?κΈ? ?? pageNum?΄ ???λ―?λ‘? Criteria?΄??€λ₯? ?¬?¨.
	private Criteria cri;
	
	
	public PageDTO(Criteria cri, int total){
		
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		this.startPage = this.endPage - 9;

		int realEnd = (int)(Math.ceil((total*1.0)/cri.getAmount())); 
		
		if(realEnd < endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd; 

	}

	

	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	//==================================================
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	@Override
	public String toString() {
		return "PageDTO [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", total=" + total + ", cri=" + cri + "]";
	}

	
}
